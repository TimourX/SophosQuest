package mod.timourx.sophosquest.blocks;

import mod.timourx.sophosquest.SophosQuest;
import mod.timourx.sophosquest.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.TieredItem;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.stream.Stream;

public class AbrasiveBlock extends Block {

    private static final int DAMAGE_REMOVED = 40;
    private static final float BREAK_CHANCE = 0.04f;
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_NS = Stream.of(
            Block.makeCuboidShape(0, 0, 5, 16, 9, 11),
            Block.makeCuboidShape(1, 0, 1, 15, 7, 5),
            Block.makeCuboidShape(1, 0, 11, 15, 7, 15)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_EW = Stream.of(
            Block.makeCuboidShape(5, 0, 0, 11, 9, 16),
            Block.makeCuboidShape(11, 0, 1, 15, 7, 15),
            Block.makeCuboidShape(1, 0, 1, 5, 7, 15)).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    public AbrasiveBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    @Nonnull
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            ItemStack heldItem = player.getHeldItem(handIn);
            if (heldItem.getItem() instanceof TieredItem || heldItem.getItem() == Items.SHEARS) {
                if (heldItem.getDamage() == 0) {
                    return ActionResultType.PASS;
                } else {
                    heldItem.setDamage(Math.max(heldItem.getDamage() - DAMAGE_REMOVED, 0));
                    float RNG = player.getRNG().nextFloat();
                    if (RNG < BREAK_CHANCE) {
                        damage(state, worldIn, pos);
                    }
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return ActionResultType.PASS;
    }

    public static void damage(BlockState state, World world, BlockPos pos) {
        FluidState fluidstate = world.getFluidState(pos);
        if (state.matchesBlock(ModBlocks.ABRASIVE_BLOCK.get())) {
            world.setBlockState(pos, ModBlocks.CHIPPED_ABRASIVE_BLOCK.get().getDefaultState().with(FACING, state.get(FACING)).with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER), 2);
        } else if (state.matchesBlock(ModBlocks.CHIPPED_ABRASIVE_BLOCK.get())) {
            world.setBlockState(pos, ModBlocks.DAMAGED_ABRASIVE_BLOCK.get().getDefaultState().with(FACING, state.get(FACING)).with(WATERLOGGED, fluidstate.getFluid() == Fluids.WATER), 2);
        } else {
            world.destroyBlock(pos, false);
        }
    }

    @Override
    @Nonnull
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case EAST:
            case WEST:
                return SHAPE_EW;
            default:
                return SHAPE_NS;
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
        return 0.7f;
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
