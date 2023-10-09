package net.mcreator.ximod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.ximod.block.Bilberrystage2Block;
import net.mcreator.ximod.block.Bilberrystage1Block;
import net.mcreator.ximod.XiModMod;

import java.util.Map;
import java.util.HashMap;

public class Bilberrygrowthwithbonemeal2Procedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
			PlayerEntity entity = event.getPlayer();
			if (event.getHand() != entity.getActiveHand()) {
				return;
			}
			double i = event.getPos().getX();
			double j = event.getPos().getY();
			double k = event.getPos().getZ();
			IWorld world = event.getWorld();
			BlockState state = world.getBlockState(event.getPos());
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("direction", event.getFace());
			dependencies.put("blockstate", state);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Bilberrygrowthwithbonemeal2!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure Bilberrygrowthwithbonemeal2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure Bilberrygrowthwithbonemeal2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure Bilberrygrowthwithbonemeal2!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XiModMod.LOGGER.warn("Failed to load dependency entity for procedure Bilberrygrowthwithbonemeal2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		BlockState activestage = Blocks.AIR.getDefaultState();
		BlockState nextstage1 = Blocks.AIR.getDefaultState();
		BlockState nextstage2 = Blocks.AIR.getDefaultState();
		double random = 0;
		if (ItemTags.getCollection().getTagByID(new ResourceLocation("crops:fertilizer"))
				.contains(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			activestage = Bilberrystage1Block.block.getDefaultState();
			nextstage1 = Bilberrystage2Block.block.getDefaultState();
			if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == (activestage).getBlock()) {
				if ((nextstage1).isValidPosition(world, new BlockPos(x, y, z))) {
					{
						BlockPos _bp = new BlockPos(x, y, z);
						BlockState _bs = (nextstage1);
						world.setBlockState(_bp, _bs, 3);
					}
				}
			}
		}
	}
}
