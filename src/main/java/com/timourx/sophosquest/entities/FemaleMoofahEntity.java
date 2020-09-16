package com.timourx.sophosquest.entities;

import com.timourx.sophosquest.entities.goal.MoofahPanicGoal;
import com.timourx.sophosquest.init.ModEntityTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class FemaleMoofahEntity extends TameableEntity {

    public static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.CARROT, Items.WHEAT, Items.DANDELION);
    private EatGrassGoal eatGrassGoal;
    private int moofahTimer;
    private FemaleMoofahEntity target;
    private LivingEntity attacker;

    public FemaleMoofahEntity(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 10.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    protected void registerGoals() {
        double walkSpeed = 0.5d;
        super.registerGoals();
        this.eatGrassGoal = new EatGrassGoal(this);
        //this.goalSelector.addGoal(0, new MoofahSwimGoal(this));
        this.goalSelector.addGoal(0, new SwimGoal(this));
        //this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new MoofahPanicGoal(this, 1.25d));
        //this.goalSelector.addGoal(2, new SitGoal(this));
        //this.goalSelector.addGoal(2, new FollowOwnerGoal(this, 1.0D, 10.0f, 1.5f, false));
        this.goalSelector.addGoal(3, new BreedGoal(this, walkSpeed));
        this.goalSelector.addGoal(4, new TemptGoal(this, walkSpeed, TEMPTATION_ITEMS, false));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(6, this.eatGrassGoal);
        this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, walkSpeed));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        //this.goalSelector.addGoal(8, new LookAtGoal(this, MaleMoofahEntity.class, 8.0F));
        this.goalSelector.addGoal(9, new LookRandomlyGoal(this));
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return this.world.rand.nextInt(2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_LLAMA_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_LLAMA_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_LLAMA_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ENTITY_LLAMA_STEP, 0.15f, 1.0f);
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        return ModEntityTypes.FEMALE_MOOFAH.get().create(this.world);
    }
    @Override
    protected void updateAITasks() {
        this.moofahTimer = this.eatGrassGoal.getEatingGrassTimer();
        super.updateAITasks();
    }

    @Override
    public void livingTick() {
        if (this.world.isRemote) {
            this.moofahTimer = Math.max(0, this.moofahTimer);
        }
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 10) {
            this.moofahTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (source.getTrueSource() instanceof LivingEntity) {
            this.target = this;
            this.attacker = (LivingEntity) source.getTrueSource();
        }
        return super.attackEntityFrom(source, amount);
    }

    public FemaleMoofahEntity getTarget() {
        return this.target;
    }

    public LivingEntity getAttacker() {
        return this.attacker;
    }

    public void moveForwardWithSpeed(float speed) {
        this.addVelocity(this.getForward().getX() * speed, this.getForward().getY() * speed, this.getForward().getZ() * speed);
    }
}
