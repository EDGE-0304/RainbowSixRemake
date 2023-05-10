package hanmin.testmod;


import hanmin.testmod.block.MessageBlock;



import hanmin.testmod.block.TestBlock;
import hanmin.testmod.item.TestItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TestMod.MODID)
public class TestMod {
	
	public static final String MODID = "testmod";
	
	public TestMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		TestItem.ITEMS.register(modEventBus);

		TestBlock.BLOCKS.register(modEventBus);

		MessageBlock.BLOCKS.register(modEventBus);

		MinecraftForge.EVENT_BUS.register(this);
		
		modEventBus.addListener(this::addCreative);
	}
	
	private void addCreative(CreativeModeTabEvent.BuildContents e) {
		System.out.println("creativeTab");
		if(e.getTab() == CreativeModeTabs.INGREDIENTS) {
			
			e.accept(TestItem.PIG_SPAWNER);
			e.accept(TestItem.WOLF_SPAWNER);
			e.accept(TestItem.VILLAGER_SPAWNER);
			e.accept(TestItem.CHICKEN_SPAWNER);
			e.accept(TestItem.RABBIT_SPAWNER);
			e.accept(TestItem.HORSE_SPAWNER);
			e.accept(TestItem.CAT_SPAWNER);
			e.accept(TestItem.TURTLE_SPAWNER);
			e.accept(TestItem.FOX_SPAWNER);
			e.accept(TestItem.BAT_SPAWNER);

		}
		if(e.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
			e.accept(TestBlock.TEST_BLOCK);
			e.accept(TestBlock.VILLAGER_BLOCK);			       
            e.accept(TestBlock.CHICKEN_BLOCK);
            e.accept(TestBlock.CAT_BLOCK);
            e.accept(TestBlock.WOLF_BLOCK);
			e.accept(TestBlock.PIGSPAWNER_BLOCK);
			e.accept(TestBlock.HORSESPAWNER_BLOCK);
			e.accept(TestBlock.RABBIT_BLOCK);
			e.accept(TestBlock.TURTLE_BLOCK);
			e.accept(TestBlock.FOX_BLOCK);
			e.accept(TestBlock.BAT_BLOCK);



		}
		
		if(e.getTab() == TestModCreativeModeTab.MC_SPAWNER_TAB) {
			
			e.accept(TestItem.PIG_SPAWNER);
			e.accept(TestItem.WOLF_SPAWNER);
			e.accept(TestItem.VILLAGER_SPAWNER);
			e.accept(TestItem.CHICKEN_SPAWNER);
			e.accept(TestItem.RABBIT_SPAWNER);
			e.accept(TestItem.HORSE_SPAWNER);
			e.accept(TestItem.CAT_SPAWNER);
			e.accept(TestItem.TURTLE_SPAWNER);
			e.accept(TestItem.FOX_SPAWNER);
			e.accept(TestItem.BAT_SPAWNER);
			e.accept(TestBlock.TEST_BLOCK);
			e.accept(TestBlock.VILLAGER_BLOCK);			       
            e.accept(TestBlock.CHICKEN_BLOCK);
            e.accept(TestBlock.CAT_BLOCK);
            e.accept(TestBlock.WOLF_BLOCK);
			e.accept(TestBlock.PIGSPAWNER_BLOCK);
			e.accept(TestBlock.HORSESPAWNER_BLOCK);
			e.accept(TestBlock.RABBIT_BLOCK);
			e.accept(TestBlock.TURTLE_BLOCK);
			e.accept(TestBlock.FOX_BLOCK);
			e.accept(TestBlock.BAT_BLOCK);

		}
	}
}
