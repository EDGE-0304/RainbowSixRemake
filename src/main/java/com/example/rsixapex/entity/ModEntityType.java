package com.example.rsixapex.entity;

import com.example.rsixapex.RapexMod;
import com.google.common.collect.ImmutableSet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RapexMod.MODID);
    
    public static final RegistryObject<EntityType<BulletEntity>> BULLET = 
    		ENTITY_TYPES.register("bullet", 
    				() -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
    				.sized(1.0F, 1.0F).clientTrackingRange(4).updateInterval(10)
    				.build(new ResourceLocation(RapexMod.MODID, "bullet").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
