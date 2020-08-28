package com.timourx.sophosquest.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.TieredItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class AbrasiveBlock extends Block {

    public static final int DAMAGE_REMOVED = 40;

    public AbrasiveBlock() {
        super(Block.Properties.create(Material.IRON));
    }

    @Override
    @Nonnull
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack heldItem = player.getHeldItem(handIn);
        if (heldItem.getItem() instanceof TieredItem || heldItem.getItem() == Items.SHEARS) {
            if (heldItem.getDamage() == 0) {
                return ActionResultType.PASS;
            } else {
                heldItem.setDamage(Math.max(heldItem.getDamage() - DAMAGE_REMOVED, 0));
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.PASS;
    }
}
