package com.timourx.sophosquest.events;


import com.timourx.sophosquest.SophosQuest;
import com.timourx.sophosquest.items.EarthCrystalArmorItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.DyeableArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = SophosQuest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeBusClientEvents {

    @SubscribeEvent
    public static void onClientPlayerAttackEntity(AttackEntityEvent event) {
        if (!event.getPlayer().getEntityWorld().isRemote) {
            if (!event.getPlayer().isCreative()) {
                Entity target = event.getTarget();
                if (target.isLiving() && !(target instanceof ArmorStandEntity)) {
                    ArrayList<ItemStack> armorStack = new ArrayList<>();
                    for (ItemStack itemStack : target.getEquipmentAndArmor()) {
                        armorStack.add(itemStack);
                    }
                    armorStack.remove(0);
                    armorStack.remove(0);
                    for (ItemStack itemStack : armorStack) {
                        if (itemStack.getItem() instanceof EarthCrystalArmorItem) {
                            ((EarthCrystalArmorItem) itemStack.getItem()).setDamage((EarthCrystalArmorItem) itemStack.getItem(), event.getPlayer().getHeldItem(event.getPlayer().getActiveHand()));
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void testJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            if (event.getEntityLiving().getHeldItem(Hand.MAIN_HAND).getItem() instanceof DyeableArmorItem) {
                SophosQuest.LOGGER.info(((DyeableArmorItem) event.getEntityLiving().getHeldItem(Hand.MAIN_HAND).getItem()).getColor(event.getEntityLiving().getHeldItem(Hand.MAIN_HAND)));
            }
        }
    }
}