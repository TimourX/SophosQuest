package com.timourx.sophosquest.events;

import com.timourx.sophosquest.SophosQuest;
import com.timourx.sophosquest.items.ModItems;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SophosQuest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusClientEvents {

    @SubscribeEvent
    public static void itemColorsRegistryHandler(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, index) -> index > 0 ? -1 : ((IDyeableArmorItem)stack.getItem()).getColor(stack), ModItems.MOOFAH_FUR_TURBAN.get(), ModItems.MOOFAH_FUR_MAIL.get(), ModItems.MOOFAH_FUR_PANTS.get(), ModItems.MOOFAH_FUR_BOOTS.get());
    }
}
