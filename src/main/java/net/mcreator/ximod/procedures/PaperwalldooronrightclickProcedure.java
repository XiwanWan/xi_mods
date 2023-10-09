package net.mcreator.ximod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.Property;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.ximod.block.PaperwalldooropenBlock;
import net.mcreator.ximod.block.PaperwalldoorBlock;
import net.mcreator.ximod.XiModMod;

import java.util.Map;

public class PaperwalldooronrightclickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Paperwalldooronrightclick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure Paperwalldooronrightclick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure Paperwalldooronrightclick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure Paperwalldooronrightclick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState activedoor = Blocks.AIR.getDefaultState();
		BlockState door1 = Blocks.AIR.getDefaultState();
		if (PaperwalldoorBlock.block.getDefaultState().isValidPosition(world, new BlockPos(x, y, z))) {
			activedoor = PaperwalldoorBlock.block.getDefaultState();
			door1 = PaperwalldooropenBlock.block.getDefaultState();
			if (PaperwalldooropenBlock.block.getDefaultState().isValidPosition(world, new BlockPos(x, y, z))) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = PaperwalldooropenBlock.block.getDefaultState();
					BlockState _bso = world.getBlockState(_bp);
					for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
						Property _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
						if (_property != null && _bs.get(_property) != null)
							try {
								_bs = _bs.with(_property, (Comparable) entry.getValue());
							} catch (Exception e) {
							}
					}
					world.setBlockState(_bp, _bs, 3);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.loom.take_result")),
							SoundCategory.BLOCKS, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ui.loom.take_result")),
							SoundCategory.BLOCKS, (float) 1, (float) 1, false);
				}
			}
		}
	}
}
