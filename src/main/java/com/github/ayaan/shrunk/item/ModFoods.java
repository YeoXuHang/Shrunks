package com.github.ayaan.shrunk.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_GRUB_MEAT = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).meat().build();
    public static final FoodProperties COOKED_GRUB_MEAT = new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).meat().build();
    public static final FoodProperties RAW_SPRINGTAIL_LEG = new FoodProperties.Builder().nutrition(1).saturationMod(0.2f).effect(new MobEffectInstance(MobEffects.POISON, 400, 1), 1.0F).meat().build();
    public static final FoodProperties COOKED_SPRINGTAIL_LEG = new FoodProperties.Builder().nutrition(4).saturationMod(0.4f).meat().build();
}
