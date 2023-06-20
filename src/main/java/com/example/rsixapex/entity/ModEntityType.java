package com.example.rsixapex.entity;

import com.example.rsixapex.RapexMod;
import com.example.rsixapex.items.Bullet;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RapexMod.MODID);
    
    public static final RegistryObject<EntityType<Bullet>> BULLET = 
    		ENTITY_TYPES.register("bullet", 
    				() -> EntityType.Builder.<Bullet>of(Bullet::new, MobCategory.MISC)
    				.sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
    				.build(new ResourceLocation(RapexMod.MODID, "bullet").toString()) );


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
