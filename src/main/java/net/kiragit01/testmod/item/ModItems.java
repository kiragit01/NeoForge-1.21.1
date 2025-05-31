package net.kiragit01.testmod.item;

import net.kiragit01.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);
    public static final DeferredItem<Item> MAGICTEST = ITEMS.register("magictest",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAWMAGICTEST = ITEMS.register("raw_magictest",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
