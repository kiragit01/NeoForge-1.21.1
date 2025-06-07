package net.kiragit01.testmod.datagen;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.TagKey;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MAGICTEST.get());
        basicItem(ModItems.RAWMAGICTEST.get());

        basicItem(ModItems.FROSTFIRE_ICE.get());
        basicItem(ModItems.CHISEL_TOOL.get());
        basicItem(ModItems.COAL_PLUS.get());
        basicItem(ModItems.TOMATO.get());
    }
}
