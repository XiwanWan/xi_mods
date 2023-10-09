
package net.mcreator.ximod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.ximod.entity.OstritchbreedEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class OstritchbreedRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(OstritchbreedEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelostritch(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("xi_mod:textures/entities/black_ostritch.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.8.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelostritch extends EntityModel<Entity> {
		private final ModelRenderer ostritch_all;
		private final ModelRenderer legs;
		private final ModelRenderer right_leg;
		private final ModelRenderer left_leg;
		private final ModelRenderer left_leg_cube_r1;
		private final ModelRenderer wing;
		private final ModelRenderer head;
		private final ModelRenderer body;
		private final ModelRenderer bodyhead;

		public Modelostritch() {
			textureWidth = 88;
			textureHeight = 64;
			ostritch_all = new ModelRenderer(this);
			ostritch_all.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(ostritch_all, 0.0F, 1.5708F, 0.0F);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(0.0F, 0.0F, 0.0F);
			ostritch_all.addChild(legs);
			right_leg = new ModelRenderer(this);
			right_leg.setRotationPoint(0.0F, -8.0F, 3.0F);
			legs.addChild(right_leg);
			right_leg.setTextureOffset(10, 43).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			left_leg = new ModelRenderer(this);
			left_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
			legs.addChild(left_leg);
			left_leg_cube_r1 = new ModelRenderer(this);
			left_leg_cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			left_leg.addChild(left_leg_cube_r1);
			setRotationAngle(left_leg_cube_r1, 0.0F, 3.1416F, 0.0F);
			left_leg_cube_r1.setTextureOffset(0, 43).addBox(-1.0F, -16.0F, 2.0F, 2.0F, 16.0F, 2.0F, 0.0F, false);
			wing = new ModelRenderer(this);
			wing.setRotationPoint(0.0F, 0.0F, 0.0F);
			ostritch_all.addChild(wing);
			wing.setTextureOffset(52, 0).addBox(-8.0F, -26.0F, -8.0F, 16.0F, 8.0F, 2.0F, 0.0F, false);
			wing.setTextureOffset(48, 30).addBox(-8.0F, -26.0F, 6.0F, 16.0F, 8.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			ostritch_all.addChild(head);
			head.setTextureOffset(56, 53).addBox(18.0F, -24.0F, -1.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(38, 45).addBox(22.0F, -33.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(20, 45).addBox(18.0F, -42.0F, -1.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			head.setTextureOffset(32, 34).addBox(22.0F, -39.0F, -1.0F, 4.0F, 2.0F, 4.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			ostritch_all.addChild(body);
			body.setTextureOffset(0, 0).addBox(-10.0F, -28.0F, -6.0F, 20.0F, 12.0F, 12.0F, 0.0F, false);
			body.setTextureOffset(64, 16).addBox(-16.0F, -21.0F, -3.0F, 6.0F, 8.0F, 6.0F, 0.0F, false);
			bodyhead = new ModelRenderer(this);
			bodyhead.setRotationPoint(0.0F, 24.0F, 0.0F);
			bodyhead.setTextureOffset(0, 24).addBox(-3.0F, -26.0F, -18.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			ostritch_all.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			bodyhead.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
