package com.timourx.sophosquest.entities.goal;

import com.timourx.sophosquest.entities.FemaleMoofahEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class MoofahPanicGoal extends Goal {

    private final FemaleMoofahEntity entity;
    private final double speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    private BlockPos escapePos;

    public MoofahPanicGoal(FemaleMoofahEntity entity, double speed) {
        this.entity = entity;
        this.speed = speed;
        this.setMutexFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean shouldExecute() {
        if (this.entity.getRevengeTarget() == null && !this.entity.isBurning()) {
            return false;
        } else {
            if (this.entity.isBurning()) {
                BlockPos blockpos = this.getRandPos(this.entity.world, this.entity, 5, 4);
                if (blockpos != null) {
                    this.randPosX = blockpos.getX();
                    this.randPosY = blockpos.getY();
                    this.randPosZ = blockpos.getZ();
                    return true;
                }
            }
            return this.findRandomEscapePosition(entity.getTarget(), entity.getAttacker());
        }
    }

    protected boolean findRandomEscapePosition(FemaleMoofahEntity target, LivingEntity attacker) {
        BlockPos targetPos = new BlockPos(attacker.getPositionVec().x, attacker.getBoundingBox().minY - 0.5000001D, target.getPositionVec().z);
        BlockPos attackerPos = new BlockPos(attacker.getPositionVec().x, attacker.getBoundingBox().minY - 0.5000001D, attacker.getPositionVec().z);
        double angle = Math.acos(
                MathHelper.sqrt(Math.pow(targetPos.getX() - attackerPos.getX(), 2d) + Math.pow(0, 2d))
                        / MathHelper.sqrt(Math.pow(targetPos.getX() - attackerPos.getX(), 2d) + Math.pow(targetPos.getZ() - attackerPos.getZ(), 2d))
        );
        BlockPos pos = new BlockPos(target.getPosX() + (target.getPosX() - attacker.getPosX()), targetPos.getY(), target.getPosZ() + (target.getPosZ() - attacker.getPosZ()));
        for (int i = 1; i < 10; i++) {
            pos.add(target.getPosX() - attacker.getPosX(), 0, target.getPosZ() - attacker.getPosZ());
        }
        this.escapePos = pos;
        this.randPosX = pos.getX();
        this.randPosY = pos.getY();
        this.randPosZ = pos.getZ();
        return true;
    }

    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, this.speed);
            /*
            if (this.entity.getNavigator().noPath()) {
                Path path = this.entity.getNavigator().getPathToPos(this.escapePos, 1);
                this.entity.getNavigator().setPath(path, this.speed);
            }
             */
    }

    public boolean shouldContinueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    @Nullable
    protected BlockPos getRandPos(IBlockReader worldIn, Entity entityIn, int horizontalRange, int verticalRange) {
        BlockPos blockpos = entityIn.getPosition();
        int i = blockpos.getX();
        int j = blockpos.getY();
        int k = blockpos.getZ();
        float f = (float)(horizontalRange * horizontalRange * verticalRange * 2);
        BlockPos blockpos1 = null;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int l = i - horizontalRange; l <= i + horizontalRange; ++l) {
            for(int i1 = j - verticalRange; i1 <= j + verticalRange; ++i1) {
                for(int j1 = k - horizontalRange; j1 <= k + horizontalRange; ++j1) {
                    blockpos$mutable.setPos(l, i1, j1);
                    if (worldIn.getFluidState(blockpos$mutable).isTagged(FluidTags.WATER)) {
                        float f1 = (float)((l - i) * (l - i) + (i1 - j) * (i1 - j) + (j1 - k) * (j1 - k));
                        if (f1 < f) {
                            f = f1;
                            blockpos1 = new BlockPos(blockpos$mutable);
                        }
                    }
                }
            }
        }

        return blockpos1;
    }
}
