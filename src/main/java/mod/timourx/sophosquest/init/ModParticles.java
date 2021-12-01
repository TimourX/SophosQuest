package mod.timourx.sophosquest.init;

import mod.timourx.sophosquest.SophosQuest;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, SophosQuest.MOD_ID);


    public static final RegistryObject<BasicParticleType> HEALTH_SOUND = PARTICLE_TYPES.register("health_sound", () -> new BasicParticleType(false));
}
