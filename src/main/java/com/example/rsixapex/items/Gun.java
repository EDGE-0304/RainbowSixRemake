package com.example.rsixapex.items;

import org.joml.Quaternionf;
import org.joml.Vector3f;

import com.example.rsixapex.entity.BulletEntity;
import com.example.rsixapex.entity.ModEntityType;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;

public class Gun extends Item {
	   public Gun(Item.Properties p) {
	      super(p);
	   }

	   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand holdHand) {
	      ItemStack itemstack = player.getItemInHand(holdHand);
	      
	      shootProjectile(level, player, holdHand);
	      
//	      if (!level.isClientSide) {
//	    	 Bullet bullet= new Bullet(ModEntityType.BULLET.get(), level);
//	         bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
//	         level.addFreshEntity(bullet);
//	      }

//	      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	      return InteractionResultHolder.consume(itemstack);
	   }
	   
	   private static void shootProjectile(Level level, LivingEntity livingEntity, InteractionHand interactionHand
//			   ,ItemStack itemStack1, ItemStack itemStack2, float p_40900_, boolean p_40901_, float p_40902_, float p_40903_, float p_40904_
			   ) {
	      if (!level.isClientSide) {
	         Projectile bullet = new BulletEntity(ModEntityType.BULLET.get(), level);
	         
//            Vec3 vec31 = livingEntity.getUpVector(1.0F);
//            Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double)(p_40904_ * ((float)Math.PI / 180F)), vec31.x, vec31.y, vec31.z);
//            Vec3 vec3 = livingEntity.getViewVector(1.0F);
//            Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
	        bullet.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot(), 0.0F, 1.5F, 1.0F);
//            bullet.shoot((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), p_40902_, p_40903_);
	         

//	         itemStack1.hurtAndBreak(flag ? 3 : 1, livingEntity, (p_40858_) -> {
//	            p_40858_.broadcastBreakEvent(interactionHand);
//	         });
	         level.addFreshEntity(bullet);
	         level.playSound((Player)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
//		         level.playSound((Player)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.CROSSBOW_SHOOT, SoundSource.PLAYERS, 1.0F, p_40900_);
	      }
	   }
	   
	   public UseAnim getUseAnimation(ItemStack p_40678_) {
		   return UseAnim.NONE;
	   }
}