package edge.rsixremake.weapon;

import java.util.function.Supplier;
import edge.rsixremake.rsixmain;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class weapon extends Item {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, rsixmain.MODID);
	
	public weapon() {
		super(new Properties());
	}
	
	//add items here
	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}
}
