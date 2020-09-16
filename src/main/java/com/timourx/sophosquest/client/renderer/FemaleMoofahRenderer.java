package com.timourx.sophosquest.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.timourx.sophosquest.SophosQuest;
import com.timourx.sophosquest.client.model.FemaleMoofahModel;
import com.timourx.sophosquest.entities.FemaleMoofahEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class FemaleMoofahRenderer extends MobRenderer<FemaleMoofahEntity, FemaleMoofahModel<FemaleMoofahEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(SophosQuest.MOD_ID, "textures/entity/female_moofah.png");

    public FemaleMoofahRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new FemaleMoofahModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(FemaleMoofahEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(FemaleMoofahEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        float globalSpeed = 1.0f;
        float globalHeight = 1.0f;

        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
