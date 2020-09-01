// /summon husk ~ ~1 ~ {ArmorItems:[{Count:1,id:"sophosquest:earth_crystal_boots"},{Count:1,id:"sophosquest:earth_crystal_leggings"},{Count:1,id:"sophosquest:earth_crystal_chestplate"},{Count:1,id:"sophosquest:earth_crystal_helmet"}]}
package com.timourx.sophosquest.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.util.Hand;

import java.util.ArrayList;

public class EarthCrystalArmorItem extends ArmorItem {

    private final int DAMAGE_ADDER;

    public EarthCrystalArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn, int damageAdder) {
        super(materialIn, slot, builderIn);
        this.DAMAGE_ADDER = damageAdder;
    }

    public int getDamageAdder() {
        return DAMAGE_ADDER;
    }

    public void setDamage(EarthCrystalArmorItem equipment, ItemStack heldItem) {
        if (heldItem.getItem() instanceof TieredItem) {
            if (!(((TieredItem) heldItem.getItem()).getTier() == ModItemTier.EARTH_CRYSTAL || ((TieredItem) heldItem.getItem()).getTier() == ModItemTier.FOSSIL)) {
                heldItem.setDamage(heldItem.getDamage() + equipment.getDamageAdder());
            }
        }
    }
    /*
    public static void onEntityAttackedWithEquipedArmor(PlayerEntity player, Hand hand, ArrayList<ItemStack> armorStack) {
        ItemStack heldItem = player.getHeldItem(hand);
        int DAMAGE_ADDER = 0;
        if (!player.isCreative()) {
            if (heldItem.getItem() instanceof TieredItem) {
                if (!(((TieredItem) heldItem.getItem()).getTier() == ModItemTier.EARTH_CRYSTAL || ((TieredItem) heldItem.getItem()).getTier() == ModItemTier.FOSSIL)) {
                    for (ItemStack itemStack : armorStack) {
                        if (itemStack.getItem() instanceof EarthCrystalArmorItem) {
                            DAMAGE_ADDER += ((EarthCrystalArmorItem) itemStack.getItem()).getDamageAdder();
                        }
                    }
                    heldItem.setDamage(heldItem.getDamage() + DAMAGE_ADDER);
                }
            }
        }
    }
     */
}
