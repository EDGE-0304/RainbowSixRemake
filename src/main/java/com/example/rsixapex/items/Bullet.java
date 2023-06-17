package com.example.rsixapex.items;

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

public class Bullet extends Projectile {  
	
	public Bullet(EntityType<? extends Projectile> p_37391_, Level p_37392_) {
	      super(p_37391_, p_37392_);
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

	   protected void onHitEntity(EntityHitResult p_37404_) {
	      super.onHitEntity(p_37404_);
	      Entity entity = p_37404_.getEntity();
	      int i = entity instanceof Blaze ? 3 : 0;
	      entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
	   }

	   protected void onHit(HitResult p_37406_) {
	      super.onHit(p_37406_);
	      if (!this.level.isClientSide) {
	         this.level.broadcastEntityEvent(this, (byte)3);
	         this.discard();
	      }

	   }

	@Override
	protected void defineSynchedData() {
		// TODO Auto-generated method stub
		
	}
	}
