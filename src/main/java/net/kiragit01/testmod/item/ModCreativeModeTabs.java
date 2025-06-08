package net.kiragit01.testmod.item;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final Supplier<CreativeModeTab> MAGICTEST_ITEMS_TAB = CREATIVE_MODE_TAB.register("magictest_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MAGICTEST.get()))
                    .title(Component.translatable("creativetab.testmod.magictest_items"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModItems.MAGICTEST);
                        output.accept(ModItems.RAWMAGICTEST);
                        output.accept(ModItems.CHISEL_TOOL);
                        output.accept(ModItems.TOMATO);
                        output.accept(ModItems.FROSTFIRE_ICE);
                        output.accept(ModItems.COAL_PLUS);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> MAGICTEST_BLOCKS_TAB = CREATIVE_MODE_TAB.register("magictest_blocks_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "magictest_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.MAGICTEST_BLOCK.get()))
                    .title(Component.translatable("creativetab.testmod.magictest_blocks"))
                    .displayItems((itemDisplayParameters, output)-> {
                        output.accept(ModBlocks.MAGICTEST_BLOCK);
                        output.accept(ModBlocks.MAGICTEST_ORE);
                        output.accept(ModBlocks.MAGICTEST_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.MAGIC_LAMP_BLOCK);
                    })
                    .build());
    
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
