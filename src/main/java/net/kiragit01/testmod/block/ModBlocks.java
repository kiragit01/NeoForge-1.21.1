package net.kiragit01.testmod.block;

import net.kiragit01.testmod.TestMod;
import net.kiragit01.testmod.block.custom.MagicBlock;
import net.kiragit01.testmod.block.custom.MagicLampBlock;
import net.kiragit01.testmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TestMod.MODID);

    public static final DeferredBlock<Block> MAGICTEST_BLOCK = registerBlock("magictest_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .destroyTime(1f)
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> MAGICTEST_ORE = registerBlock("magictest_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,10),
                    BlockBehaviour.Properties.of()
                            .strength(0.1f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.GLASS)));

    public static final DeferredBlock<Block> MAGICTEST_DEEPSLATE_ORE = registerBlock("magictest_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,10),
                    BlockBehaviour.Properties.of()
                            .strength(0.1f)
                            .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(2f)));

    public static final DeferredBlock<Block> MAGIC_LAMP_BLOCK = registerBlock("magic_lamp_block",
            () -> new MagicLampBlock(BlockBehaviour.Properties.of().strength(0.1f)
                    .lightLevel(state -> state.getValue(MagicLampBlock.CLICKED) ? 15 : 0)));

//    public static final DeferredBlock<Block> CUCUMBER_BLOCK = registerBlock("magictest_deepslate_ore",
//            () -> new DropExperienceBlock(UniformInt.of(2,10),
//                    BlockBehaviour.Properties.of()
//                            .strength(0.1f)
//                            .requiresCorrectToolForDrops()
//                            .sound(SoundType.GLASS)));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
