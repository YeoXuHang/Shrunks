package com.github.ayaan.shrunk.item;

import com.github.ayaan.shrunk.ShrunkMod;
import com.github.ayaan.shrunk.entity.ShrunkModEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ShrunkModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ShrunkMod.MOD_ID);
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().tab(ShrunkModTab.SHRUNK_TAB)));


    //SpawnEgg
    public static final RegistryObject<ForgeSpawnEggItem> ORCHID_MANTIS_SPAWN_EGG = ITEMS.register("orchid_mantis_spawn_egg",
            () -> new ForgeSpawnEggItem(ShrunkModEntityTypes.ORCHID_MANTIS,13975924, 15656942,
                    new Item.Properties().tab(ShrunkModTab.SHRUNK_TAB)));

    public static final RegistryObject<Item> RAW_GRUB_MEAT = ITEMS.register("raw_grub_meat",
            () -> new Item(new Item.Properties().tab(ShrunkModTab.SHRUNK_TAB).food(ModFoods.RAW_GRUB_MEAT)));

    public static final RegistryObject<Item> COOKED_GRUB_MEAT = ITEMS.register("cooked_grub_meat",
            () -> new Item(new Item.Properties().tab(ShrunkModTab.SHRUNK_TAB).food(ModFoods.COOKED_GRUB_MEAT)));

    public static final RegistryObject<Item> RAW_SPRINGTAIL_LEG = ITEMS.register("raw_springtail_leg",
            () -> new Item(new Item.Properties().tab(ShrunkModTab.SHRUNK_TAB).food(ModFoods.RAW_SPRINGTAIL_LEG)));

    public static final RegistryObject<Item> COOKED_SPRINGTAIL_LEG = ITEMS.register("cooked_springtail_leg",
            () -> new Item(new Item.Properties().tab(ShrunkModTab.SHRUNK_TAB).food(ModFoods.COOKED_SPRINGTAIL_LEG)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}