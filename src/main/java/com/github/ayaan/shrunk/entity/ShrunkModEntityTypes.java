package com.github.ayaan.shrunk.entity;

import com.github.ayaan.shrunk.ShrunkMod;

import com.github.ayaan.shrunk.entity.custom.OrchidMantisEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ShrunkModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, ShrunkMod.MOD_ID);

    public static final RegistryObject<EntityType<OrchidMantisEntity>> ORCHID_MANTIS = ENTITY_TYPES.register("orchid_mantis",
            () -> EntityType.Builder.of(OrchidMantisEntity::new, MobCategory.CREATURE)
                    .sized(0.7f, 4f)
                    .build(new ResourceLocation(ShrunkMod.MOD_ID, "orchid_mantis").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
