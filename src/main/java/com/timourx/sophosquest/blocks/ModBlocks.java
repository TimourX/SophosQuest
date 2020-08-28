package com.timourx.sophosquest.blocks;

import com.timourx.sophosquest.SophosQuest;
import net.minecraft.block.Block;
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
    public static final RegistryObject<Block> ABRASIVE_BLOCK = BLOCKS.register("abrasive_block", AbrasiveBlock::new);
}
