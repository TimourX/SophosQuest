package com.timourx.sophosquest.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Objects;

public class MoofahFurArmorItem extends DyeableArmorItem {

    public MoofahFurArmorItem(IArmorMaterial p_i50048_1_, EquipmentSlotType p_i50048_2_, Properties p_i50048_3_) {
        super(p_i50048_1_, p_i50048_2_, p_i50048_3_);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        ArrayList<Item> armorList = new ArrayList<>();
        for (ItemStack itemStack : player.getArmorInventoryList()) {
            if (itemStack.getItem() instanceof MoofahFurArmorItem) {
                armorList.add(itemStack.getItem());
            }
        }
        if (armorList.size() == 4) {
            if (!Objects.equals(player.getActivePotionEffect(Effects.SLOW_FALLING), new EffectInstance(Effects.SLOW_FALLING))) {
                player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 10));
            }
            if (!Objects.equals(player.getActivePotionEffect(Effects.REGENERATION), new EffectInstance(Effects.REGENERATION))) {
                player.addPotionEffect(new EffectInstance(Effects.REGENERATION, 10));
            }
        }
    }
}