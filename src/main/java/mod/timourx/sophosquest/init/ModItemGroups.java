package mod.timourx.sophosquest.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroups {

    public static final ItemGroup MOD_BLOCKS = new ItemGroup("modBlocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.EARTH_CRYSTAL_ORE_ITEM.get());
        }
    };

    public static final ItemGroup MOD_MATERIALS = new ItemGroup("modMaterials") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.EARTH_CRYSTAL.get());
        }
    };

    public static final ItemGroup MOD_COMBAT_TOOLS = new ItemGroup("modCombatTools") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.PETRIFIED_BLADE.get());
        }
    };

    public static final ItemGroup MOD_FOODS = new ItemGroup("modFoods") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RAW_MOOFAH_MEAT.get());
        }
    };
}
