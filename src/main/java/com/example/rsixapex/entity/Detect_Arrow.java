package com.example.rsixapex.entity;

import net.minecraft.Util;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
//import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;	
import net.minecraft.world.level.Level;

public abstract class Detect_Arrow extends AbstractArrow implements ItemSupplier {
	   private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(Detect_Arrow.class, EntityDataSerializers.ITEM_STACK);
	   
	   public Detect_Arrow(EntityType<? extends Detect_Arrow> p_36858_, Level p_36859_){
		   super(p_36858_, p_36859_);
	   }
	   
	   public Detect_Arrow(EntityType<? extends Detect_Arrow>p_36861_, double p_36862_, double p_36863_, double p_36864_, Level p_3000_){
		   super(p_36861_, p_36862_, p_36863_,p_36864_, p_3000_);
		  
	   }
	   
	   public Detect_Arrow(EntityType<? extends Detect_Arrow>p_34555_, LivingEntity p_36867_, Level p_36866_) {
		   super(p_34555_, p_36867_, p_36866_);
	   }
	   
	   
}
