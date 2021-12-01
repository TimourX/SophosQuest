package mod.timourx.sophosquest.items;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.init.ModParticles;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class HealthFluteItem extends Item {

    private static final float BREAK_CHANCE = 0.5f;

    public HealthFluteItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        float ray = 10f;
        List<LivingEntity> list = worldIn.getLoadedEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
                playerIn.getPosX() + ray,
                playerIn.getPosY() + ray,
                playerIn.getPosZ() + ray,
                playerIn.getPosX() - ray,
                playerIn.getPosY() - ray,
                playerIn.getPosZ() - ray));
        playerIn.getCooldownTracker().setCooldown(this, 100);
        playerIn.heal(10f);

        for (LivingEntity e : list) {
            if (MathHelper.sqrt(Math.pow(playerIn.getPosX() - e.getPosX(), 2) + Math.pow(playerIn.getPosY() - e.getPosY(), 2) + Math.pow(playerIn.getPosZ() - e.getPosZ(), 2)) <= ray) {
                if (!(e.getHealth() >= e.getMaxHealth())) {
                    if (e instanceof TameableEntity) {
                        if (((TameableEntity) e).isTamed()) {
                            if (((TameableEntity) e).getOwnerId() == playerIn.getUniqueID()) {
                                e.heal(10f);
                                addHeartParticle(e, worldIn);
                            } else if (!worldIn.isRemote) {
                                if (e.isOnSameTeam(playerIn) || !Objects.requireNonNull(playerIn.getServer()).isPVPEnabled()) {
                                    e.heal(10f);
                                    addHeartParticle(e, worldIn);
                                }
                            }
                        }
                    } else if (e instanceof PlayerEntity && !worldIn.isRemote) {
                        if (e.isOnSameTeam(playerIn) || !Objects.requireNonNull(playerIn.getServer()).isPVPEnabled()) {
                            e.heal(10f);
                            addHeartParticle(e, worldIn);
                        }
                    } else if (e instanceof AbstractHorseEntity) {
                        if (((AbstractHorseEntity) e).isTame()) {
                            if (((AbstractHorseEntity) e).getOwnerUniqueId() == playerIn.getUniqueID()) {
                                e.heal(10f);
                                addHeartParticle(e, worldIn);
                            } else if (!worldIn.isRemote) {
                                if (e.isOnSameTeam(playerIn) || !Objects.requireNonNull(playerIn.getServer()).isPVPEnabled()) {
                                e.heal(10f);
                                addHeartParticle(e, worldIn);
                                }
                            }
                        }
                    }
                }
            }
        }

        float RNG = playerIn.getRNG().nextFloat();
        if (RNG <= BREAK_CHANCE) {
            playerIn.getHeldItem(handIn).setDamage(1);
        }

        worldIn.addParticle(ModParticles.HEALTH_SOUND.get(), playerIn.getPosX(), playerIn.getPosY() + 1.2d, playerIn.getPosZ(), 0d, 0d, 0d);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    private void addHeartParticle(LivingEntity entity, World world) {
        for (int i = 0; i < 10; i++) {
            double d0 = entity.getRNG().nextGaussian() * 0.02D;
            double d1 = entity.getRNG().nextGaussian() * 0.02D;
            double d2 = entity.getRNG().nextGaussian() * 0.02D;
            world.addParticle(ParticleTypes.HEART, entity.getPosXRandom(1.0D), entity.getPosYRandom() + 0.5D, entity.getPosZRandom(1.0D), d0, d1, d2);
        }
    }
}
