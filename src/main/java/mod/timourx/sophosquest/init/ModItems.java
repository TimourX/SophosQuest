package mod.timourx.sophosquest.init;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.init.enums.ModArmorMaterial;
import mod.timourx.sophosquest.init.enums.ModItemTier;
import mod.timourx.sophosquest.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SophosQuest.MOD_ID);

    // Items
    public static final RegistryObject<Item> EARTH_CRYSTAL = ITEMS.register("earth_crystal", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS)));
    public static final RegistryObject<Item> FOSSIL = ITEMS.register("fossil", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS)));
    public static final RegistryObject<Item> MOOFAH_FUR = ITEMS.register("moofah_fur", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS)));
    public static final RegistryObject<Item> MOOFAH_HORN = ITEMS.register("moofah_horn", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS))); // Dans une potion, ça donne l'effet Wide-Range (Soutien) qui tranfère tout les effets de bonus à nos amis et animaux
    public static final RegistryObject<Item> MACCAO_HIDE = ITEMS.register("maccao_hide", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS)));
    public static final RegistryObject<Item> MACCAO_FANG = ITEMS.register("maccao_fang", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS)));
    public static final RegistryObject<Item> LIFECRYSTALS = ITEMS.register("lifecrystals", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_MATERIALS)));

    // Foods
    public static final RegistryObject<Item> RAW_MOOFAH_MEAT = ITEMS.register("raw_moofah_meat", () -> new Item(new Item.Properties().group(ModItemGroups.MOD_FOODS).food(new Food.Builder().meat().hunger(2).saturation(0.3f).setAlwaysEdible().build())));
    public static final RegistryObject<Item> COOKED_MOOFAH_MEAT = ITEMS.register("cooked_moofah_meat", () -> new CookedMoofahMeatItem(new Item.Properties().group(ModItemGroups.MOD_FOODS).food(new Food.Builder().meat().hunger(6).saturation(0.8f).setAlwaysEdible().build())));

    // Block Items
    public static final RegistryObject<BlockItem> EARTH_CRYSTAL_ORE_ITEM = ITEMS.register("earth_crystal_ore", () -> new BlockItem(ModBlocks.EARTH_CRYSTAL_ORE.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));
    public static final RegistryObject<BlockItem> EARTH_CRYSTAL_BLOCK_ITEM = ITEMS.register("earth_crystal_block", () -> new BlockItem(ModBlocks.EARTH_CRYSTAL_BLOCK.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));
    public static final RegistryObject<BlockItem> FOSSIL_BLOCK_ITEM = ITEMS.register("fossil_block", () -> new BlockItem(ModBlocks.FOSSIL_BLOCK.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));
    public static final RegistryObject<BlockItem> ABRASIVE_BLOCK_ITEM = ITEMS.register("abrasive_block", () -> new BlockItem(ModBlocks.ABRASIVE_BLOCK.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));
    public static final RegistryObject<BlockItem> CHIPPED_ABRASIVE_BLOCK_ITEM = ITEMS.register("chipped_abrasive_block", () -> new BlockItem(ModBlocks.CHIPPED_ABRASIVE_BLOCK.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));
    public static final RegistryObject<BlockItem> DAMAGED_ABRASIVE_BLOCK_ITEM = ITEMS.register("damaged_abrasive_block", () -> new BlockItem(ModBlocks.DAMAGED_ABRASIVE_BLOCK.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));
    public static final RegistryObject<BlockItem> MOOFAH_FLEECEBALL_ITEM = ITEMS.register("moofah_fleeceball", () -> new BlockItem(ModBlocks.MOOFAH_FLEECEBALL.get(), new Item.Properties().group(ModItemGroups.MOD_BLOCKS)));

    // Tools
    public static final RegistryObject<SwordItem> EARTH_CRYSTAL_SWORD = ITEMS.register("earth_crystal_sword", () -> new SwordItem(ModItemTier.EARTH_CRYSTAL, 2, -2.4f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<PickaxeItem> EARTH_CRYSTAL_PICKAXE = ITEMS.register("earth_crystal_pickaxe", () -> new PickaxeItem(ModItemTier.EARTH_CRYSTAL, 0, -2.4f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<AxeItem> EARTH_CRYSTAL_AXE = ITEMS.register("earth_crystal_axe", () -> new AxeItem(ModItemTier.EARTH_CRYSTAL, 4, -2.4f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<ShovelItem> EARTH_CRYSTAL_SHOVEL = ITEMS.register("earth_crystal_shovel", () -> new ShovelItem(ModItemTier.EARTH_CRYSTAL, 0, -2.4f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<HoeItem> EARTH_CRYSTAL_HOE = ITEMS.register("earth_crystal_hoe", () -> new HoeItem(ModItemTier.EARTH_CRYSTAL, 0, -2.4f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<HealthFluteItem> HEALTH_FLUTE = ITEMS.register("health_flute", () -> new HealthFluteItem(new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS).maxStackSize(1).defaultMaxDamage(5)));

    // Armor
    public static final RegistryObject<EarthCrystalArmorItem> EARTH_CRYSTAL_HELMET = ITEMS.register("earth_crystal_helmet", () -> new EarthCrystalArmorItem(ModArmorMaterial.EARTH_CRYSTAL, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS), 2));
    public static final RegistryObject<EarthCrystalArmorItem> EARTH_CRYSTAL_CHESTPLATE = ITEMS.register("earth_crystal_chestplate", () -> new EarthCrystalArmorItem(ModArmorMaterial.EARTH_CRYSTAL, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS), 5));
    public static final RegistryObject<EarthCrystalArmorItem> EARTH_CRYSTAL_LEGGINGS = ITEMS.register("earth_crystal_leggings", () -> new EarthCrystalArmorItem(ModArmorMaterial.EARTH_CRYSTAL, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS), 4));
    public static final RegistryObject<EarthCrystalArmorItem> EARTH_CRYSTAL_BOOTS = ITEMS.register("earth_crystal_boots", () -> new EarthCrystalArmorItem(ModArmorMaterial.EARTH_CRYSTAL, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS), 1));

    public static final RegistryObject<MoofahFurArmorItem> MOOFAH_FUR_TURBAN = ITEMS.register("moofah_fur_turban", () -> new MoofahFurArmorItem(ModArmorMaterial.MOOFAH_FUR, EquipmentSlotType.HEAD, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<MoofahFurArmorItem> MOOFAH_FUR_MAIL = ITEMS.register("moofah_fur_mail", () -> new MoofahFurArmorItem(ModArmorMaterial.MOOFAH_FUR, EquipmentSlotType.CHEST, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<MoofahFurArmorItem> MOOFAH_FUR_PANTS = ITEMS.register("moofah_fur_pants", () -> new MoofahFurArmorItem(ModArmorMaterial.MOOFAH_FUR, EquipmentSlotType.LEGS, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
    public static final RegistryObject<MoofahFurArmorItem> MOOFAH_FUR_BOOTS = ITEMS.register("moofah_fur_boots", () -> new MoofahFurArmorItem(ModArmorMaterial.MOOFAH_FUR, EquipmentSlotType.FEET, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));

    // Weapons
    // attackSpeed = 1 / (4 - attackSpeedIn) * 20 ticks
    public static final RegistryObject<PetrifiedBladeItem> PETRIFIED_BLADE = ITEMS.register("petrified_blade", () -> new PetrifiedBladeItem(ModItemTier.FOSSIL, 0, -3.25f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS).isImmuneToFire()));
    public static final RegistryObject<PlumeSwordItem> PLUME_SWORD = ITEMS.register("plume_sword", () -> new PlumeSwordItem(ModItemTier.MACCAO_HIDE, 3, -2.4f, new Item.Properties().group(ModItemGroups.MOD_COMBAT_TOOLS)));
}
