package com.allthemods.gravitas2.core.mixin;

import com.github.alexthe666.iceandfire.block.BlockElementalFlower;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = BlockElementalFlower.class)
public class MixinLilyFix {

    @Inject(method = "mayPlaceOn", at= @At("HEAD"), cancellable = true)
    protected void itsGood(BlockState state, BlockGetter worldIn, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        Block block = state.getBlock();
        cir.setReturnValue(block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND || state.is(BlockTags.SAND) || state.is(TFCTags.Blocks.BUSH_PLANTABLE_ON));
    }
}
