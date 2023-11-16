
package net.mcreator.ximod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.ximod.itemgroup.XiItemGroup;
import net.mcreator.ximod.XiModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@XiModModElements.ModElement.Tag
public class XihatItem extends XiModModElements.ModElement {
	@ObjectHolder("xi_mod:xihat_helmet")
	public static final Item helmet = null;
	@ObjectHolder("xi_mod:xihat_chestplate")
	public static final Item body = null;
	@ObjectHolder("xi_mod:xihat_leggings")
	public static final Item legs = null;
	@ObjectHolder("xi_mod:xihat_boots")
	public static final Item boots = null;

	public XihatItem(XiModModElements instance) {
		super(instance, 394);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 9;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "xihat";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(XiItemGroup.tab)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelxi_hat().hat;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "xi_mod:textures/entities/xi_hat.png";
			}
		}.setRegistryName("xihat_helmet"));
	}

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
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			hat.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
