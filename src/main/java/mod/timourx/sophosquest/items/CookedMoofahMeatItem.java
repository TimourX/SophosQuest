package mod.timourx.sophosquest.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.Objects;

public class CookedMoofahMeatItem extends Item {

    public CookedMoofahMeatItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        PlayerEntity player = entityLiving instanceof PlayerEntity ? (PlayerEntity)entityLiving : null;
        if(!worldIn.isRemote) {
            float RNG = player.getRNG().nextFloat();
            if (RNG < 0.1f) {
                if (!Objects.equals(player.getActivePotionEffect(Effects.SLOW_FALLING), new EffectInstance(Effects.SLOW_FALLING))) {
                    player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 500));
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
