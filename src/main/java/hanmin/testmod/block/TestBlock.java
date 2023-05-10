package hanmin.testmod.block;

import java.util.function.Supplier;



import hanmin.testmod.TestMod;
import hanmin.testmod.block.ChickenBlock;
import hanmin.testmod.block.CatBlock;
import hanmin.testmod.item.TestItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.BedBlock;

public class TestBlock extends Block {
	public TestBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops());
	}

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
	

	public static final RegistryObject<Block> TEST_BLOCK = registerBlockAndItem("test_block", () -> {
		return new TestBlock();
	});
	public static final RegistryObject<Block> PIGSPAWNER_BLOCK = registerBlockAndItem("pigspawner_block", () -> {
		return new PigSpawnerBlock();
	});
	public static final RegistryObject<Block> HORSESPAWNER_BLOCK = registerBlockAndItem("horsespawner_block", () -> {
		return new HorseSpawnerBlock();
	});
	
	
	
	
	//Chicken Spawner
	public static final RegistryObject<Block> CHICKEN_BLOCK = registerBlockAndItem("chicken_block", () -> {
		return new ChickenBlock();
	});
	
	//Cat Spawner
	public static final RegistryObject<Block> CAT_BLOCK = registerBlockAndItem("cat_block", () -> {
		return new CatBlock();
	});
	
	public static final RegistryObject<Block> WOLF_BLOCK = registerBlockAndItem("wolf_block", () -> {
		return new WolfBlock();
	});

	public static final RegistryObject<Block> VILLAGER_BLOCK = registerBlockAndItem("villager_block", () -> {
		return new VillagerBlock();
	});
	
	public static final RegistryObject<Block> RABBIT_BLOCK = registerBlockAndItem("rabbit_block", () -> {
		return new RabbitBlock();
	});
	
	public static final RegistryObject<Block> TURTLE_BLOCK = registerBlockAndItem("turtle_block", () -> {
		return new TurtleBlock();
	});

	public static final RegistryObject<Block> FOX_BLOCK = registerBlockAndItem("fox_block", () -> {
		return new FoxBlock();
	});
	
	public static final RegistryObject<Block> BAT_BLOCK = registerBlockAndItem("bat_block", () -> {
		return new BatBlock();
	});
	
	private static <T extends Block> RegistryObject<T> registerBlockAndItem(String blockName, Supplier<T> block){
		RegistryObject<T> testBlockInstance = BLOCKS.register(blockName, block);
		TestItem.ITEMS.register( blockName, ()-> new BlockItem(testBlockInstance.get(), new Item.Properties()) );
		return testBlockInstance;
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}
}