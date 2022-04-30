package com.github.ayaan.shrunk.entity.client.renderer;

import com.github.ayaan.shrunk.ShrunkMod;
import com.github.ayaan.shrunk.entity.client.model.OrchidMantisModel;
import com.github.ayaan.shrunk.entity.client.renderer.layer.OrchidMantisSaddleLayer;
import com.github.ayaan.shrunk.entity.custom.OrchidMantisEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OrchidMantisRenderer extends MobRenderer<OrchidMantisEntity, OrchidMantisModel<OrchidMantisEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(ShrunkMod.MOD_ID,
            "textures/entity/orchid_mantis/orchid_mantis.png");


    public OrchidMantisRenderer(EntityRendererProvider.Context context) {
        super(context, new OrchidMantisModel<>(context.bakeLayer(OrchidMantisModel.LAYER_LOCATION)), 0.7F);
        this.addLayer(new OrchidMantisSaddleLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(OrchidMantisEntity entity)
    {
        return TEXTURE;
    }
}