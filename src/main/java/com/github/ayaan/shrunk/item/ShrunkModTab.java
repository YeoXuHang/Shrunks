package com.github.ayaan.shrunk.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ShrunkModTab {
    public static final CreativeModeTab SHRUNK_TAB = new CreativeModeTab("shrunk_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ShrunkModItems.EXAMPLE_ITEM.get());
        }
    };
}

