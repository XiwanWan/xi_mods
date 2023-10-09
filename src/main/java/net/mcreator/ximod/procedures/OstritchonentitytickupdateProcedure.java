package net.mcreator.ximod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.ximod.XiModMod;

import java.util.Map;

public class OstritchonentitytickupdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Ostritchonentitytickupdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XiModMod.LOGGER.warn("Failed to load dependency entity for procedure Ostritchonentitytickupdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (!world.isRemote()) {
			if (entity.getPersistentData().getDouble("feedTimer") > 0) {
				entity.getPersistentData().putDouble("feedTimer", (entity.getPersistentData().getDouble("feedTimer") - 1));
			} else if (entity.getPersistentData().getDouble("feedTimer") < 0) {
				entity.getPersistentData().putDouble("feedTimer", 0);
			}
		}
	}
}
