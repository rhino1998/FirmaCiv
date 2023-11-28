package com.hyperdash.firmaciv.common.block;

import com.hyperdash.firmaciv.common.blockentity.WatercraftFrameBlockEntity;
import com.hyperdash.firmaciv.util.FirmacivTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;

public class AngledWatercraftFrameBlock extends SquaredAngleBlock {

    public static final IntegerProperty FRAME_PROCESSED = FirmacivBlockStateProperties.FRAME_PROCESSED_8;

    public AngledWatercraftFrameBlock(final BlockState blockState, final BlockBehaviour.Properties properties) {
        super(blockState, properties);
    }

    @Override
    public InteractionResult use(final BlockState blockState, final Level level, final BlockPos blockPos,
            final Player player, final InteractionHand hand, final BlockHitResult hitResult) {
        // Don't do logic on client side
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        final ItemStack heldStack = player.getItemInHand(hand);

        // Should we do plank stuff
        if (!heldStack.is(FirmacivTags.Items.PLANKS)) return InteractionResult.SUCCESS;

        // We must replace ourselves with the correct wood version
        for (final RegistryObject<Block> registryObject : FirmacivBlocks.WOOD_WATERCRAFT_FRAMES.values()) {
            if (!(registryObject.get() instanceof WoodenAngledWatercraftFrameBlock woodenFrameBlock)) continue;

            // Must find the right block variant for this item
            if (!heldStack.is(woodenFrameBlock.getUnderlyingPlank().asItem())) continue;

            final BlockState newBlockState = woodenFrameBlock.defaultBlockState().setValue(FRAME_PROCESSED, 1)
                    .setValue(SHAPE, blockState.getValue(SHAPE)).setValue(FACING, blockState.getValue(FACING));

            level.setBlock(blockPos, newBlockState, 10);

            if (level.getBlockEntity(blockPos) instanceof WatercraftFrameBlockEntity frameBlockEntity) {
                frameBlockEntity.insertPlanks(heldStack.split(1));
            }

            level.playSound(null, blockPos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.5F,
                    level.getRandom().nextFloat() * 0.1F + 0.9F);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.SUCCESS;
    }
}