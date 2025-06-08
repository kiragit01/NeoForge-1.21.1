package net.kiragit01.testmod.datagen;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.block.ModBlocks;
import net.kiragit01.testmod.block.custom.MagicLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
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

        customLamp();
    }


    private void customLamp() {
        getVariantBuilder(ModBlocks.MAGIC_LAMP_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(MagicLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("magic_lamp_block_on",
                        ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "block/" + "magic_lamp_block_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("magic_lamp_block_off",
                        ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "block/" + "magic_lamp_block_off")))};
            }
        });

        simpleBlockItem(ModBlocks.MAGIC_LAMP_BLOCK.get(), models().cubeAll("magic_lamp_block_on",
                ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "block/" + "magic_lamp_block_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
