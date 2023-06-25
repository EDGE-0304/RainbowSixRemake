package com.example.rsixapex.client;

import com.example.rsixapex.RapexMod;
import com.example.rsixapex.event.ShootHandler;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RapexMod.MODID, value = Dist.CLIENT)
public class ClientHandler {
	
	public static void setup() {
		MinecraftForge.EVENT_BUS.register(ShootHandler.get());
	}

}
