package com.github.ayaan.shrunk.entity.client.renderer.layer;

import com.github.ayaan.shrunk.ShrunkMod;
import com.github.ayaan.shrunk.entity.client.model.OrchidMantisModel;
import com.github.ayaan.shrunk.entity.client.renderer.OrchidMantisRenderer;
import com.github.ayaan.shrunk.entity.custom.OrchidMantisEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class OrchidMantisSaddleLayer extends RenderLayer<OrchidMantisEntity, OrchidMantisModel<OrchidMantisEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(ShrunkMod.MOD_ID,"textures/entity/orchid_mantis/saddle/saddle.png");

    public OrchidMantisSaddleLayer(OrchidMantisRenderer orchidMantisRenderer) {
        super(orchidMantisRenderer);
    }

    public void render(PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn, OrchidMantisEntity mantis, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(mantis.isSaddled()){
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityCutout(TEXTURE));
            this.getParentModel().renderToBuffer(poseStack, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords( mantis, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}

