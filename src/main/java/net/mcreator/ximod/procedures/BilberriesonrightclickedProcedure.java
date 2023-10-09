package net.mcreator.ximod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.ximod.block.Bilberrystage1Block;
import net.mcreator.ximod.block.BilberriesBlock;
import net.mcreator.ximod.XiModMod;

import java.util.Map;

public class BilberriesonrightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Bilberriesonrightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure Bilberriesonrightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure Bilberriesonrightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure Bilberriesonrightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState stage1 = Blocks.AIR.getDefaultState();
		BlockState stage2 = Blocks.AIR.getDefaultState();
		BlockState activestage = Blocks.AIR.getDefaultState();
		if (BilberriesBlock.block.getDefaultState().isValidPosition(world, new BlockPos(x, y, z))) {
			activestage = BilberriesBlock.block.getDefaultState();
			stage1 = Bilberrystage1Block.block.getDefaultState();
			if (Bilberrystage1Block.block.getDefaultState().isValidPosition(world, new BlockPos(x, y, z))) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z), false);
				}
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = Bilberrystage1Block.block.getDefaultState();
					world.setBlockState(_bp, _bs, 3);
				}
			}
		}
	}
}
