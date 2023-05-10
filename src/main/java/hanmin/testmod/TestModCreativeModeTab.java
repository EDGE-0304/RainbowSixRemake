package hanmin.testmod;

import hanmin.testmod.item.TestItem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModCreativeModeTab {
	
	public static CreativeModeTab MC_SPAWNER_TAB;
	
	@SubscribeEvent
	public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
		MC_SPAWNER_TAB = event.registerCreativeModeTab(
				new ResourceLocation(TestMod.MODID, "mc_spawner_tab"),
				builder -> builder.icon(() -> new ItemStack( TestItem.TEST_ITEM.get() ))
						.title(Component.translatable("creativemodetab.mc_spawner_tab"))
				);
	}
}
