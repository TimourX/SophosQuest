package mod.timourx.sophosquest.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class PlumeSwordItem extends SwordItem {

    public PlumeSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addPotionEffect(new EffectInstance(Effects.WEAKNESS, 200));
        target.addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, 3000));
        return super.hitEntity(stack, target, attacker);
    }
}
