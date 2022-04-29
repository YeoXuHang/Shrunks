package com.github.ayaan.shrunk.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_GRUB_MEAT = new FoodProperties.Builder().nutrition(2).saturationMod(0.2f).build();
    public static final FoodProperties COOKED_GRUB_MEAT = new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).build();
}
