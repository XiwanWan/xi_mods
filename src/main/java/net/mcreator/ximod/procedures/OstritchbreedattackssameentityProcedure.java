package net.mcreator.ximod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.ximod.entity.OstritchbreedEntity;
import net.mcreator.ximod.entity.OstritchbabyEntity;
import net.mcreator.ximod.entity.OstritchEntity;
import net.mcreator.ximod.XiModMod;

import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

public class OstritchbreedattackssameentityProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				Entity immediatesourceentity = event.getSource().getImmediateSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("immediatesourceentity", immediatesourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XiModMod.LOGGER.warn("Failed to load dependency world for procedure Ostritchbreedattackssameentity!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				XiModMod.LOGGER.warn("Failed to load dependency x for procedure Ostritchbreedattackssameentity!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				XiModMod.LOGGER.warn("Failed to load dependency y for procedure Ostritchbreedattackssameentity!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				XiModMod.LOGGER.warn("Failed to load dependency z for procedure Ostritchbreedattackssameentity!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XiModMod.LOGGER.warn("Failed to load dependency entity for procedure Ostritchbreedattackssameentity!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				XiModMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Ostritchbreedattackssameentity!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
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
		if (entity instanceof OstritchbreedEntity.CustomEntity && sourceentity instanceof OstritchbreedEntity.CustomEntity) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
			if (!world.isRemote()) {
				if (entity.getPersistentData().getDouble("particleTimer") == 5) {
					posx = (sourceentity.getPosX());
					posy = (sourceentity.getPosY());
					posz = (sourceentity.getPosZ());
					health = ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1);
					oxygen = (sourceentity.getAir());
					yaw = (sourceentity.rotationYaw);
					pitch = (sourceentity.rotationPitch);
					feedTimer = 6000;
					breedTimer = (sourceentity.getPersistentData().getDouble("breedTimer"));
					babyTimer = (sourceentity.getPersistentData().getDouble("babyTimer"));
					particleTimer = (sourceentity.getPersistentData().getDouble("particleTimer"));
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new OstritchEntity.CustomEntity(OstritchEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(posx, posy, posz, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
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
							if (((Entity) world.getEntitiesWithinAABB(AnimalEntity.class,
									new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)), null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof AnimalEntity) {
								if (!(entity.getDisplayName().getString()).equals("ostritch")) {
									((Entity) world.getEntitiesWithinAABB(AnimalEntity.class,
											new AxisAlignedBB(x - (1 / 2d), y - (1 / 2d), z - (1 / 2d), x + (1 / 2d), y + (1 / 2d), z + (1 / 2d)),
											null).stream().sorted(new Object() {
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
					if (!sourceentity.world.isRemote())
						sourceentity.remove();
					if (((Entity) world.getEntitiesWithinAABB(OstritchEntity.CustomEntity.class,
							new AxisAlignedBB(posx - (1 / 2d), posy - (1 / 2d), posz - (1 / 2d), posx + (1 / 2d), posy + (1 / 2d), posz + (1 / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(posx, posy, posz)).findFirst().orElse(null)) != null) {
						targetentity = (Entity) world.getEntitiesWithinAABB(OstritchEntity.CustomEntity.class, new AxisAlignedBB(posx - (1 / 2d),
								posy - (1 / 2d), posz - (1 / 2d), posx + (1 / 2d), posy + (1 / 2d), posz + (1 / 2d)), null).stream()
								.sorted(new Object() {
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
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new OstritchbabyEntity.CustomEntity(OstritchbabyEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(posx, posy, posz, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					if (((Entity) world.getEntitiesWithinAABB(OstritchbabyEntity.CustomEntity.class,
							new AxisAlignedBB(posx - (1 / 2d), posy - (1 / 2d), posz - (1 / 2d), posx + (1 / 2d), posy + (1 / 2d), posz + (1 / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(posx, posy, posz)).findFirst().orElse(null)) != null) {
						targetentity = (Entity) world.getEntitiesWithinAABB(OstritchbabyEntity.CustomEntity.class, new AxisAlignedBB(posx - (1 / 2d),
								posy - (1 / 2d), posz - (1 / 2d), posx + (1 / 2d), posy + (1 / 2d), posz + (1 / 2d)), null).stream()
								.sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(posx, posy, posz)).findFirst().orElse(null);
						targetentity.getPersistentData().putDouble("feedTimer", feedTimer);
						targetentity.getPersistentData().putDouble("breedTimer", breedTimer);
						targetentity.getPersistentData().putDouble("babyTimer", babyTimer);
						targetentity.getPersistentData().putDouble("particleTimer", particleTimer);
					}
				} else {
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.HEART, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()), (int) 5,
								0.5, 0.5, 0.5, 0.5);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.HEART, (sourceentity.getPosX()), (sourceentity.getPosY()),
								(sourceentity.getPosZ()), (int) 5, 0.5, 0.5, 0.5, 0.5);
					}
					entity.getPersistentData().putDouble("particleTimer", (entity.getPersistentData().getDouble("particleTimer") + 1));
					sourceentity.getPersistentData().putDouble("particleTimer", (entity.getPersistentData().getDouble("particleTimer")));
				}
			}
		}
	}
}
