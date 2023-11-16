// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelxi_hat extends EntityModel<Entity> {
	private final ModelRenderer hat;
	private final ModelRenderer bord;
	private final ModelRenderer head;
	private final ModelRenderer contour;
	private final ModelRenderer noeud;

	public Modelxi_hat() {
		textureWidth = 64;
		textureHeight = 64;

		hat = new ModelRenderer(this);
		hat.setRotationPoint(0.0F, 31.0F, 0.0F);
		hat.setTextureOffset(0, 16).addBox(-4.0F, -11.0F, -3.0F, 8.0F, 3.0F, 6.0F, 0.0F, false);

		bord = new ModelRenderer(this);
		bord.setRotationPoint(0.0F, -7.0F, 0.0F);
		hat.addChild(bord);
		bord.setTextureOffset(0, 31).addBox(-1.0F, -4.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(2.0F, -7.0F, -2.0F);
		hat.addChild(head);

		contour = new ModelRenderer(this);
		contour.setRotationPoint(2.0F, -7.0F, -2.0F);
		hat.addChild(contour);
		contour.setTextureOffset(20, 53).addBox(-8.0F, -1.0F, -3.0F, 12.0F, 1.0F, 10.0F, 0.0F, false);

		noeud = new ModelRenderer(this);
		noeud.setRotationPoint(2.0F, -7.0F, -2.0F);
		hat.addChild(noeud);
		noeud.setTextureOffset(0, 7).addBox(-1.8F, -2.0F, -1.2F, 2.0F, 1.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		hat.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}