package net.kiragit01.testmod.datagen;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.MAGICTEST_BLOCK.get())
                .add(ModBlocks.MAGICTEST_DEEPSLATE_ORE.get())
                .add(ModBlocks.MAGICTEST_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.MAGICTEST_ORE.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.MAGICTEST_DEEPSLATE_ORE.get());


    }
}
