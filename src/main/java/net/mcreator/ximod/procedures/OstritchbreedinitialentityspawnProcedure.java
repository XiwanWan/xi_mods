package net.mcreator.ximod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.ximod.XiModMod;

import java.util.Map;

public class OstritchbreedinitialentityspawnProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Ostritchbreedinitialentityspawn!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XiModMod.LOGGER.warn("Failed to load dependency entity for procedure Ostritchbreedinitialentityspawn!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (!world.isRemote()) {
			entity.getPersistentData().putDouble("feedtimer", 0);
			entity.getPersistentData().putDouble("breedTimer", 600);
			entity.getPersistentData().putDouble("babyTimer", 24000);
			entity.getPersistentData().putDouble("particleTimer", 0);
		}
	}
}
