
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

import net.mcreator.ximod.entity.ShuglinEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ShuglinRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ShuglinEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelshuglin(), 1f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("xi_mod:textures/entities/koglin.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.7.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelshuglin extends EntityModel<Entity> {
		private final ModelRenderer head;
		private final ModelRenderer head_rotation;
		private final ModelRenderer left_ear;
		private final ModelRenderer left_ear_rotation;
		private final ModelRenderer left_ear_rotation2;
		private final ModelRenderer right_ear;
		private final ModelRenderer right_ear_rotation;
		private final ModelRenderer right_ear_rotation2;
		private final ModelRenderer body;
		private final ModelRenderer mane;
		private final ModelRenderer front_left_leg;
		private final ModelRenderer front_right_leg;
		private final ModelRenderer back_left_leg;
		private final ModelRenderer back_right_leg;

		public Modelshuglin() {
			textureWidth = 128;
			textureHeight = 64;
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 3.0F, -8.5F);
			head_rotation = new ModelRenderer(this);
			head_rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(head_rotation);
			setRotationAngle(head_rotation, 0.8727F, 0.0F, 0.0F);
			head_rotation.setTextureOffset(61, 1).addBox(-7.0F, -3.0F, -19.0F, 14.0F, 6.0F, 19.0F, 0.0F, false);
			head_rotation.setTextureOffset(1, 13).addBox(6.0F, -4.0F, -13.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			head_rotation.setTextureOffset(10, 13).addBox(-8.0F, -4.0F, -13.0F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			left_ear = new ModelRenderer(this);
			left_ear.setRotationPoint(6.0F, 1.0F, -11.5F);
			left_ear_rotation = new ModelRenderer(this);
			left_ear_rotation.setRotationPoint(-6.5F, 1.75F, 3.0F);
			left_ear.addChild(left_ear_rotation);
			setRotationAngle(left_ear_rotation, 0.8727F, 0.0F, 0.0F);
			left_ear_rotation2 = new ModelRenderer(this);
			left_ear_rotation2.setRotationPoint(6.5F, -1.75F, -3.0F);
			left_ear_rotation.addChild(left_ear_rotation2);
			setRotationAngle(left_ear_rotation2, 0.0F, 0.0F, 0.7854F);
			left_ear_rotation2.setTextureOffset(1, 6).addBox(0.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			right_ear = new ModelRenderer(this);
			right_ear.setRotationPoint(-6.0F, 1.0F, -11.5F);
			right_ear_rotation = new ModelRenderer(this);
			right_ear_rotation.setRotationPoint(6.5F, 1.75F, 3.0F);
			right_ear.addChild(right_ear_rotation);
			setRotationAngle(right_ear_rotation, 0.8727F, 0.0F, 0.0F);
			right_ear_rotation2 = new ModelRenderer(this);
			right_ear_rotation2.setRotationPoint(-6.5F, -1.75F, -3.0F);
			right_ear_rotation.addChild(right_ear_rotation2);
			setRotationAngle(right_ear_rotation2, 0.0F, 0.0F, -0.7854F);
			right_ear_rotation2.setTextureOffset(1, 1).addBox(-6.0F, -1.0F, -2.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 7.0F, 4.5F);
			body.setTextureOffset(1, 1).addBox(-8.0F, -7.0F, -13.0F, 16.0F, 14.0F, 26.0F, 0.0F, false);
			mane = new ModelRenderer(this);
			mane.setRotationPoint(0.0F, -7.0F, -2.5F);
			mane.setTextureOffset(90, 33).addBox(0.0F, 0.0F, -9.0F, 0.0F, 10.0F, 19.0F, 0.0F, false);
			front_left_leg = new ModelRenderer(this);
			front_left_leg.setRotationPoint(4.0F, 10.0F, -4.75F);
			front_left_leg.setTextureOffset(41, 42).addBox(-3.0F, 0.0F, -2.75F, 6.0F, 14.0F, 6.0F, 0.0F, false);
			front_right_leg = new ModelRenderer(this);
			front_right_leg.setRotationPoint(-4.0F, 10.0F, -4.5F);
			front_right_leg.setTextureOffset(66, 42).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 14.0F, 6.0F, 0.0F, false);
			back_left_leg = new ModelRenderer(this);
			back_left_leg.setRotationPoint(4.5F, 13.0F, 14.0F);
			back_left_leg.setTextureOffset(0, 45).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, 0.0F, false);
			back_right_leg = new ModelRenderer(this);
			back_right_leg.setRotationPoint(-4.5F, 13.0F, 14.0F);
			back_right_leg.setTextureOffset(21, 45).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 11.0F, 5.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			left_ear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			right_ear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			mane.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			front_left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			front_right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			back_left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			back_right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.front_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.back_right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.front_left_leg.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.head_rotation.rotateAngleZ = f4 / (180F / (float) Math.PI);
			this.back_left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
