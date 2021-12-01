package mod.timourx.sophosquest.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BasicParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HealthSoundParticle extends SpriteTexturedParticle {

    private final IAnimatedSprite animatedSprite;

    protected HealthSoundParticle(ClientWorld clientWorld, double x, double y, double z, IAnimatedSprite animatedSprite) {
        super(clientWorld, x, y, z, 0f, 0f, 0f);
        this.animatedSprite = animatedSprite;
        this.maxAge = 11;
        this.particleGravity = 0f;
        this.selectSpriteWithAge(animatedSprite);
        this.particleScale *= 13f;
        this.canCollide = false;
    }

    @Override
    public void tick() {
        this.setAlphaF(0.6f);
        if (this.age++ >= this.maxAge) {
            this.setExpired();
        } else {
            this.selectSpriteWithAge(this.animatedSprite);
        }
    }

    @Override
    public IParticleRenderType getRenderType() {
        return IParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BasicParticleType> {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSet){
            this.spriteSet = spriteSet;
        }

        @Override
        public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new HealthSoundParticle(worldIn, x, y, z, this.spriteSet);
        }
    }
}
