package net.kiragit01.testmod.item;

import net.kiragit01.testmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier MAGICTEST = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_MAGIC_TOOL,
            2000, 43f, 35f, 78, () -> Ingredient.of(ModItems.MAGICTEST));
}
