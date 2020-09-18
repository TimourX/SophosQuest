package com.timourx.sophosquest.entities.goal;

import com.timourx.sophosquest.entities.FemaleMoofahEntity;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.vector.Vector3d;

import java.util.Objects;

public class MoofahSwimGoal extends Goal {

    private final TameableEntity entity;
    private Vector3d path;

    public MoofahSwimGoal(FemaleMoofahEntity entity) {
        this.entity = entity;
        entity.getNavigator().setCanSwim(true);
    }

    @Override
    public boolean shouldExecute() {
        return this.entity.isInWater() && this.entity.func_233571_b_(FluidTags.WATER) > this.entity.func_233579_cu_() || this.entity.isInLava();
    }

    @Override
    public void startExecuting() {
        if (this.entity.getNavigator().noPath()) {
            this.path = this.getPosition();
        }
        if (path != null){
            if (!this.entity.isTamed()) {
                this.entity.getNavigator().tryMoveToXYZ(this.path.x, this.path.y, this.path.z, 0.8d);
            } else {
                this.entity.getNavigator().tryMoveToEntityLiving(Objects.requireNonNull(this.entity.getOwner()), 0.8d);
            }
        }
    }

    protected Vector3d getPosition() {
        Vector3d vector3d = RandomPositionGenerator.getLandPos(this.entity, 20, 10);
        return vector3d == null ? RandomPositionGenerator.findRandomTarget(this.entity, 10, 7) : vector3d;
    }



    public void tick() {
        if (this.entity.getRNG().nextFloat() < 0.8F) {
            this.entity.getJumpController().setJumping();
        }
    }
}