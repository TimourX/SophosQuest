package com.timourx.sophosquest.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;

import javax.annotation.Nonnull;

public class PetrifiedBladeItem extends SwordItem {


    public PetrifiedBladeItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean isEnchantable(@Nonnull ItemStack stack) {
        return false;
    }
}
