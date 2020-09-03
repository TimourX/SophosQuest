package com.timourx.sophosquest.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ShearsItem;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class MoofahFleeceballBlock extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(6, 0, 4, 13, 7, 11),
            Block.makeCuboidShape(8, 0, 11, 9, 5, 12),
            Block.makeCuboidShape(8, 0, 12, 9, 1, 15),
            Block.makeCuboidShape(6, 0, 14, 8, 1, 15),
            Block.makeCuboidShape(6, 0, 12, 7, 1, 14),
            Block.makeCuboidShape(2, 0, 12, 6, 1, 13),
            Block.makeCuboidShape(2, 0, 1, 3, 1, 12),
            Block.makeCuboidShape(3, 0, 1, 6, 1, 2)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(5, 0, 6, 12, 7, 13),
            Block.makeCuboidShape(4, 0, 8, 5, 5, 9),
            Block.makeCuboidShape(1, 0, 8, 4, 1, 9),
            Block.makeCuboidShape(1, 0, 6, 2, 1, 8),
            Block.makeCuboidShape(2, 0, 6, 4, 1, 7),
            Block.makeCuboidShape(3, 0, 2, 4, 1, 6),
            Block.makeCuboidShape(4, 0, 2, 15, 1, 3),
            Block.makeCuboidShape(14, 0, 3, 15, 1, 6)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(3, 0, 5, 10, 7, 12),
            Block.makeCuboidShape(7, 0, 4, 8, 5, 5),
            Block.makeCuboidShape(7, 0, 1, 8, 1, 4),
            Block.makeCuboidShape(8, 0, 1, 10, 1, 2),
            Block.makeCuboidShape(9, 0, 2, 10, 1, 4),
            Block.makeCuboidShape(10, 0, 3, 14, 1, 4),
            Block.makeCuboidShape(13, 0, 4, 14, 1, 15),
            Block.makeCuboidShape(10, 0, 14, 13, 1, 15)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(4, 0, 3, 11, 7, 10),
            Block.makeCuboidShape(11, 0, 7, 12, 5, 8),
            Block.makeCuboidShape(12, 0, 7, 15, 1, 8),
            Block.makeCuboidShape(14, 0, 8, 15, 1, 10),
            Block.makeCuboidShape(12, 0, 9, 14, 1, 10),
            Block.makeCuboidShape(12, 0, 10, 13, 1, 14),
            Block.makeCuboidShape(1, 0, 13, 12, 1, 14),
            Block.makeCuboidShape(1, 0, 10, 2, 1, 13)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public MoofahFleeceballBlock(Properties properties) {
        super(properties);
    }

    @Override
    public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
        return player.getHeldItemMainhand().getItem() instanceof ShearsItem ? super.getPlayerRelativeBlockHardness(Blocks.WHITE_WOOL.getDefaultState(), player, worldIn, pos) : super.getPlayerRelativeBlockHardness(state, player, worldIn, pos);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch(state.get(FACING)) {
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        BlockPos blockpos = context.getPos();
        FluidState fluidstate = context.getWorld().getFluidState(blockpos);
        return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite()).with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER);
    }

    @Override
    @Nonnull
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    @Nonnull
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 0.85f;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
