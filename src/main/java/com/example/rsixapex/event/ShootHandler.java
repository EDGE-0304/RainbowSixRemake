package com.example.rsixapex.event;

import com.example.rsixapex.entity.BulletEntity;
import com.example.rsixapex.entity.ModEntityType;
import com.example.rsixapex.entity.ProjectileEntity;
import com.example.rsixapex.items.Gun;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ShootHandler {
	private static ShootHandler instance;
	private boolean shooting;
	
	private ShootHandler() {}
	
	public static ShootHandler get() {
		if(instance == null) instance = new ShootHandler();
		return instance;
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onMouseClick(InputEvent.InteractionKeyMappingTriggered e) {
		
		Player player = Minecraft.getInstance().player;
		if(player == null) return;
		
		if(e.isAttack()) { // left click
			ItemStack handItem = player.getMainHandItem();
			if(handItem.getItem() instanceof Gun) {
				e.setSwingHand(false);
				e.setCanceled(true);
				this.fire(player, handItem);
			}
		}else if(e.isUseItem()) { // right
			player.sendSystemMessage(Component.literal("right click"));
		}
	}
	
	@SubscribeEvent
	public void HandleOnShoot(TickEvent.ClientTickEvent e) {
		if(e.phase != TickEvent.Phase.START) return;
		Minecraft mc = Minecraft.getInstance();
		Player player = mc.player;
		if(player != null) {
			ItemStack handItem = player.getMainHandItem();
			if(handItem.getItem() instanceof Gun) {
				if(mc.options.keyAttack.isDown()) {
					if(!this.shooting) {
						this.shooting = true;
						this.handleShoot(player);
					}
				}else if(this.shooting) {
					this.shooting = false;
					this.handleShoot(player);
				}
			}
		}else {
			this.shooting = false;
		}
	}
	
	@SubscribeEvent
	public void HandlePostShoot(TickEvent.ClientTickEvent e) {
		if(e.phase != TickEvent.Phase.END) return;
		Minecraft mc = Minecraft.getInstance();
		Player player = mc.player;
		if(player != null) {
			ItemStack handItem = player.getMainHandItem();
			if(handItem.getItem() instanceof Gun) {
				if(mc.options.keyAttack.isDown()) {
					this.fire(player, handItem);
				}
			}
		}else {
			this.shooting = false;
		}
	}

	private void handleShoot(Player player) {
		
		float rotationYaw = player.getYRot();
		float rotationPit = player.getXRot();
		
		Level world = player.level;
		ItemStack holdItem = player.getMainHandItem();
		if(holdItem.getItem() instanceof Gun gun) {
			System.out.println("handling shooting holding a gun");
			
			if(MinecraftForge.EVENT_BUS.post(new ShootEvent.OnShoot(player))) {
				return;
			}
			System.out.println("handling shooting holding a gun2");
			
			player.setYRot(Mth.wrapDegrees(rotationYaw));
			player.setXRot(Mth.clamp(rotationPit, 0F, 0F));
			
//			ProjectileEntity bullet = new ProjectileEntity(ModEntityType.BULLET.get(), world);
			BulletEntity bullet = new BulletEntity(EntityType.SMALL_FIREBALL, world);
			world.addFreshEntity(bullet);
			bullet.tick();
			
			MinecraftForge.EVENT_BUS.post(new ShootEvent.PostShoot(player));
			
			world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
		}
		
	}

	private void fire(Player player, ItemStack handItem) {
		player.sendSystemMessage(Component.literal("fire"));
		
		if(MinecraftForge.EVENT_BUS.post(new ShootEvent.OnShoot(player))) {
			return;
		}
		
		this.handleShoot(player);
		
		MinecraftForge.EVENT_BUS.post(new ShootEvent.PostShoot(player));
		
	}

}
