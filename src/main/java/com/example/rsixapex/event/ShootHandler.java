package com.example.rsixapex.event;

import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ShootHandler {
	private static ShootHandler instance;
	
	private ShootHandler() {}
	
	public static ShootHandler get() {
		if(instance == null) instance = new ShootHandler();
		return instance;
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onMouseClick(InputEvent.InteractionKeyMappingTriggered event) {
		System.out.println("test click");
	}

}
