package com.example.rsixapex.event;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ShootEvent extends PlayerEvent {

	public ShootEvent(Player player) {
		super(player);
	}
	
	public static class OnShoot extends ShootEvent{
		public OnShoot(Player player) {
			super(player);
		}
	}
	
	public static class PostShoot extends ShootEvent{
		public PostShoot(Player player) {
			super(player);
		}
	}

}
