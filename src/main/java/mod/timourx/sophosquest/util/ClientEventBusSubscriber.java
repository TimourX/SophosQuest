package mod.timourx.sophosquest.util;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.client.renderer.FemaleMoofahRenderer;
import mod.timourx.sophosquest.init.ModEntityTypes;
import mod.timourx.sophosquest.init.ModItems;
import mod.timourx.sophosquest.init.ModParticles;
import mod.timourx.sophosquest.particle.HealthSoundParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
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

    @SubscribeEvent
    public static void particleRegistryEvent(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particles.registerFactory(ModParticles.HEALTH_SOUND.get(), HealthSoundParticle.Factory::new);
    }
}
