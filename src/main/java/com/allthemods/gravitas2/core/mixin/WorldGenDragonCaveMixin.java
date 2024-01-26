package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.GregitasCore;
import com.github.alexthe666.iceandfire.IafConfig;
import com.github.alexthe666.iceandfire.entity.*;
import com.github.alexthe666.iceandfire.world.IafWorldRegistry;
import com.github.alexthe666.iceandfire.world.gen.TypedFeature;
import com.github.alexthe666.iceandfire.world.gen.WorldGenDragonCave;
import com.github.alexthe666.iceandfire.world.gen.WorldGenFireDragonCave;
import com.mojang.serialization.Codec;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.util.climate.Climate;
import net.dries007.tfc.util.climate.KoppenClimateClassification;
import net.minecraft.core.BlockPos;
import net.minecraft.server.TickTask;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.fml.LogicalSide;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(value = WorldGenDragonCave.class,remap = false)
public abstract class WorldGenDragonCaveMixin extends Feature<NoneFeatureConfiguration> implements TypedFeature {


    public BlockState PALETTE_BLOCK1;
    @Shadow
    public boolean isMale;

    private boolean lightning, fire, ice = false;
    private EntityType<EntityFireDragon> FIREDRAGON = IafEntityRegistry.FIRE_DRAGON.get();
    private EntityType<EntityIceDragon> ICEDRAGON = IafEntityRegistry.ICE_DRAGON.get();
    private EntityType<EntityLightningDragon> LIGHTNINGDRAGON = IafEntityRegistry.LIGHTNING_DRAGON.get();
    public WorldGenDragonCaveMixin(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }




    /**
     * @author thevortex
     * @reason
     */
   /* @Overwrite
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        EntityType<? extends EntityDragonBase> DRAGONTYPE = this.getDragonType();
        WorldGenLevel worldIn = context.level();
        RandomSource rand = context.random();
        BlockPos position = context.origin();
        float avgTemp = Climate.getAverageTemperature(worldIn.getLevel(), position);
        float rainfall = Climate.getRainfall(worldIn.getLevel(), position);
        var executor = LogicalSidedProvider.WORKQUEUE.get(LogicalSide.SERVER);
        executor.executeIfPossible(new TickTask(0, () -> {


        if ((DRAGONTYPE == FIREDRAGON) && (KoppenClimateClassification.classify(avgTemp, rainfall) != KoppenClimateClassification.TROPICAL_RAINFOREST)) {
            return;
        }
        if ((DRAGONTYPE == ICEDRAGON) && (KoppenClimateClassification.classify(avgTemp, rainfall) != KoppenClimateClassification.ARCTIC)) {
            return;
        }
        if ((DRAGONTYPE == LIGHTNINGDRAGON) && (KoppenClimateClassification.classify(avgTemp, rainfall) != KoppenClimateClassification.HOT_DESERT)) {
            return;
        }

            if (rand.nextInt(IafConfig.generateDragonDenChance) == 0 && IafWorldRegistry.isFarEnoughFromSpawn(worldIn, context.origin()) && IafWorldRegistry.isFarEnoughFromDangerousGen(worldIn, position, this.getId(), this.getFeatureType())) {
                this.isMale = rand.nextBoolean();
                ChunkPos chunkPos = worldIn.getChunk(context.origin()).getPos();
                int j = 40;

                int dragonAge;
                int radius;
                for (dragonAge = 0; dragonAge < 20; ++dragonAge) {
                    for (radius = 0; radius < 20; ++radius) {
                        j = Math.min(j, worldIn.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, context.origin().getX() + dragonAge, context.origin().getZ() + radius));
                    }
                }

                j -= 20;
                j -= rand.nextInt(30);

                BlockPos pos = new BlockPos((chunkPos.x << 4) + 8, j, (chunkPos.z << 4) + 8);
                dragonAge = 75 + rand.nextInt(50);
                radius = (int) ((float) dragonAge * 0.2F) + rand.nextInt(4);
                this.generateCave(worldIn, radius, 3, pos, rand);
                EntityDragonBase dragon = this.createDragon(worldIn, rand, pos, dragonAge);
                worldIn.addFreshEntity(dragon);
                GregitasCore.LOGGER.info("DRAGON CAVE GENERATED" + context.origin() + " " + DRAGONTYPE.toString());
            }
        }));
        return true;
    }
    /**
     * @author thevortex
     * @reason
     */
    @Overwrite
    public void createShell(LevelAccessor worldIn, RandomSource rand, Set<BlockPos> positions) {
       EntityType<? extends EntityDragonBase> dragon = getDragonType();


       if(dragon == FIREDRAGON) { PALETTE_BLOCK1 = TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.HARDENED).get().defaultBlockState(); }
       if(dragon == ICEDRAGON) { PALETTE_BLOCK1 = TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.HARDENED).get().defaultBlockState(); }
       if(dragon == LIGHTNINGDRAGON) { PALETTE_BLOCK1 = TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).get(Rock.BlockType.HARDENED).get().defaultBlockState(); }


        positions.forEach(blockPos -> {
           if (!(worldIn.getBlockState(blockPos).getBlock() instanceof BaseEntityBlock) && worldIn.getBlockState(blockPos).getDestroySpeed(worldIn, blockPos) >= 0) {
               worldIn.setBlock(blockPos, PALETTE_BLOCK1 , Block.UPDATE_CLIENTS);
           }
        });
    }
    @Shadow public abstract EntityType<? extends EntityDragonBase> getDragonType();


    @Shadow
    protected abstract EntityDragonBase createDragon(WorldGenLevel worldGen, RandomSource random, BlockPos position, int dragonAge);

    @Shadow
    public abstract void generateCave(LevelAccessor worldIn, int radius, int amount, BlockPos center, RandomSource rand);
}

