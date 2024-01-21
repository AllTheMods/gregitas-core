package com.allthemods.gravitas2.core.mixin;

import com.github.alexthe666.iceandfire.entity.*;
import com.github.alexthe666.iceandfire.world.gen.TypedFeature;
import com.github.alexthe666.iceandfire.world.gen.WorldGenDragonCave;
import com.github.alexthe666.iceandfire.world.gen.WorldGenFireDragonCave;
import com.mojang.serialization.Codec;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Set;

@Mixin(value = WorldGenDragonCave.class,remap = false)
public abstract class WorldGenDragonCaveMixin extends Feature<NoneFeatureConfiguration> implements TypedFeature {


    public BlockState PALETTE_BLOCK1;

    private boolean lightning, fire, ice = false;

    public WorldGenDragonCaveMixin(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    /**
     * @author thevortex
     * @reason
     */
    @Overwrite
    public void createShell(LevelAccessor worldIn, RandomSource rand, Set<BlockPos> positions) {
       EntityType<? extends EntityDragonBase> dragon = getDragonType();
       EntityType<EntityFireDragon> FIREDRAGON = IafEntityRegistry.FIRE_DRAGON.get();
       EntityType<EntityIceDragon> ICEDRAGON = IafEntityRegistry.ICE_DRAGON.get();
       EntityType<EntityLightningDragon> LIGHTNINGDRAGON = IafEntityRegistry.LIGHTNING_DRAGON.get();

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


}

