package net.kiragit01.testmod.util;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.component.ModDataComponent;
import net.kiragit01.testmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL_TOOL.get(), ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponent.COORDINATES) != null ? 1f : 0f);
    }
}
