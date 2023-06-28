package com.example.rsixapex.items;

import com.example.rsixapex.entity.ModEntityType;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.registries.RegistryObject;


public class detect_arrow extends ThrowableItemProjectile {

	public detect_arrow(EntityType<? extends ThrowableItemProjectile> p_37432_, double p_37433_, double p_37434_,
			double p_37435_, Level p_37436_) {
		super(p_37432_, p_37433_, p_37434_, p_37435_, p_37436_);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Item getDefaultItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
