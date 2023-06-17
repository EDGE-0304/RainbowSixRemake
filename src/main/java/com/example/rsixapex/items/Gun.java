package com.example.rsixapex.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Gun extends Item {
	   public Gun(Item.Properties p) {
	      super(p);
	   }

	   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand holdHand) {
	      ItemStack itemstack = player.getItemInHand(holdHand);
	      level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
	      if (!level.isClientSide) {
	         Bullet bullet= new Bullet(level, player);
//	         bullet.setItem(itemstack);
	         bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
	         level.addFreshEntity(bullet);
	      }

	      player.awardStat(Stats.ITEM_USED.get(this));
	      if (!player.getAbilities().instabuild) {
	         itemstack.shrink(1);
	      }

	      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	   }
}