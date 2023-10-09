// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelfrog extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer eyes;
	private final ModelRenderer tongue;
	private final ModelRenderer body;
	private final ModelRenderer croaking_body;
	private final ModelRenderer left_arm;
	private final ModelRenderer right_arm;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public Modelfrog() {
		textureWidth = 48;
		textureHeight = 48;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 20.0F, 3.0F);
		head.setTextureOffset(23, 13).addBox(-3.5F, -1.0F, -7.0F, 7.0F, 0.0F, 9.0F, 0.0F, false);
		head.setTextureOffset(0, 13).addBox(-3.5F, -2.0F, -7.0F, 7.0F, 3.0F, 9.0F, 0.0F, false);

		eyes = new ModelRenderer(this);
		eyes.setRotationPoint(-0.5F, 20.0F, 5.0F);
		eyes.setTextureOffset(0, 0).addBox(-3.0F, -4.0F, -8.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		eyes.setTextureOffset(0, 5).addBox(1.0F, -4.0F, -8.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

		tongue = new ModelRenderer(this);
		tongue.setRotationPoint(0.0F, 20.9F, 5.0F);
		tongue.setTextureOffset(17, 13).addBox(-2.0F, 0.0F, -7.1F, 4.0F, 0.0F, 7.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 22.0F, 4.0F);
		body.setTextureOffset(3, 1).addBox(-3.5F, -2.0F, -8.0F, 7.0F, 3.0F, 9.0F, 0.0F, false);
		body.setTextureOffset(23, 22).addBox(-3.5F, -1.0F, -8.0F, 7.0F, 0.0F, 9.0F, 0.0F, false);

		croaking_body = new ModelRenderer(this);
		croaking_body.setRotationPoint(0.0F, 21.0F, -1.0F);
		croaking_body.setTextureOffset(26, 5).addBox(-3.5F, -0.1F, -2.9F, 7.0F, 2.0F, 3.0F, -0.1F, false);

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(4.0F, 21.0F, -2.5F);
		left_arm.setTextureOffset(0, 32).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		left_arm.setTextureOffset(18, 40).addBox(-4.0F, 3.01F, -5.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-4.0F, 21.0F, -2.5F);
		right_arm.setTextureOffset(0, 38).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
		right_arm.setTextureOffset(2, 40).addBox(-4.0F, 3.01F, -5.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(3.5F, 21.0F, 4.0F);
		left_leg.setTextureOffset(14, 25).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		left_leg.setTextureOffset(2, 32).addBox(-2.0F, 3.01F, -4.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-3.5F, 21.0F, 4.0F);
		right_leg.setTextureOffset(0, 25).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 3.0F, 4.0F, 0.0F, false);
		right_leg.setTextureOffset(18, 32).addBox(-6.0F, 3.01F, -4.0F, 8.0F, 0.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		eyes.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tongue.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		croaking_body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}