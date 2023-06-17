package com.example.rsixapex.items;

import com.example.rsixapex.RapexMod;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.entity.projectile.Snowball;

// The value here should match an entry in the META-INF/mods.toml file
public class ModItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, RapexMod.MODID);
	
	public static final RegistryObject<Item> TEST_GUN = ITEMS.register(
			"test_gun", () -> new Gun(new Item.Properties()));
	
	public static final RegistryObject<Item> BULLET = ITEMS.register(
			"bullet", () -> new BulletItem(new Item.Properties()));
	
    public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
