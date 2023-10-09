// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelcamel extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer left_ear;
	private final ModelRenderer right_ear;
	private final ModelRenderer body;
	private final ModelRenderer hump;
	private final ModelRenderer front_left_leg;
	private final ModelRenderer front_right_leg;
	private final ModelRenderer back_left_leg;
	private final ModelRenderer back_right_leg;
	private final ModelRenderer tail;
	private final ModelRenderer saddle;
	private final ModelRenderer bridle;
	private final ModelRenderer mirror;
	private final ModelRenderer reins;

	public Modelcamel() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 1.0F, -9.0F);
		head.setTextureOffset(50, 0).addBox(-2.5F, -21.0F, -21.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(21, 0).addBox(-3.5F, -21.0F, -15.0F, 7.0F, 14.0F, 7.0F, 0.0F, false);
		head.setTextureOffset(60, 24).addBox(-3.5F, -7.0F, -15.0F, 7.0F, 8.0F, 19.0F, 0.0F, false);

		left_ear = new ModelRenderer(this);
		left_ear.setRotationPoint(3.0F, -20.0F, -18.5F);
		setRotationAngle(left_ear, 0.0F, 0.0F, -0.7854F);
		left_ear.setTextureOffset(45, 0).addBox(-0.5F, 0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		right_ear = new ModelRenderer(this);
		right_ear.setRotationPoint(-3.0F, -20.0F, -18.5F);
		setRotationAngle(right_ear, 0.0F, 0.0F, 0.7854F);
		right_ear.setTextureOffset(67, 0).addBox(-2.5F, 0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 4.0F, 10.5F);
		body.setTextureOffset(0, 25).addBox(-7.5F, -12.0F, -23.5F, 15.0F, 12.0F, 27.0F, 0.0F, false);

		hump = new ModelRenderer(this);
		hump.setRotationPoint(0.0F, -8.0F, 0.5F);
		hump.setTextureOffset(74, 0).addBox(-4.5F, -5.0F, -5.5F, 9.0F, 5.0F, 11.0F, 0.0F, false);

		front_left_leg = new ModelRenderer(this);
		front_left_leg.setRotationPoint(4.9F, 1.0F, -10.0F);
		front_left_leg.setTextureOffset(0, 0).addBox(-2.6F, 2.0F, -2.0F, 5.0F, 21.0F, 5.0F, 0.0F, false);

		front_right_leg = new ModelRenderer(this);
		front_right_leg.setRotationPoint(-4.9F, 1.0F, -9.5F);
		front_right_leg.setTextureOffset(0, 26).addBox(-2.4F, 2.0F, -2.5F, 5.0F, 21.0F, 5.0F, 0.0F, false);

		back_left_leg = new ModelRenderer(this);
		back_left_leg.setRotationPoint(4.9F, 1.0F, 10.5F);
		back_left_leg.setTextureOffset(58, 16).addBox(-2.6F, 2.0F, -2.5F, 5.0F, 21.0F, 5.0F, 0.0F, false);

		back_right_leg = new ModelRenderer(this);
		back_right_leg.setRotationPoint(-4.9F, 1.0F, 10.5F);
		back_right_leg.setTextureOffset(94, 16).addBox(-2.4F, 2.0F, -2.5F, 5.0F, 21.0F, 5.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -5.0F, 14.0F);
		setRotationAngle(tail, 0.0873F, 0.0F, 0.0F);
		tail.setTextureOffset(122, 0).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 14.0F, 0.0F, 0.0F, false);

		saddle = new ModelRenderer(this);
		saddle.setRotationPoint(0.0F, 4.0F, 10.5F);

		bridle = new ModelRenderer(this);
		bridle.setRotationPoint(0.0F, 1.0F, -9.0F);

		mirror = new ModelRenderer(this);
		mirror.setRotationPoint(0.0F, 23.0F, 9.0F);
		bridle.addChild(mirror);

		reins = new ModelRenderer(this);
		reins.setRotationPoint(0.0F, 1.0F, -9.0F);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_ear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_ear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		hump.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		front_left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		front_right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		back_left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		back_right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		saddle.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bridle.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		reins.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.front_right_leg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.right_ear.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.right_ear.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.front_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.left_ear.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.left_ear.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}