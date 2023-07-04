package com.example.rsixapex.entity;

import net.minecraft.Util;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
//import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;	
import net.minecraft.world.level.Level;

public abstract class Dectect_Arrow extends AbstractArrow implements ItemSupplier {
	   private static final EntityDataAccessor<ItemStack> DATA_ITEM_STACK = SynchedEntityData.defineId(Dectect_Arrow.class, EntityDataSerializers.ITEM_STACK);
	   
	   public Dectect_Arrow(EntityType<? extends Dectect_Arrow> p_36858_, Level p_36859_){
		   super(p_36858_, p_36859_);
	   }
	   
}
