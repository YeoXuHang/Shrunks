package com.github.ayaan.shrunk.event;

import com.github.ayaan.shrunk.ShrunkMod;
import com.github.ayaan.shrunk.entity.ShrunkModEntityTypes;
import com.github.ayaan.shrunk.entity.custom.OrchidMantisEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ShrunkMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ShrunkModEvenBusEevnts {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ShrunkModEntityTypes.ORCHID_MANTIS.get(), OrchidMantisEntity.setAttributes());
    }
}