package com.github.ayaan.shrunk.event;

import com.github.ayaan.shrunk.ShrunkMod;
import com.github.ayaan.shrunk.entity.client.model.OrchidMantisModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ShrunkMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ShrunkClientModEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OrchidMantisModel.LAYER_LOCATION, OrchidMantisModel::createBodyLayer);
    }
}
