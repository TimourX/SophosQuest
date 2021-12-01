// /summon husk ~ ~1 ~ {ArmorItems:[{Count:1,id:"sophosquest:earth_crystal_boots"},{Count:1,id:"sophosquest:earth_crystal_leggings"},{Count:1,id:"sophosquest:earth_crystal_chestplate"},{Count:1,id:"sophosquest:earth_crystal_helmet"}]}
package mod.timourx.sophosquest.items;

import mod.timourx.sophosquest.init.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;

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
}
