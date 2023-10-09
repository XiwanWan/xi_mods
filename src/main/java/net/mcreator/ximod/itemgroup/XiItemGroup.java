
package net.mcreator.ximod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.ximod.item.JadedyeItem;
import net.mcreator.ximod.XiModModElements;

@XiModModElements.ModElement.Tag
public class XiItemGroup extends XiModModElements.ModElement {
	public XiItemGroup(XiModModElements instance) {
		super(instance, 196);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabxi") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(JadedyeItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
