package net.kiragit01.testmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(5).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400), 0.50f).build();
}
