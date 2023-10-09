package net.mcreator.ximod.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.ximod.block.AridgrassBlock;
import net.mcreator.ximod.XiModMod;

import java.util.Map;

public class AridgrassQuandLaPlanteEstDetruiteParUnJoueurProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure AridgrassQuandLaPlanteEstDetruiteParUnJoueur!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure AridgrassQuandLaPlanteEstDetruiteParUnJoueur!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure AridgrassQuandLaPlanteEstDetruiteParUnJoueur!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure AridgrassQuandLaPlanteEstDetruiteParUnJoueur!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XiModMod.LOGGER.warn("Failed to load dependency entity for procedure AridgrassQuandLaPlanteEstDetruiteParUnJoueur!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		BlockState localstage = Blocks.AIR.getDefaultState();
		if (ItemTags.getCollection().getTagByID(new ResourceLocation("minecraft:shearstag"))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			localstage = AridgrassBlock.block.getDefaultState();
			if ((localstage).isValidPosition(world, new BlockPos(x, y, z))) {
				if (world instanceof World) {
					Block.spawnDrops(world.getBlockState(new BlockPos(x, y, z)), (World) world, new BlockPos(x, y, z));
					world.destroyBlock(new BlockPos(x, y, z), false);
				}
			}
		}
	}
}
