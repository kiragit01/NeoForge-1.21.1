package net.kiragit01.testmod.datagen;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.MossBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGIC_BLOCK);

        blockWithItem(ModBlocks.MAGICTEST_BLOCK);

        blockWithItem(ModBlocks.MAGICTEST_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.MAGICTEST_ORE);
    }


    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
