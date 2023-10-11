
package net.mcreator.ximod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.ximod.entity.AxolotlEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class AxolotlRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(AxolotlEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelaxolotl(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("xi_mod:textures/entities/axolotl.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.8.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelaxolotl extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer top_gills;
		private final ModelRenderer left_gills;
		private final ModelRenderer right_gills;
		private final ModelRenderer body;
		private final ModelRenderer leg4;
		private final ModelRenderer leg2;
		private final ModelRenderer leg3;
		private final ModelRenderer leg1;
		private final ModelRenderer tail;

		public Modelaxolotl() {
			textureWidth = 64;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 18.0F, -5.0F);
			head.setTextureOffset(0, 1).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 5.0F, 5.0F, 0.0F, false);
			top_gills = new ModelRenderer(this);
			top_gills.setRotationPoint(0.0F, 15.0F, -6.0F);
			top_gills.setTextureOffset(3, 37).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, 0.0F, false);
			left_gills = new ModelRenderer(this);
			left_gills.setRotationPoint(-4.0F, 18.0F, -6.0F);
			left_gills.setTextureOffset(0, 40).addBox(-3.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);
			right_gills = new ModelRenderer(this);
			right_gills.setRotationPoint(4.0F, 18.0F, -6.0F);
			right_gills.setTextureOffset(11, 40).addBox(0.0F, -5.0F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 18.0F, 4.0F);
			body.setTextureOffset(0, 11).addBox(-4.0F, -2.0F, -9.0F, 8.0F, 4.0F, 10.0F, 0.0F, false);
			body.setTextureOffset(2, 17).addBox(0.0F, -3.0F, -8.0F, 0.0F, 5.0F, 9.0F, 0.0F, false);
			leg4 = new ModelRenderer(this);
			leg4.setRotationPoint(3.5F, 19.0F, -4.0F);
			leg4.setTextureOffset(2, 13).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(3.5F, 19.0F, 3.0F);
			leg2.setTextureOffset(2, 13).addBox(-1.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
			leg3 = new ModelRenderer(this);
			leg3.setRotationPoint(-3.5F, 19.0F, -4.0F);
			leg3.setTextureOffset(2, 13).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-3.5F, 19.0F, 3.0F);
			leg1.setTextureOffset(2, 13).addBox(-2.0F, 0.0F, 0.0F, 3.0F, 5.0F, 0.0F, 0.0F, false);
			tail = new ModelRenderer(this);
			tail.setRotationPoint(0.0F, 18.0F, 5.0F);
			tail.setTextureOffset(2, 19).addBox(0.0F, -3.0F, 0.0F, 0.0F, 5.0F, 12.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			top_gills.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			left_gills.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			right_gills.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			leg4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			leg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			leg3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			leg1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
