
package net.mcreator.ximod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.ximod.itemgroup.XiItemGroup;
import net.mcreator.ximod.XiModModElements;

@XiModModElements.ModElement.Tag
public class OrangepelotaItem extends XiModModElements.ModElement {
	@ObjectHolder("xi_mod:orangepelota")
	public static final Item block = null;

	public OrangepelotaItem(XiModModElements instance) {
		super(instance, 348);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(XiItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("orangepelota");
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
