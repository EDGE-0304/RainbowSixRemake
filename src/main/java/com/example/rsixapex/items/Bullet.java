package com.example.rsixapex.items;

import com.example.rsixapex.entity.ModEntityType;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class Bullet extends ThrowableItemProjectile {  
	
	public Bullet(EntityType<? extends Bullet> p_37391_, Level p_37392_) {
	      super(p_37391_, p_37392_);
	}
	
	public Bullet(Level level, LivingEntity player) {
		super(ModEntityType.BULLET.get(), player, level);
	}

	public Bullet(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
		super(ModEntityType.BULLET.get(), p_37395_, p_37396_, p_37397_, p_37394_);
	}
	
	protected Item getDefaultItem() {
		return ModItems.BULLET.get();
	}

	private ParticleOptions getParticle() {
		return (ParticleOptions)(ParticleTypes.FIREWORK );
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
	
	protected void onHitBlock(BlockHitResult hitResult) {
		super.onHitBlock(hitResult);
		if (!this.level.isClientSide) {
			Entity shooter = this.getOwner();
			if (!(shooter instanceof Mob) || net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, shooter)) {
				BlockPos blockpos = hitResult.getBlockPos().relative(hitResult.getDirection());
				if (this.level.isEmptyBlock(blockpos)) {
					PrimedTnt tnt = new PrimedTnt(this.level, (double)blockpos.getX() + 0.5D, (double)blockpos.getY(), (double)blockpos.getZ() + 0.5D, (LivingEntity) shooter);
//					
//					this.level.addFreshEntity(tnt);
				    this.level.explode(this, this.getX() + 0.5D, this.getY(), this.getZ() + 0.5D, 4.0F, Level.ExplosionInteraction.TNT);
				}
			}
		
		}
	}

	protected void onHit(HitResult hitResult) {
		super.onHit(hitResult);
		if (!this.level.isClientSide) {
			this.level.broadcastEntityEvent(this, (byte)3);
			this.discard();
		}
	}
	
	public boolean isPickable() {
		return false;
	}
	
	public boolean hurt(DamageSource source, float idkwtfthisis) {
		return false;
	}

}
