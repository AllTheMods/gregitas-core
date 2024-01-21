package com.allthemods.gravitas2.core.mixin;

import com.github.alexthe666.iceandfire.world.gen.*;
import com.mojang.serialization.Codec;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(value = WorldGenDragonRoosts.class, remap = false)
public abstract class WorldGenDragonRoostsMixin extends Feature<NoneFeatureConfiguration> implements TypedFeature {

    private static Block TFCRock = TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.HARDENED).get();
    private static Block TFCCobble = TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.COBBLE).get();

    public WorldGenDragonRoostsMixin(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    /**
     * @author thevortex
     * @reason
     */
    @Overwrite
    private void generateShell(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context, int radius) {
        int height = radius / 5;
        double circularArea = this.getCircularArea(radius, height);
        BlockPos.betweenClosedStream(context.origin().offset(-radius, -height, -radius), context.origin().offset(radius, 1, radius)).map(BlockPos::immutable).forEach((position) -> {
            if (position.distSqr(context.origin()) < circularArea) {
                context.level().setBlock(position, context.random().nextBoolean() ? TFCRock.defaultBlockState() : TFCCobble.defaultBlockState(), 2);
            } else if (position.distSqr(context.origin()) == circularArea) {
                context.level().setBlock(position, TFCRock.defaultBlockState(), 2);
            }

        });
    }

    protected double getCircularArea(int radius, int height) {
        double area = (radius + height + radius) * 0.333F + 0.5F;
        return Mth.floor(area * area);
    }

    /**
     * @author thevortex
     * @reason
     */
    @Overwrite
    private void generateSurface(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context, int radius) {
        int height = 2;
        double circularArea = this.getCircularArea(radius, height);
        BlockPos.betweenClosedStream(context.origin().offset(-radius, height, -radius), context.origin().offset(radius, 0, radius)).map(BlockPos::immutable).forEach((position) -> {
            int heightDifference = position.getY() - context.origin().getY();
            if (position.distSqr(context.origin()) <= circularArea && heightDifference < 2 + context.random().nextInt(height) && !context.level().isEmptyBlock(position.below())) {
                if (context.level().isEmptyBlock(position.above())) {
                    context.level().setBlock(position, TFCRock.defaultBlockState(), 2);
                } else {
                    context.level().setBlock(position, TFCCobble.defaultBlockState(), 2);
                }
            }

        });
    }
}