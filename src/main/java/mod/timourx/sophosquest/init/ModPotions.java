package mod.timourx.sophosquest.init;

import mod.timourx.sophosquest.SophosQuest;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, SophosQuest.MOD_ID);

    public static final RegistryObject<Potion> WIDE_RANGE = POTIONS.register("wide_range", () -> new Potion(new EffectInstance(Effects.SPEED, 3600)));
}
