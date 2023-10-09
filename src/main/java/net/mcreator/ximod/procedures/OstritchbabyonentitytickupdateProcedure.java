package net.mcreator.ximod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.ximod.entity.OstritchbabyEntity;
import net.mcreator.ximod.entity.OstritchEntity;
import net.mcreator.ximod.XiModMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class OstritchbabyonentitytickupdateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Ostritchbabyonentitytickupdate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure Ostritchbabyonentitytickupdate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure Ostritchbabyonentitytickupdate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure Ostritchbabyonentitytickupdate!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XiModMod.LOGGER.warn("Failed to load dependency entity for procedure Ostritchbabyonentitytickupdate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double posy = 0;
		double posx = 0;
		double posz = 0;
		double health = 0;
		double pitch = 0;
		double oxygen = 0;
		double yaw = 0;
		double breedTimer = 0;
		double babyTimer = 0;
		double feedTimer = 0;
		double particleTimer = 0;
		double eatSoundDelay = 0;
		Entity targetentity = null;
		if (!world.isRemote()) {
			if (entity.getPersistentData().getDouble("babyTimer") > 0) {
				entity.getPersistentData().putDouble("babyTimer", (entity.getPersistentData().getDouble("feedTimer") - 1));
			} else {
				posx = (entity.getPosX());
				posy = (entity.getPosY());
				posz = (entity.getPosZ());
				health = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
				oxygen = (entity.getAir());
				yaw = (entity.rotationYaw);
				pitch = (entity.rotationPitch);
				feedTimer = (entity.getPersistentData().getDouble("feedTimer"));
				breedTimer = 600;
				babyTimer = (entity.getPersistentData().getDouble("babyTimer"));
				particleTimer = (entity.getPersistentData().getDouble("particleTimer"));
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new OstritchEntity.CustomEntity(OstritchEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						if (((Entity) world
								.getEntitiesWithinAABB(AnimalEntity.class,
										new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof AnimalEntity) {
							if (!(entity.getDisplayName().getString()).equals("NAME OF YOUR ENTITY")) {
								((Entity) world.getEntitiesWithinAABB(AnimalEntity.class,
										new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).findFirst().orElse(null))
										.setCustomName(new StringTextComponent((entity.getDisplayName().getString())));
							}
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 2);
				if (!entity.world.isRemote())
					entity.remove();
				if (((Entity) world.getEntitiesWithinAABB(OstritchbabyEntity.CustomEntity.class,
						new AxisAlignedBB(posx - (1 / 2d), posy - (1 / 2d), posz - (1 / 2d), posx + (1 / 2d), posy + (1 / 2d), posz + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(posx, posy, posz)).findFirst().orElse(null)) != null) {
					targetentity = (Entity) world.getEntitiesWithinAABB(OstritchbabyEntity.CustomEntity.class,
							new AxisAlignedBB(posx - (1 / 2d), posy - (1 / 2d), posz - (1 / 2d), posx + (1 / 2d), posy + (1 / 2d), posz + (1 / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(posx, posy, posz)).findFirst().orElse(null);
					targetentity.rotationYaw = (float) (yaw);
					entity.setRenderYawOffset(entity.rotationYaw);
					entity.prevRotationYaw = entity.rotationYaw;
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
						((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
						((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
					}
					targetentity.rotationPitch = (float) (pitch);
					if (targetentity instanceof LivingEntity)
						((LivingEntity) targetentity).setHealth((float) health);
					targetentity.setAir((int) oxygen);
					targetentity.getPersistentData().putDouble("feedTimer", feedTimer);
					targetentity.getPersistentData().putDouble("breedTimer", breedTimer);
					targetentity.getPersistentData().putDouble("babyTimer", babyTimer);
					targetentity.getPersistentData().putDouble("particleTimer", particleTimer);
				}
			}
		}
	}
}
