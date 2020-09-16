package com.timourx.sophosquest.util;

import com.timourx.sophosquest.SophosQuest;
import com.timourx.sophosquest.client.renderer.FemaleMoofahRenderer;
import com.timourx.sophosquest.init.ModEntityTypes;
import com.timourx.sophosquest.init.ModItems;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = SophosQuest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void itemColorsRegistryHandler(ColorHandlerEvent.Item event) {
        event.getItemColors().register((stack, index) -> index > 0 ? -1 : ((IDyeableArmorItem)stack.getItem()).getColor(stack), ModItems.MOOFAH_FUR_TURBAN.get(), ModItems.MOOFAH_FUR_MAIL.get(), ModItems.MOOFAH_FUR_PANTS.get(), ModItems.MOOFAH_FUR_BOOTS.get());
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.FEMALE_MOOFAH.get(), FemaleMoofahRenderer::new);
    }
}
