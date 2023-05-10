package hanmin.testmod.block;

import java.util.function.Supplier;

import hanmin.testmod.TestMod;
import hanmin.testmod.item.TestItem;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MessageBlock extends Block {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
	public static final RegistryObject<Block> MESSAGE_BLOCK = registerBlockAndItem("message_block", () -> {
		return new MessageBlock();
	});
	
	public MessageBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL));
	}
	
	@Override
	public InteractionResult use(BlockState blockstate, Level level, BlockPos pos, Player player,
			InteractionHand hand, BlockHitResult blockHitResult) {
		if(!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            player.sendSystemMessage(Component.literal("Right Clicked this!"));
        }
		return super.use(blockstate, level, pos, player, hand, blockHitResult);
	}
	
	@Override
	public void stepOn(Level level, BlockPos pos, BlockState blockstate, Entity entity) {
		if(entity instanceof LivingEntity livingEntity) {
			
		}
		super.stepOn(level, pos, blockstate, entity);
	}
	
	private static <T extends Block> RegistryObject<T> registerBlockAndItem(String blockName, Supplier<T> block){
		RegistryObject<T> testBlockInstance = BLOCKS.register(blockName, block);
		TestItem.ITEMS.register( blockName, ()-> new BlockItem(testBlockInstance.get(), new Item.Properties()) );
		return testBlockInstance;
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}
