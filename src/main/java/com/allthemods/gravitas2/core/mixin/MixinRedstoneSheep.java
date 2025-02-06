package com.allthemods.gravitas2.core.mixin;

import net.dries007.tfc.common.blocks.crop.WildCropBlock;
import org.spongepowered.asm.mixin.Mixin;

import immersive_machinery.entity.RedstoneSheep;
import net.dries007.tfc.common.blocks.plant.ShortGrassBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RedstoneSheep.class, remap = false)
public class MixinRedstoneSheep {

    @Inject(method = "isCrop", at = @At(value = "HEAD"), cancellable = true)
    private static void isitACrop(Block block, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {

         callbackInfoReturnable.setReturnValue(block instanceof net.dries007.tfc.common.blocks.crop.CropBlock ||
         block instanceof ShortGrassBlock ||
         block instanceof TallGrassBlock ||
         block instanceof WildCropBlock);
      }



}
