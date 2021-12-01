package mod.timourx.sophosquest.init.enums;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {
    EARTH_CRYSTAL(SophosQuest.MOD_ID + ":earth_crystal", 23, new int[] { 3, 5, 6, 2}, 3, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.2f, () -> { return Ingredient.fromItems(ModItems.EARTH_CRYSTAL.get());}, 0.05f),
    MOOFAH_FUR(SophosQuest.MOD_ID + ":moofah_fur", 3, new int[] { 1, 2, 3, 1 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f, () -> { return Ingredient.fromItems(ModItems.MOOFAH_FUR.get());}, 0.0f);

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantabilty;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResistance;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantabilty, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantabilty = enchantabilty;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResistance = knockbackResistance;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantabilty;
    }

    @Override
    @Nonnull
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    @Nonnull
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    @Nonnull
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
