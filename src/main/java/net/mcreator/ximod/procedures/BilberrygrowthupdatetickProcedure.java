package net.mcreator.ximod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.ximod.block.Bilberrystage3Block;
import net.mcreator.ximod.block.Bilberrystage2Block;
import net.mcreator.ximod.block.Bilberrystage1Block;
import net.mcreator.ximod.block.Bilberrystage0Block;
import net.mcreator.ximod.XiModMod;

import java.util.Map;

public class BilberrygrowthupdatetickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Bilberrygrowthupdatetick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure Bilberrygrowthupdatetick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure Bilberrygrowthupdatetick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure Bilberrygrowthupdatetick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		BlockState stage0 = Blocks.AIR.getDefaultState();
		BlockState stage1 = Blocks.AIR.getDefaultState();
		BlockState stage2 = Blocks.AIR.getDefaultState();
		BlockState stage3 = Blocks.AIR.getDefaultState();
		stage0 = Bilberrystage0Block.block.getDefaultState();
		stage1 = Bilberrystage1Block.block.getDefaultState();
		stage2 = Bilberrystage2Block.block.getDefaultState();
		stage3 = Bilberrystage3Block.block.getDefaultState();
		if (new Object() {
			public double getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "GrowthTime") <= 0) {
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == (stage0).getBlock()
					&& (stage1).isValidPosition(world, new BlockPos(x, y, z))) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = (stage1);
					world.setBlockState(_bp, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == (stage1).getBlock()
					&& (stage2).isValidPosition(world, new BlockPos(x, y, z))) {
				{
					BlockPos _bp = new BlockPos(x, y, z);
					BlockState _bs = (stage3);
					world.setBlockState(_bp, _bs, 3);
				}
			}
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("GrowthTime", 0);
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		} else {
			if (!world.isRemote()) {
				BlockPos _bp = new BlockPos(x, y, z);
				TileEntity _tileEntity = world.getTileEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getTileData().putDouble("GrowthTime", ((new Object() {
						public double getValue(IWorld world, BlockPos pos, String tag) {
							TileEntity tileEntity = world.getTileEntity(pos);
							if (tileEntity != null)
								return tileEntity.getTileData().getDouble(tag);
							return -1;
						}
					}.getValue(world, new BlockPos(x, y, z), "GrowthTime")) - 1));
				if (world instanceof World)
					((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
			}
		}
	}
}
