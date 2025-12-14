package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.registry.GregitasTags;
import com.github.alexthe666.iceandfire.block.BlockCharedPath;
import com.github.alexthe666.iceandfire.block.BlockFallingReturningState;
import com.github.alexthe666.iceandfire.block.BlockReturningState;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.entity.IafDragonDestructionManager;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IafDragonDestructionManager.class)
public class IaFDragonDestructionMixin {

    @Inject(method = "transformBlockLightning", at = @At("HEAD"), cancellable = true, remap = false)
    private static void gravitas2$modifyLightningTransform(BlockState in, CallbackInfoReturnable<BlockState> cir) {
        if (in.is(GregitasTags.gravels)) {
            cir.setReturnValue((BlockState) ((Block) IafBlockRegistry.CRACKLED_GRAVEL.get()).defaultBlockState());
        } else if (in.is(GregitasTags.rawstone)) {
            cir.setReturnValue((BlockState) ((Block) IafBlockRegistry.CRACKLED_STONE.get()).defaultBlockState());
        } else if (in.is(GregitasTags.dirts)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CRACKLED_DIRT.get().defaultBlockState());
        } else if (in.is(GregitasTags.grasses)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CRACKLED_GRASS.get().defaultBlockState());
        } else if (in.is(GregitasTags.paths)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CRACKLED_DIRT_PATH.get().defaultBlockState());
        } else if (in.is(GregitasTags.cobbles)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CRACKLED_COBBLESTONE.get().defaultBlockState());
        }
        else cir.setReturnValue(Blocks.AIR.defaultBlockState());
        cir.cancel();
    }

    @Inject(method ="transformBlockFire", at = @At("HEAD"), cancellable = true, remap = false)
    private static void gravitas2$modifyFireTransform(BlockState in, CallbackInfoReturnable<BlockState> cir) {
        if (in.is(GregitasTags.gravels)) {
            cir.setReturnValue((BlockState) ((Block) IafBlockRegistry.CHARRED_GRAVEL.get()).defaultBlockState());
        } else if (in.is(GregitasTags.rawstone)) {
            cir.setReturnValue((BlockState) ((Block) IafBlockRegistry.CHARRED_STONE.get()).defaultBlockState());
        } else if (in.is(GregitasTags.dirts)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CHARRED_DIRT.get().defaultBlockState());
        } else if (in.is(GregitasTags.grasses)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CHARRED_GRASS.get().defaultBlockState());
        } else if (in.is(GregitasTags.paths)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CHARRED_DIRT_PATH.get().defaultBlockState());
        } else if (in.is(GregitasTags.cobbles)) {
            cir.setReturnValue((BlockState) IafBlockRegistry.CHARRED_COBBLESTONE.get().defaultBlockState());
        }
        else cir.setReturnValue(Blocks.AIR.defaultBlockState());
        cir.cancel();
    }

    @Inject(method = "transformBlockIce", at = @At("HEAD"), cancellable = true, remap = false)
    private static void gravitas2$modifyIceTransform(BlockState in, CallbackInfoReturnable<BlockState> cir) {
        GregitasCore.LOGGER.info("Transforming block: " + in);
        if (in.is(GregitasTags.gravels)) {
            cir.setReturnValue(IafBlockRegistry.FROZEN_GRAVEL.get().defaultBlockState());
        } else if (in.is(GregitasTags.rawstone)) {
            cir.setReturnValue(IafBlockRegistry.FROZEN_STONE.get().defaultBlockState());
        } else if (in.is(GregitasTags.dirts)) {
            cir.setReturnValue(IafBlockRegistry.FROZEN_DIRT.get().defaultBlockState());
        } else if (in.is(GregitasTags.grasses)) {
            cir.setReturnValue(IafBlockRegistry.FROZEN_GRASS.get().defaultBlockState());
        } else if (in.is(GregitasTags.paths)) {
            cir.setReturnValue(IafBlockRegistry.FROZEN_DIRT_PATH.get().defaultBlockState());
        } else if (in.is(GregitasTags.cobbles)) {
            cir.setReturnValue(IafBlockRegistry.FROZEN_COBBLESTONE.get().defaultBlockState());
        } else if (in.is(Blocks.WATER)) {
            cir.setReturnValue(IafBlockRegistry.DRAGON_ICE.get().defaultBlockState());
        }
        else cir.setReturnValue(Blocks.AIR.defaultBlockState());
        cir.cancel();
    }
}
