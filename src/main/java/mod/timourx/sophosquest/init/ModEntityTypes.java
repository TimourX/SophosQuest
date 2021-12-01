package mod.timourx.sophosquest.init;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.entities.FemaleMoofahEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, SophosQuest.MOD_ID);

    // Entity Types
    public static final RegistryObject<EntityType<FemaleMoofahEntity>> FEMALE_MOOFAH = ENTITY_TYPES.register("female_moofah", () -> EntityType.Builder.create(FemaleMoofahEntity::new, EntityClassification.CREATURE).size(1.3f, 1.6f).build(new ResourceLocation(SophosQuest.MOD_ID, "female_moofah").toString()));
}
