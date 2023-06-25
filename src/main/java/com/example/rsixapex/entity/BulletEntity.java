package com.example.rsixapex.entity;

import java.util.List;
import java.util.function.BiFunction;

import com.example.rsixapex.items.Gun;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;

public class BulletEntity extends Entity {
	
	private LivingEntity shooter;
	private EntityDimensions entitySize;

	public BulletEntity(EntityType<? extends Entity> entityType, Level world) {
		super(entityType, world);
	}
	
	public BulletEntity(EntityType<? extends Entity> entityType, Level world, LivingEntity shooter) {
		super(entityType, world);
		this.shooter = shooter;
		this.entitySize = new EntityDimensions(10F, 10F, true);
		
		Vec3 dir = this.getDirection(shooter);
		/* Spawn the projectile half way between the previous and current position */
        double posX = shooter.xOld + (shooter.getX() - shooter.xOld) / 2.0;
        double posY = shooter.yOld + (shooter.getY() - shooter.yOld) / 2.0 + shooter.getEyeHeight();
        double posZ = shooter.zOld + (shooter.getZ() - shooter.zOld) / 2.0;
        this.setPos(posX, posY, posZ);
        
	}
	
	@Override
	public EntityDimensions getDimensions(Pose pose) {
		return this.entitySize;
	}
	
	private Vec3 getDirection(LivingEntity shooter) {
		return this.getVectorFromRotation(shooter.getXRot(), shooter.getYRot());
	}
	
	/* Thanks to MrCrayfish */
	private Vec3 getVectorFromRotation(float pit, float yaw) {
		float f = Mth.cos(-yaw * 0.017453292F - (float) Math.PI);
        float f1 = Mth.sin(-yaw * 0.017453292F - (float) Math.PI);
        float f2 = -Mth.cos(-pit * 0.017453292F);
        float f3 = Mth.sin(-pit * 0.017453292F);
		return new Vec3(f1*f2, f3, f*f2);
	}
	
	@Override
	public void tick() {
		super.tick();
		if(! this.level.isClientSide()) {
			Vec3 startVec = this.position();
			Vec3 endVec = startVec.add(this.getDeltaMovement());
			HitResult result = rayTraceBlocks();
			if(result.getType() != HitResult.Type.MISS) {
				endVec = result.getLocation();
			}
			
		}
	}

	private HitResult rayTraceBlocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void defineSynchedData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag p_20052_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag p_20139_) {
		// TODO Auto-generated method stub
		
	}
	
	

}
