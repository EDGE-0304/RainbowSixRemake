package hanmin.testmod.item.custom;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class CustomArrow extends AbstractArrow {
	
	private final Set<MobEffectInstance> effects = Sets.newHashSet();
	
	public CustomArrow(EntityType<? extends CustomArrow> p_36858_, Level p_36859_) {
		super(p_36858_, p_36859_);
	}

	public CustomArrow(Level p_36861_, double p_36862_, double p_36863_, double p_36864_) {
		super(EntityType.ARROW, p_36862_, p_36863_, p_36864_, p_36861_);
	}

	public CustomArrow(Level p_36866_, LivingEntity p_36867_) {
		super(EntityType.ARROW, p_36867_, p_36866_);
	}
	
	public void tick() {
		super.tick();
		if (this.level.isClientSide) {
			if (this.inGround) {
				this.level.explode(getControllingPassenger(), null, null, DEFAULT_BB_HEIGHT, BREATHING_DISTANCE_BELOW_EYES, BOARDING_COOLDOWN, BASE_TICKS_REQUIRED_TO_FREEZE, firstTick, null, blocksBuilding);
			}
		} else if (this.inGround && this.inGroundTime != 0 && !this.effects.isEmpty() && this.inGroundTime >= 600) {
			this.level.broadcastEntityEvent(this, (byte)0);
			this.effects.clear();
		}
	}
	
	protected ItemStack getPickupItem() {
	      if (this.effects.isEmpty()) {
	         return new ItemStack(Items.ARROW);
	      } else {
	         ItemStack itemstack = new ItemStack(Items.TIPPED_ARROW);

	         return itemstack;
	      }
	   }
	
}
