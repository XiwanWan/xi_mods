// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelduck extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer bill;
	private final ModelRenderer chin;
	private final ModelRenderer body;
	private final ModelRenderer left_wing;
	private final ModelRenderer right_wing;
	private final ModelRenderer left_leg;
	private final ModelRenderer right_leg;

	public Modelduck() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.0F, -4.0F);
		head.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 6.0F, 3.0F, 0.0F, false);

		bill = new ModelRenderer(this);
		bill.setRotationPoint(0.0F, 15.0F, -4.0F);
		bill.setTextureOffset(14, 0).addBox(-2.0F, -2.0F, -5.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);

		chin = new ModelRenderer(this);
		chin.setRotationPoint(0.0F, 15.0F, -4.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.0F, 0.0F);
		setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
		body.setTextureOffset(0, 9).addBox(-3.0F, -6.0F, -5.0F, 6.0F, 10.0F, 4.0F, 0.0F, false);

		left_wing = new ModelRenderer(this);
		left_wing.setRotationPoint(4.0F, 13.0F, 0.0F);
		left_wing.setTextureOffset(21, 10).addBox(-1.0F, 5.0F, -5.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);

		right_wing = new ModelRenderer(this);
		right_wing.setRotationPoint(-4.0F, 13.0F, 0.0F);
		right_wing.setTextureOffset(21, 10).addBox(0.0F, 5.0F, -5.0F, 1.0F, 2.0F, 9.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(1.0F, 19.0F, 1.0F);
		left_leg.setTextureOffset(26, 0).addBox(-1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-2.0F, 19.0F, 1.0F);
		right_leg.setTextureOffset(26, 0).addBox(-1.0F, 2.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bill.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		chin.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}