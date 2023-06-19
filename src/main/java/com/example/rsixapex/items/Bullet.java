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

public class Bullet extends ThrowableItemProjectile {  
	
	public Bullet(EntityType<? extends Bullet> p_37391_, Level p_37392_) {
	      super(p_37391_, p_37392_);
	}
	
	public Bullet(Level p_37399_, LivingEntity p_37400_) {
		super(ModEntityType.BULLET.get(), p_37400_, p_37399_);
//		super(EntityType.SNOWBALL, p_37400_, p_37399_);
	}

	public Bullet(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
		super(ModEntityType.BULLET.get(), p_37395_, p_37396_, p_37397_, p_37394_);
//		super(EntityType.SNOWBALL, p_37395_, p_37396_, p_37397_, p_37394_);
	}
	
	protected Item getDefaultItem() {
		return ModItems.BULLET.get();
	}

	private ParticleOptions getParticle() {
		return (ParticleOptions)(ParticleTypes.ITEM_SNOWBALL );
	}

	public void handleEntityEvent(byte p_37402_) {
		if (p_37402_ == 3) {
			ParticleOptions particleoptions = this.getParticle();
			for(int i = 0; i < 8; ++i) {
				this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
			}
		}
	}

	protected void onHitEntity(EntityHitResult hitResult) {
		super.onHitEntity(hitResult);
		Entity entity = hitResult.getEntity();
		int i = entity instanceof Blaze ? 3 : 0;
		entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
	}

	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte)3);
			this.discard();
		}
	}

}
