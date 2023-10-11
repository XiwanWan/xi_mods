// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelgoat extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer mirror;
	private final ModelRenderer nose;
	private final ModelRenderer left_horn;
	private final ModelRenderer right_horn;
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public Modelgoat() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.5F, 14.0F, 0.0F);
		head.setTextureOffset(23, 52).addBox(-0.5F, -3.0F, -14.0F, 0.0F, 7.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(2, 61).addBox(-6.0F, -11.0F, -10.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		mirror = new ModelRenderer(this);
		mirror.setRotationPoint(-0.5F, 10.0F, 0.0F);
		head.addChild(mirror);
		mirror.setTextureOffset(2, 61).addBox(2.5F, -21.0F, -10.0F, 3.0F, 2.0F, 1.0F, 0.0F, true);

		nose = new ModelRenderer(this);
		nose.setRotationPoint(0.5F, 6.0F, -8.0F);
		setRotationAngle(nose, 0.9599F, 0.0F, 0.0F);
		nose.setTextureOffset(34, 46).addBox(-3.0F, -4.0F, -8.0F, 5.0F, 7.0F, 10.0F, 0.0F, false);

		left_horn = new ModelRenderer(this);
		left_horn.setRotationPoint(0.5F, 14.0F, 0.0F);
		left_horn.setTextureOffset(12, 55).addBox(-0.01F, -16.0F, -10.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		right_horn = new ModelRenderer(this);
		right_horn.setRotationPoint(0.5F, 14.0F, 0.0F);
		right_horn.setTextureOffset(12, 55).addBox(-2.99F, -16.0F, -10.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.5F, 24.0F, 0.0F);
		body.setTextureOffset(1, 1).addBox(-4.0F, -17.0F, -7.0F, 9.0F, 11.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 28).addBox(-5.0F, -18.0F, -8.0F, 11.0F, 14.0F, 11.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-3.5F, 14.0F, 4.0F);
		leg1.setTextureOffset(49, 29).addBox(0.0F, 4.0F, 0.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(0.5F, 14.0F, 4.0F);
		leg2.setTextureOffset(36, 29).addBox(0.0F, 4.0F, 0.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.5F, 14.0F, -6.0F);
		leg3.setTextureOffset(49, 2).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(0.5F, 14.0F, -6.0F);
		leg4.setTextureOffset(35, 2).addBox(0.0F, 0.0F, 0.0F, 3.0F, 10.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		nose.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_horn.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_horn.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leg4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}