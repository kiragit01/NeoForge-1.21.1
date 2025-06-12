package net.kiragit01.testmod.item;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.item.custom.ChiselToolItem;
import net.kiragit01.testmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SimpleTier;
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

    public static final DeferredItem<SwordItem> MAGIC_SWORD = ITEMS.register("magic_sword",
            () -> new SwordItem(ModToolTiers.MAGICTEST,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.MAGICTEST, 65, 5f))));
    public static final DeferredItem<PickaxeItem> MAGIC_PICKAXE = ITEMS.register("magic_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MAGICTEST,
                    new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.MAGICTEST, 15, -2.6f))));
    public static final DeferredItem<AxeItem> MAGIC_AXE = ITEMS.register("magic_axe",
            () -> new AxeItem(ModToolTiers.MAGICTEST,
                    new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.MAGICTEST, 95, -1.6f))));
    public static final DeferredItem<HoeItem> MAGIC_HOE = ITEMS.register("magic_hoe",
            () -> new HoeItem(ModToolTiers.MAGICTEST,
                    new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.MAGICTEST, 5, -2.6f))));
    public static final DeferredItem<ShovelItem> MAGIC_SHOVEL = ITEMS.register("magic_shovel",
            () -> new ShovelItem(ModToolTiers.MAGICTEST,
                    new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.MAGICTEST, 9, -2.6f))));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
