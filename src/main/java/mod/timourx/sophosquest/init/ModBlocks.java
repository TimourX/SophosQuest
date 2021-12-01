package mod.timourx.sophosquest.init;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.blocks.AbrasiveBlock;
import mod.timourx.sophosquest.blocks.EarthCrystalOre;
import mod.timourx.sophosquest.blocks.FossilBlock;
import mod.timourx.sophosquest.blocks.MoofahFleeceballBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SophosQuest.MOD_ID);

    // Blocks
    public static final RegistryObject<Block> EARTH_CRYSTAL_ORE = BLOCKS.register("earth_crystal_ore", EarthCrystalOre::new);
    public static final RegistryObject<Block> FOSSIL_BLOCK = BLOCKS.register("fossil_block", FossilBlock::new);
    public static final RegistryObject<Block> EARTH_CRYSTAL_BLOCK = BLOCKS.register("earth_crystal_block", () -> new Block(Block.Properties.create(Material.IRON).setRequiresTool().hardnessAndResistance(5.0f, 3.0f).harvestTool(ToolType.PICKAXE).harvestLevel(1)));
    public static final RegistryObject<Block> ABRASIVE_BLOCK = BLOCKS.register("abrasive_block", () -> new AbrasiveBlock(Block.Properties.create(Material.ANVIL).sound(SoundType.ANVIL).setRequiresTool().hardnessAndResistance(5.0f, 1200.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> CHIPPED_ABRASIVE_BLOCK = BLOCKS.register("chipped_abrasive_block", () -> new AbrasiveBlock(Block.Properties.create(Material.ANVIL).sound(SoundType.ANVIL).setRequiresTool().hardnessAndResistance(5.0f, 1200.0f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> DAMAGED_ABRASIVE_BLOCK = BLOCKS.register("damaged_abrasive_block", () -> new AbrasiveBlock(Block.Properties.create(Material.ANVIL).sound(SoundType.ANVIL).setRequiresTool().hardnessAndResistance(2.5f).harvestLevel(1).harvestTool(ToolType.PICKAXE)));
    public static final RegistryObject<Block> MOOFAH_FLEECEBALL = BLOCKS.register("moofah_fleeceball", () -> new MoofahFleeceballBlock(Block.Properties.create(Material.WOOL).sound(SoundType.CLOTH).hardnessAndResistance(0.8f)));
}
