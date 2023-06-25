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
import net.minecraft.world.entity.projectile.Snowball;
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

//	   public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand holdHand) {
//	      ItemStack itemstack = player.getItemInHand(holdHand);
//	      shootProjectile(level, player, holdHand);
//	      return InteractionResultHolder.consume(itemstack);
//	   }
	   
	   private static void shootProjectile(Level level, LivingEntity livingEntity, InteractionHand interactionHand) {
	      if (!level.isClientSide) {
	         Projectile bullet = new Bullet(level, livingEntity);
	         
	         bullet.shootFromRotation(livingEntity, livingEntity.getXRot(), livingEntity.getYRot(), 0.0F, 1.5F, 1.0F);
     
	         level.addFreshEntity(bullet);
	         level.playSound((Player)null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		  }
	   }
	   
	   public UseAnim getUseAnimation(ItemStack p_40678_) {
		   return UseAnim.NONE;
	   }
}