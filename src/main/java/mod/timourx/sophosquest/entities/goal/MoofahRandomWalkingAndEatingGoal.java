package mod.timourx.sophosquest.entities.goal;

import mod.timourx.sophosquest.entities.FemaleMoofahEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

public class MoofahRandomWalkingAndEatingGoal extends Goal {
    
    private final LivingEntity entity;
    private final double speed;

    public MoofahRandomWalkingAndEatingGoal(LivingEntity entityIn, double speed) {
        this.entity = entityIn;
        this.speed = speed;
    }

    @Override
    public boolean shouldExecute() {
        if (this.entity.isBeingRidden() || entity.isInWater() || entity.isInLava()) {
            return false;
        } else if (this.entity instanceof FemaleMoofahEntity) {
            return !((FemaleMoofahEntity) this.entity).isRunning();
        }
        return true;
    }
}
