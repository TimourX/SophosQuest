package mod.timourx.sophosquest.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.client.model.FemaleMoofahModel;
import mod.timourx.sophosquest.entities.FemaleMoofahEntity;
import mod.timourx.sophosquest.util.anim.AnimUtils;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

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

        if (entityIn.isRunning()) {
            AnimUtils.translateY(matrixStackIn, partialTicks, 2f * (0.35f * 0.9f), 0.04f, 2.3f, 0f, entityIn);
        }
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }
}
