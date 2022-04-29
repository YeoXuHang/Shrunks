package com.github.ayaan.shrunk.entity.client.model;

import com.github.ayaan.shrunk.ShrunkMod;
import com.github.ayaan.shrunk.entity.custom.OrchidMantisEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class OrchidMantisModel<T extends OrchidMantisEntity> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ShrunkMod.MOD_ID, "orchidmantismodel"), "main");
	//Root
	private final ModelPart root;
	private final ModelPart orchid_mantis;
	//Mantis
	private final ModelPart body;
	private final ModelPart leftFrontLeg;
	private final ModelPart rightFrontleg;
	private final ModelPart leftBackLeg;
	private final ModelPart rightBackLeg;
	//Body
	private final ModelPart tail;
	private final ModelPart neck;
	//Neck
	private final ModelPart eye;
	private final ModelPart leftArm;
	private final ModelPart rightArm;
	//Left Arm
	private final ModelPart leftSmallArm;
	//Right Arm
	private final ModelPart rightSamllArm;
	//Eye
	private final ModelPart left;
	private final ModelPart right;
	private final ModelPart mouth;
    //Left Small Arm
	private final ModelPart leftBigArm;
	//Right Small Arm
	private final ModelPart rightBigArm;


	public OrchidMantisModel(ModelPart root) {
		this.root = root;
		this.orchid_mantis = root.getChild("orchid_mantis");
		//Mantis
		this.body = orchid_mantis.getChild("body");
		this.leftFrontLeg = orchid_mantis.getChild("left_front_leg");
		this.rightFrontleg = orchid_mantis.getChild("right_front_leg");
		this.leftBackLeg = orchid_mantis.getChild("left_back_leg");
		this.rightBackLeg = orchid_mantis.getChild("right_back_leg");
		//Body
		this.tail = body.getChild("tail");
		this.neck = body.getChild("neck");
		//Neck
		this.eye = neck.getChild("eye");
		this.leftArm = neck.getChild("left_arm");
		this.rightArm = neck.getChild("right_arm");
		//Left Arm
		this.leftSmallArm = leftArm.getChild("left_small_arm");
		//Right Arm
		this.rightSamllArm = rightArm.getChild("right_small_arm");
		//Eye
		this.left = eye.getChild("left");
		this.right = eye.getChild("right");
		this.mouth = eye.getChild("mouth");
		//Left Small Arm
		this.leftBigArm = leftSmallArm.getChild("left_big_arm");
		//Right Small Arm
		this.rightBigArm = rightSamllArm.getChild("right_big_arm");


	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition orchid_mantis = partdefinition.addOrReplaceChild("orchid_mantis", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = orchid_mantis.addOrReplaceChild("body", CubeListBuilder.create().texOffs(29, 15).addBox(-4.0F, -8.0F, -13.0F, 8.0F, 7.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 7.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 1.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -16.0F, -1.0F, 12.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(0, 47).addBox(-2.0F, -18.0F, -4.0F, 4.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -11.0F));

		PartDefinition eye = neck.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(44, 0).addBox(-3.5F, -7.0F, -4.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(58, 0).addBox(-1.5F, -4.0F, -4.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(53, 49).addBox(2.5F, -7.0F, -4.0F, 2.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -16.0F, -3.0F));

		PartDefinition mouth = eye.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(34, 0).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 3.0F, -4.0F));

		PartDefinition right = eye.addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 17).mirror().addBox(0.0F, -17.0F, 0.0F, 0.0F, 17.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-0.5F, -4.0F, -1.0F));

		PartDefinition left = eye.addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 17).addBox(0.0F, -17.0F, 0.0F, 0.0F, 17.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -4.0F, -1.0F));

		PartDefinition right_arm = neck.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(32, 54).mirror().addBox(-1.0F, 0.0F, -2.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -11.0F, -4.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition right_small_arm = right_arm.addOrReplaceChild("right_small_arm", CubeListBuilder.create().texOffs(18, 54).mirror().addBox(-2.1783F, -3.0F, 0.05F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1783F, 12.0F, -2.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition right_big_arm = right_small_arm.addOrReplaceChild("right_big_arm", CubeListBuilder.create(), PartPose.offset(-0.6783F, 10.0F, 5.0F));

		PartDefinition cube_r2 = right_big_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(44, 54).mirror().addBox(-2.0F, -3.0F, -2.3F, 1.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5F, -3.0F, -0.25F, 3.1416F, 0.0F, 0.0F));

		PartDefinition left_arm = neck.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 54).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -11.0F, -4.0F));

		PartDefinition left_small_arm = left_arm.addOrReplaceChild("left_small_arm", CubeListBuilder.create().texOffs(18, 54).addBox(-1.5F, -3.0F, 0.55F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 12.0F, -1.5F, 3.1416F, 0.0F, 0.0F));

		PartDefinition left_big_arm = left_small_arm.addOrReplaceChild("left_big_arm", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 4.5F));

		PartDefinition cube_r3 = left_big_arm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(44, 54).addBox(1.0F, -3.0F, -2.3F, 1.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.0F, 0.75F, 3.1416F, 0.0F, 0.0F));

		PartDefinition right_back_leg = orchid_mantis.addOrReplaceChild("right_back_leg", CubeListBuilder.create(), PartPose.offset(-4.0F, -17.0F, 5.0F));

		PartDefinition cube_r4 = right_back_leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(26, 37).addBox(-16.0F, -1.0F, 0.0F, 16.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition right_front_leg = orchid_mantis.addOrReplaceChild("right_front_leg", CubeListBuilder.create(), PartPose.offset(-4.0F, -17.0F, -1.0F));

		PartDefinition cube_r5 = right_front_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(26, 37).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition left_front_leg = orchid_mantis.addOrReplaceChild("left_front_leg", CubeListBuilder.create(), PartPose.offset(4.0F, -17.0F, -1.0F));

		PartDefinition cube_r6 = left_front_leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(26, 37).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition left_back_leg = orchid_mantis.addOrReplaceChild("left_back_leg", CubeListBuilder.create(), PartPose.offset(4.0F, -17.0F, 5.0F));

		PartDefinition cube_r7 = left_back_leg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(26, 37).mirror().addBox(0.0F, -1.0F, 0.0F, 16.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		orchid_mantis.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}