package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.util.IAFEntityMap;
import com.github.alexthe666.iceandfire.IafConfig;
import com.github.alexthe666.iceandfire.entity.EntityDragonBase;
import com.github.alexthe666.iceandfire.util.WorldUtil;
import com.github.alexthe666.iceandfire.world.gen.*;
import com.mojang.serialization.Codec;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.world.chunkdata.ChunkData;
import net.dries007.tfc.world.chunkdata.ChunkDataProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;


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
    public boolean place(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context) {
        EntityType<? extends EntityDragonBase> DRAGONTYPE = this.getDragonType();
        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();
        ChunkDataProvider provider = ChunkDataProvider.get(worldIn);
        ChunkData data = provider.get(worldIn, pos);
        float rainfall = data.getRainfall(pos);
        float avgAnnualTemperature = data.getAverageTemp(pos);
        var climateTest = IAFEntityMap.dragonList.get(DRAGONTYPE);
        var tempAndRainfall = new float[]{avgAnnualTemperature, rainfall};
        if (!climateTest.test(tempAndRainfall)) {
            GregitasCore.LOGGER.info("Blocked :" + DRAGONTYPE.getDescription() + " at: " + pos);
            return false;
        }
        if (!WorldUtil.canGenerate(IafConfig.generateDragonRoostChance, context.level(), context.random(), context.origin(), this.getId(), true)) {
            return false;
        } else {
            boolean isMale = (new Random()).nextBoolean();
            int radius = 12 + context.random().nextInt(8);
            this.spawnDragon(context, radius, isMale);
            this.generateSurface(context, radius);
            this.generateShell(context, radius);
            radius -= 2;
            this.hollowOut(context, radius);
            radius += 15;
            this.generateDecoration(context, radius, isMale);
            return true;
        }
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
    @Shadow
    protected abstract void generateDecoration(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context, int radius, boolean isMale);
    @Shadow protected abstract void spawnDragon(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context, int ageOffset, boolean isMale);
    @Shadow protected abstract void hollowOut(@NotNull FeaturePlaceContext<NoneFeatureConfiguration> context, int radius);
    @Shadow protected abstract EntityType<? extends EntityDragonBase> getDragonType();
}