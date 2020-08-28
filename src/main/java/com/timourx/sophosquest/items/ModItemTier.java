package com.timourx.sophosquest.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    FOSSIL(0, 200,0.0f, 5.0f, 0, () -> {return Ingredient.fromItems(ModItems.EARTH_CRYSTAL.get());}),
    EARTH_CRYSTAL(2, 200, 2.0f, 1.0f, 3, () -> {return Ingredient.fromItems(ModItems.EARTH_CRYSTAL.get());});

    private int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private int enchantability;
    private Supplier<Ingredient> repairMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }
    @Override
    public int getMaxUses() {
        return this.maxUses;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    @Nonnull
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }
}
