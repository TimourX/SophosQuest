package mod.timourx.sophosquest.util.anim;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.timourx.sophosquest.SophosQuest;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

public class AnimUtils {

    private final Map<ModelRenderer, Float[]> initRotation = new HashMap<>();
    private boolean shouldUpdate = false;
    private boolean stop = false;
    private float reset;
    private String id = null;

    public AnimUtils(ModelRenderer[] modelRenderers) {
        for (ModelRenderer model : modelRenderers) {
            this.initRotation.put(model, new Float[]{model.rotateAngleX, model.rotateAngleY, model.rotateAngleZ});
        }
    }

    public void rotateAngleX(ModelRenderer model, float speed, float degree, boolean invert, float offset, float weight, float limbSwing, float limbSwingAmount) {
        float result = degree * MathHelper.cos(limbSwing * speed + offset) + weight * limbSwingAmount;
        model.rotateAngleX = (invert ? -result : result) + this.initRotation.get(model)[0];
    }

    /*
    public float rotateAngleX(ModelRenderer model, float speed, float degree, boolean invert, float offset, float weight, float limbSwing, float limbSwingAmount, float condition, float speed2) {
        float result;
        if (this.shouldUpdate) {
            this.reset = limbSwing;
            this.shouldUpdate = false;
        }
        if (limbSwing - this.reset < Math.PI && !this.stop) {
            result = degree * MathHelper.cos(limbSwing * speed + offset) + weight * limbSwingAmount;
        } else {
            this.stop = true;
        }
        if (this.stop && )
        return result;
    }
     */

    public void rotateAngleY(ModelRenderer model, float speed, float degree, boolean invert, float offset, float weight, float limbSwing, float limbSwingAmount) {
        float result = degree * MathHelper.cos(limbSwing * speed + offset) + weight * limbSwingAmount;
        model.rotateAngleY = (invert ? -result : result) + this.initRotation.get(model)[1];
    }

    public void rotateAngleZ(ModelRenderer model, float speed, float degree, boolean invert, float offset, float weight, float limbSwing, float limbSwingAmount) {
        float result = degree * MathHelper.cos(limbSwing * speed + offset) + weight * limbSwingAmount;
        model.rotateAngleZ = (invert ? -result : result) + this.initRotation.get(model)[2];
    }

    static float getLimbSwing(LivingEntity entityIn, float partialTicks) {
        boolean shouldSit = entityIn.isPassenger() && (entityIn.getRidingEntity() != null && entityIn.getRidingEntity().shouldRiderSit());
        float limbSwing = 0f;
        if (!shouldSit && entityIn.isAlive()) {
            limbSwing = entityIn.limbSwing - entityIn.limbSwingAmount * (1.0F - partialTicks);
            if (entityIn.isChild()) {
                limbSwing *= 3.0F;
            }
        }
        return limbSwing;
    }

    static float getLimbSwingAmount(LivingEntity entityIn, float partialTicks) {
        boolean shouldSit = entityIn.isPassenger() && (entityIn.getRidingEntity() != null && entityIn.getRidingEntity().shouldRiderSit());
        float limbSwingAmount = 0f;
        if (!shouldSit && entityIn.isAlive()) {
            limbSwingAmount = MathHelper.lerp(partialTicks, entityIn.prevLimbSwingAmount, entityIn.limbSwingAmount);
            if (limbSwingAmount > 1.0F) {
                limbSwingAmount = 1.0F;
            }
        }
        return limbSwingAmount;
    }

    public static void translateX(MatrixStack matrixStack, float partialTicks, float speed, float height, float offset, float weight, LivingEntity entityIn) {
        float limbSwingAmount = getLimbSwingAmount(entityIn, partialTicks);
        float result = height * MathHelper.cos(entityIn.ticksExisted * speed + offset) + weight * limbSwingAmount;
        matrixStack.translate(result, 0d, 0d);
    }

    public static void translateY(MatrixStack matrixStack, float partialTicks, float speed, float height, float offset, float weight, LivingEntity entityIn) {
        float limbSwingAmount = getLimbSwingAmount(entityIn, partialTicks);
        float result = height * MathHelper.cos(entityIn.ticksExisted * speed + offset) + weight * limbSwingAmount;
        matrixStack.translate(0d, result, 0d);
    }

    public static void translateZ(MatrixStack matrixStack, float partialTicks, float speed, float height, float offset, float weight, LivingEntity entityIn) {
        float limbSwing = getLimbSwing(entityIn, partialTicks);
        float limbSwingAmount = getLimbSwingAmount(entityIn, partialTicks);
        float result = height * MathHelper.cos(limbSwing * speed + offset) + weight * limbSwingAmount;
        matrixStack.translate(0d, 0d, result);
    }

    public float resetLimbSwing(float limbSwing, String id) {
        if (this.id == null) {
            this.id = id;
            this.reset = limbSwing;
        }
        if (!this.id.equals(id))  {
            this.id = id;
            this.reset = limbSwing;
        }
        SophosQuest.info(limbSwing - this.reset);
        return limbSwing - this.reset;
    }
}
