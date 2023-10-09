// Made with Blockbench 4.8.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelostritch_baby extends EntityModel<Entity> {
	private final ModelRenderer ostritch_baby_all;
	private final ModelRenderer legs;
	private final ModelRenderer right_leg;
	private final ModelRenderer left_leg;
	private final ModelRenderer left_leg_cube_r1;
	private final ModelRenderer wing;
	private final ModelRenderer head;
	private final ModelRenderer body;

	public Modelostritch_baby() {
		textureWidth = 64;
		textureHeight = 64;

		ostritch_baby_all = new ModelRenderer(this);
		ostritch_baby_all.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(ostritch_baby_all, 0.0F, 1.5708F, 0.0F);

		legs = new ModelRenderer(this);
		legs.setRotationPoint(0.0F, 0.0F, 0.0F);
		ostritch_baby_all.addChild(legs);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(0.0F, -8.0F, 3.0F);
		legs.addChild(right_leg);
		right_leg.setTextureOffset(5, 21).addBox(-1.0F, 0.0F, -2.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
		legs.addChild(left_leg);

		left_leg_cube_r1 = new ModelRenderer(this);
		left_leg_cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		left_leg.addChild(left_leg_cube_r1);
		setRotationAngle(left_leg_cube_r1, 0.0F, 3.1416F, 0.0F);
		left_leg_cube_r1.setTextureOffset(0, 21).addBox(0.0F, -8.0F, 1.0F, 1.0F, 8.0F, 1.0F, 0.0F, false);

		wing = new ModelRenderer(this);
		wing.setRotationPoint(0.0F, 0.0F, 0.0F);
		ostritch_baby_all.addChild(wing);
		wing.setTextureOffset(26, 0).addBox(-5.0F, -11.0F, -4.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);
		wing.setTextureOffset(24, 15).addBox(-5.0F, -11.0F, 3.0F, 8.0F, 4.0F, 1.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		ostritch_baby_all.addChild(head);
		head.setTextureOffset(28, 26).addBox(8.0F, -10.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(19, 22).addBox(10.0F, -15.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(10, 22).addBox(8.0F, -20.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(16, 17).addBox(10.0F, -18.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		ostritch_baby_all.addChild(body);
		body.setTextureOffset(0, 0).addBox(-6.0F, -12.0F, -3.0F, 10.0F, 6.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(34, 9).addBox(-8.0F, -9.0F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(0, 12).addBox(4.0F, -11.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		ostritch_baby_all.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}