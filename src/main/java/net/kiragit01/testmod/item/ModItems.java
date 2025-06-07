package net.kiragit01.testmod.item;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.item.custom.ChiselToolItem;
import net.kiragit01.testmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);
    public static final DeferredItem<Item> MAGICTEST = ITEMS.register("magictest",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAWMAGICTEST = ITEMS.register("raw_magictest",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHISEL_TOOL = ITEMS.register("chisel_tool",
            () -> new ChiselToolItem(new Item.Properties().durability(50)));
    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TOMATO)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.testmod.tomato"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.register("frostfire_ice",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final DeferredItem<Item> COAL_PLUS = ITEMS.register("coal_plus",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
