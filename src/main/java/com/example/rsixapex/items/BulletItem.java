package com.example.rsixapex.items;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BulletItem extends Item {
	public BulletItem(Item.Properties p_43140_) {
	      super(p_43140_);
	   }
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand p_43144_) {
      ItemStack itemstack = player.getItemInHand(p_43144_);
      world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
      if (!world.isClientSide) {
//         Bullet bullet = new Bullet(p_43142_, p_43143_);
//         bullet.setItem(itemstack);
//         bullet.shootFromRotation(p_43143_, p_43143_.getXRot(), p_43143_.getYRot(), 0.0F, 1.5F, 1.0F);
//         p_43142_.addFreshEntity(bullet);
    	  Bullet snowball = new Bullet(world, player);
          snowball.setItem(itemstack);
          snowball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
          world.addFreshEntity(snowball);
      }

      player.awardStat(Stats.ITEM_USED.get(this));
      if (!player.getAbilities().instabuild) {
         itemstack.shrink(1);
      }

      return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
   }
}
