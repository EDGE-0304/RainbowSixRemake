package hanmin.testmod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;


public class CatBlock extends Block{

	public CatBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops());
	}
	
	@Override
	public InteractionResult use(BlockState blockstate, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult blockHitResult) {
		if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.literal("Right Clicked this!"));
            EntityType<Cat> entitytype = EntityType.CAT;
            ItemStack itemstack = player.getItemInHand(hand);
			Entity entity = entitytype.spawn((ServerLevel)level, itemstack , player, pos.above(), MobSpawnType.SPAWN_EGG, false, false);
        }
		return super.use(blockstate, level, pos, player, hand, blockHitResult);
	}
	
	
}
