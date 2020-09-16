package com.timourx.sophosquest.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.timourx.sophosquest.entities.FemaleMoofahEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

public class FemaleMoofahModel<T extends FemaleMoofahEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer neck;
    private final ModelRenderer head;
    private final ModelRenderer rightEar;
    private final ModelRenderer leftEar;
    private final ModelRenderer rightHorn;
    private final ModelRenderer leftHorn;
    private final ModelRenderer tail;
    private final ModelRenderer frontRightLeg;
    private final ModelRenderer frontRightThigh;
    private final ModelRenderer frontRightTibia;
    private final ModelRenderer frontRightFoot;
    private final ModelRenderer frontLeftLeg;
    private final ModelRenderer frontLeftThigh;
    private final ModelRenderer frontLeftTibia;
    private final ModelRenderer frontLeftFoot;
    private final ModelRenderer backLeftLeg;
    private final ModelRenderer backLeftThigh;
    private final ModelRenderer backLeftTibia;
    private final ModelRenderer backLeftFoot;
    private final ModelRenderer backRightLeg;
    private final ModelRenderer backRightThigh;
    private final ModelRenderer backRightTibia;
    private final ModelRenderer backRightFoot;

    private final Map<ModelRenderer, Float[]> initRotation = new HashMap<>();

    public FemaleMoofahModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 17.0F, 0.0F);
        setRotationAngle(body, -3.1416F, 0.0F, 3.1416F);
        body.setTextureOffset(0, 0).addBox(-5.0F, -15.0F, -17.0F, 10.0F, 14.0F, 25.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, -10.5F, 5.0F);
        body.addChild(neck);
        setRotationAngle(neck, 0.6981F, 0.0F, 0.0F);
        neck.setTextureOffset(0, 39).addBox(-4.0F, -4.5F, -0.6F, 8.0F, 9.0F, 7.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -0.266F, 6.6428F);
        neck.addChild(head);
        setRotationAngle(head, -0.6981F, 0.0F, 0.0F);
        head.setTextureOffset(30, 39).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 7.0F, 0.0F, false);
        head.setTextureOffset(49, 39).addBox(-3.0F, -2.0F, 4.0F, 6.0F, 5.0F, 1.0F, 0.0F, false);
        head.setTextureOffset(57, 0).addBox(-2.0F, -1.0F, 5.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        rightEar = new ModelRenderer(this);
        rightEar.setRotationPoint(2.5F, -1.534F, 2.5F);
        head.addChild(rightEar);
        setRotationAngle(rightEar, 0.0F, -0.5672F, 0.0F);
        rightEar.setTextureOffset(23, 39).addBox(-0.612F, -0.466F, -5.3844F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        leftEar = new ModelRenderer(this);
        leftEar.setRotationPoint(-2.5F, -1.534F, 2.5F);
        head.addChild(leftEar);
        setRotationAngle(leftEar, 0.0F, 0.5672F, 0.0F);
        leftEar.setTextureOffset(10, 13).addBox(-0.388F, -0.466F, -5.3844F, 1.0F, 1.0F, 6.0F, 0.0F, false);

        rightHorn = new ModelRenderer(this);
        rightHorn.setRotationPoint(0.8333F, -5.0F, 0.3333F);
        head.addChild(rightHorn);
        setRotationAngle(rightHorn, -0.1745F, 0.0F, 0.0F);
        rightHorn.setTextureOffset(21, 15).addBox(-0.3333F, -0.5F, 1.6667F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        rightHorn.setTextureOffset(0, 55).addBox(-0.3333F, -0.5F, -1.3333F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        rightHorn.setTextureOffset(18, 20).addBox(-0.3333F, -0.5F, -2.3333F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        leftHorn = new ModelRenderer(this);
        leftHorn.setRotationPoint(-0.8333F, -5.0F, 0.3333F);
        head.addChild(leftHorn);
        setRotationAngle(leftHorn, -0.1745F, 0.0F, 0.0F);
        leftHorn.setTextureOffset(21, 7).addBox(-0.6667F, -0.5F, 1.6667F, 1.0F, 3.0F, 1.0F, 0.0F, false);
        leftHorn.setTextureOffset(50, 52).addBox(-1.6667F, -0.5F, -1.3333F, 2.0F, 2.0F, 3.0F, 0.0F, false);
        leftHorn.setTextureOffset(0, 4).addBox(-0.6667F, -0.5F, -2.3333F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, -15.0F, -17.0F);
        body.addChild(tail);
        setRotationAngle(tail, 0.9163F, 0.0F, 0.0F);
        tail.setTextureOffset(0, 0).addBox(-2.5F, 0.0F, -6.0F, 5.0F, 2.0F, 6.0F, 0.0F, false);

        frontRightLeg = new ModelRenderer(this);
        frontRightLeg.setRotationPoint(5.0F, -5.0F, 4.0F);
        body.addChild(frontRightLeg);
        frontRightLeg.setTextureOffset(26, 52).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
        frontRightLeg.setTextureOffset(38, 52).addBox(-2.5F, 5.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        frontRightThigh = new ModelRenderer(this);
        frontRightThigh.setRotationPoint(-1.0F, 5.0F, 0.0F);
        frontRightLeg.addChild(frontRightThigh);
        frontRightThigh.setTextureOffset(58, 55).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        frontRightTibia = new ModelRenderer(this);
        frontRightTibia.setRotationPoint(0.0F, 3.0F, 0.5F);
        frontRightThigh.addChild(frontRightTibia);
        frontRightTibia.setTextureOffset(21, 21).addBox(-0.5F, -0.25F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        frontRightFoot = new ModelRenderer(this);
        frontRightFoot.setRotationPoint(0.0F, 2.0F, -0.5F);
        frontRightTibia.addChild(frontRightFoot);
        frontRightFoot.setTextureOffset(8, 59).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        frontRightFoot.setTextureOffset(49, 57).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        frontLeftLeg = new ModelRenderer(this);
        frontLeftLeg.setRotationPoint(-3.0F, -5.0F, 4.0F);
        body.addChild(frontLeftLeg);
        frontLeftLeg.setTextureOffset(45, 11).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
        frontLeftLeg.setTextureOffset(9, 20).addBox(-2.5F, 5.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        frontLeftThigh = new ModelRenderer(this);
        frontLeftThigh.setRotationPoint(-1.0F, 5.0F, 0.0F);
        frontLeftLeg.addChild(frontLeftThigh);
        frontLeftThigh.setTextureOffset(57, 49).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        frontLeftTibia = new ModelRenderer(this);
        frontLeftTibia.setRotationPoint(0.0F, 3.0F, 0.5F);
        frontLeftThigh.addChild(frontLeftTibia);
        frontLeftTibia.setTextureOffset(18, 12).addBox(-0.5F, -0.25F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        frontLeftFoot = new ModelRenderer(this);
        frontLeftFoot.setRotationPoint(0.0F, 2.0F, -0.5F);
        frontLeftTibia.addChild(frontLeftFoot);
        frontLeftFoot.setTextureOffset(57, 11).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        frontLeftFoot.setTextureOffset(56, 45).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        backLeftLeg = new ModelRenderer(this);
        backLeftLeg.setRotationPoint(-3.0F, -5.0F, -16.0F);
        body.addChild(backLeftLeg);
        backLeftLeg.setTextureOffset(45, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
        backLeftLeg.setTextureOffset(0, 19).addBox(-2.5F, 5.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        backLeftThigh = new ModelRenderer(this);
        backLeftThigh.setRotationPoint(-1.0F, 5.0F, 0.0F);
        backLeftLeg.addChild(backLeftThigh);
        backLeftThigh.setTextureOffset(18, 57).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        backLeftTibia = new ModelRenderer(this);
        backLeftTibia.setRotationPoint(0.0F, 3.0F, 0.5F);
        backLeftThigh.addChild(backLeftTibia);
        backLeftTibia.setTextureOffset(0, 8).addBox(-0.5F, -0.25F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        backLeftFoot = new ModelRenderer(this);
        backLeftFoot.setRotationPoint(0.0F, 2.0F, -0.5F);
        backLeftTibia.addChild(backLeftFoot);
        backLeftFoot.setTextureOffset(53, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        backLeftFoot.setTextureOffset(42, 56).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        backRightLeg = new ModelRenderer(this);
        backRightLeg.setRotationPoint(5.0F, -5.0F, -16.0F);
        body.addChild(backRightLeg);
        backRightLeg.setTextureOffset(0, 8).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, 0.0F, false);
        backRightLeg.setTextureOffset(12, 8).addBox(-2.5F, 5.0F, -1.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);

        backRightThigh = new ModelRenderer(this);
        backRightThigh.setRotationPoint(-1.0F, 5.0F, 0.0F);
        backRightLeg.addChild(backRightThigh);
        backRightThigh.setTextureOffset(16, 0).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        backRightTibia = new ModelRenderer(this);
        backRightTibia.setRotationPoint(0.0F, 3.0F, 0.5F);
        backRightThigh.addChild(backRightTibia);
        backRightTibia.setTextureOffset(0, 0).addBox(-0.5F, -0.25F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);

        backRightFoot = new ModelRenderer(this);
        backRightFoot.setRotationPoint(0.0F, 2.0F, -0.5F);
        backRightTibia.addChild(backRightFoot);
        backRightFoot.setTextureOffset(45, 22).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        backRightFoot.setTextureOffset(10, 55).addBox(-1.0F, 1.0F, -1.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        setInitPose(new ModelRenderer[]{body, neck, head, rightEar, leftEar, rightHorn, leftHorn, tail, frontRightLeg, frontRightThigh, frontRightTibia, frontRightFoot, frontLeftLeg, frontLeftThigh, frontLeftTibia, frontLeftFoot, backRightLeg, backRightThigh, backRightTibia, backRightFoot, backLeftLeg, backLeftThigh, backLeftTibia, backLeftFoot});
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        limbSwing = entityIn.ticksExisted;
        limbSwingAmount = 0.5f;

        float globalSpeed = 1f;
        float globalHeight = 1.0f;
        float globalLegDegree = 0.9f;

        float oppositeOffset = 600.0f;
        float offsetDifference = -2f;

        if (entityIn.isInWater() && entityIn.func_233571_b_(FluidTags.WATER) > entityIn.func_233579_cu_() || entityIn.isInLava()) {
            rotateAngleX(tail, 0.2f * globalSpeed, 0.1f * globalLegDegree, false, 0, -1.4f, limbSwing, limbSwingAmount);

            rotateAngleX(neck, 0.2f * globalSpeed, 0.4f * globalLegDegree, false, 0, 0, limbSwing, limbSwingAmount);
            rotateAngleX(head, 0.2f * globalSpeed, 0.4f * globalLegDegree, true, 0, 0, limbSwing, limbSwingAmount);

            rotateAngleX(frontLeftLeg, 0.2f * globalSpeed, 0.9f * globalLegDegree, false, 0.85f, 0.55f, limbSwing, limbSwingAmount);
            rotateAngleX(frontLeftThigh, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -0.5f, -1.5f, limbSwing, limbSwingAmount);
            rotateAngleX(frontLeftFoot, 0.2f * globalSpeed, 1.2f * globalLegDegree, false, -1.2f, -1.2f, limbSwing, limbSwingAmount);

            rotateAngleX(frontRightLeg, 0.2f * globalSpeed, 0.9f * globalLegDegree, false, 0.85f + oppositeOffset, 0.55f, limbSwing, limbSwingAmount);
            rotateAngleX(frontRightThigh, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -0.5f + oppositeOffset, -1.5f, limbSwing, limbSwingAmount);
            rotateAngleX(frontRightFoot, 0.2f * globalSpeed, 1.2f * globalLegDegree, false, -1.2f + oppositeOffset, -1.2f, limbSwing, limbSwingAmount);

            rotateAngleX(backLeftLeg, 0.2f * globalSpeed, 0.9f * globalLegDegree, false, 0.85f - offsetDifference, 0.55f, limbSwing, limbSwingAmount);
            rotateAngleX(backLeftThigh, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -0.5f - offsetDifference, -1.5f, limbSwing, limbSwingAmount);
            rotateAngleX(backLeftFoot, 0.2f * globalSpeed, 1.2f * globalLegDegree, false, -1.2f - offsetDifference, -1.2f, limbSwing, limbSwingAmount);

            rotateAngleX(backRightLeg, 0.2f * globalSpeed, 0.9f * globalLegDegree, false, 0.85f - offsetDifference + oppositeOffset, 0.55f, limbSwing, limbSwingAmount);
            rotateAngleX(backRightThigh, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -0.5f - offsetDifference + oppositeOffset, -1.5f, limbSwing, limbSwingAmount);
            rotateAngleX(backRightFoot, 0.2f * globalSpeed, 1.2f * globalLegDegree, false, -1.2f - offsetDifference + oppositeOffset, -1.2f, limbSwing, limbSwingAmount);
        } else {
            rotateAngleX(tail, 0.2f * globalSpeed, 0.1f * globalLegDegree, false, 0, 0, limbSwing, limbSwingAmount);

            rotateAngleX(neck, 0.2f * globalSpeed, 0.1f * globalLegDegree, false, 0, 0, limbSwing, limbSwingAmount);
            rotateAngleX(head, 0.2f * globalSpeed, 0.1f * globalLegDegree, true, 0, 0, limbSwing, limbSwingAmount);

            rotateAngleX(frontLeftLeg, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, 0.85f, 0.3f, limbSwing, limbSwingAmount);
            rotateAngleX(frontLeftThigh, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, -0.5f, -0.5f, limbSwing, limbSwingAmount);
            rotateAngleX(frontLeftTibia, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -1.3f, -0.7f, limbSwing, limbSwingAmount);
            rotateAngleX(frontLeftFoot, 0.2f * globalSpeed, 0.4f * globalLegDegree, false, -1.6f, -0.4f, limbSwing, limbSwingAmount);

            rotateAngleX(frontRightLeg, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, 0.85f + oppositeOffset, 0.3f, limbSwing, limbSwingAmount);
            rotateAngleX(frontRightThigh, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, -0.5f + oppositeOffset, -0.5f, limbSwing, limbSwingAmount);
            rotateAngleX(frontRightTibia, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -1.3f + oppositeOffset, -0.7f, limbSwing, limbSwingAmount);
            rotateAngleX(frontRightFoot, 0.2f * globalSpeed, 0.4f * globalLegDegree, false, -1.6f + oppositeOffset, -0.4f, limbSwing, limbSwingAmount);

            rotateAngleX(backLeftLeg, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, 0.85f - offsetDifference, 0.3f, limbSwing, limbSwingAmount);
            rotateAngleX(backLeftThigh, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, -0.5f - offsetDifference, -0.5f, limbSwing, limbSwingAmount);
            rotateAngleX(backLeftTibia, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -1.3f - offsetDifference, -0.7f, limbSwing, limbSwingAmount);
            rotateAngleX(backLeftFoot, 0.2f * globalSpeed, 0.4f * globalLegDegree, false, -1.6f - offsetDifference, -0.4f, limbSwing, limbSwingAmount);

            rotateAngleX(backRightLeg, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, 0.85f + oppositeOffset - offsetDifference, 0.3f, limbSwing, limbSwingAmount);
            rotateAngleX(backRightThigh, 0.2f * globalSpeed, 0.5f * globalLegDegree, false, -0.5f + oppositeOffset - offsetDifference, -0.5f, limbSwing, limbSwingAmount);
            rotateAngleX(backRightTibia, 0.2f * globalSpeed, 0.7f * globalLegDegree, false, -1.3f + oppositeOffset - offsetDifference, -0.7f, limbSwing, limbSwingAmount);
            rotateAngleX(backRightFoot, 0.2f * globalSpeed, 0.4f * globalLegDegree, false, -1.6f + oppositeOffset - offsetDifference, -0.4f, limbSwing, limbSwingAmount);
        }
    }

    public void rotateAngleX(ModelRenderer model, float speed, float degree, boolean invert, float offset, float weight, float limbSwing, float limbSwingAmount) {
        float result = (float) (limbSwingAmount * degree * MathHelper.cos(limbSwing * speed + offset) + weight * limbSwingAmount);
        model.rotateAngleX = (invert ? -result : result) + initRotation.get(model)[0];
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    private void setInitPose(ModelRenderer[] modelRenderers) {
        for (ModelRenderer model : modelRenderers) {
            initRotation.put(model, new Float[]{model.rotateAngleX, model.rotateAngleY, model.rotateAngleZ});
        }
    }
}
