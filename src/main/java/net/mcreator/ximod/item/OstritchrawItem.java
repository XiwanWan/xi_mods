
package net.mcreator.ximod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.block.BlockState;

import net.mcreator.ximod.itemgroup.XiItemGroup;
import net.mcreator.ximod.XiModModElements;

@XiModModElements.ModElement.Tag
public class OstritchrawItem extends XiModModElements.ModElement {
	@ObjectHolder("xi_mod:ostritchraw")
	public static final Item block = null;

	public OstritchrawItem(XiModModElements instance) {
		super(instance, 107);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(XiItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(2).saturation(0.3f)

							.meat().build()));
			setRegistryName("ostritchraw");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
