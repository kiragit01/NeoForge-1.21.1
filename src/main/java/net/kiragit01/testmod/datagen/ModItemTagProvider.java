package net.kiragit01.testmod.datagen;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.item.ModItems;
import net.kiragit01.testmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags,
                              @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.RAWMAGICTEST.get())
                .add(ModItems.TOMATO.get())
                .add(Items.COAL)
                .add(Items.STICK);

        tag(ItemTags.SWORDS)
                .add(ModItems.MAGIC_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.MAGIC_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.MAGIC_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.MAGIC_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.MAGIC_HOE.get());


    }
}
