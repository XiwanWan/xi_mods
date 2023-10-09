
package net.mcreator.ximod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.FoliageColors;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.ximod.itemgroup.XiItemGroup;
import net.mcreator.ximod.XiModModElements;

import java.util.List;
import java.util.Collections;

@XiModModElements.ModElement.Tag
public class BaobableavesBlock extends XiModModElements.ModElement {
	@ObjectHolder("xi_mod:baobableaves")
	public static final Block block = null;

	public BaobableavesBlock(XiModModElements instance) {
		super(instance, 49);
		FMLJavaModLoadingContext.get().getModEventBus().register(new BlockColorRegisterHandler());
		FMLJavaModLoadingContext.get().getModEventBus().register(new ItemColorRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(XiItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	private static class BlockColorRegisterHandler {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public void blockColorLoad(ColorHandlerEvent.Block event) {
			event.getBlockColors().register((bs, world, pos, index) -> {
				return world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault();
			}, block);
		}
	}

	private static class ItemColorRegisterHandler {
		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public void itemColorLoad(ColorHandlerEvent.Item event) {
			event.getItemColors().register((stack, index) -> {
				return FoliageColors.getDefault();
			}, block);
		}
	}

	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			setRegistryName("baobableaves");
		}

		@Override
		public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
			return 1;
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 10;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
