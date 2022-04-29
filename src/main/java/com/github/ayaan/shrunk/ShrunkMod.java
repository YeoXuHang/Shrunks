package com.github.ayaan.shrunk;

import com.github.ayaan.shrunk.entity.ShrunkModEntityTypes;
import com.github.ayaan.shrunk.entity.client.renderer.OrchidMantisRenderer;
import com.github.ayaan.shrunk.item.ShrunkModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(ShrunkMod.MOD_ID)
public class ShrunkMod {

    public static final String MOD_ID = "shrunk";
    private static final Logger LOGGER = LogManager.getLogger();

    public ShrunkMod() {
        //EventBus
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ShrunkModItems.register(eventBus);
        ShrunkModEntityTypes.register(eventBus);

        eventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        //Renderer for entity
        EntityRenderers.register(ShrunkModEntityTypes.ORCHID_MANTIS.get(), OrchidMantisRenderer::new);
    }
}
