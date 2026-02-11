package com.allthemods.gravitas2.core.mixin;

import net.minecraft.world.level.block.PointedDripstoneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PointedDripstoneBlock.class)
public class MixinDripstone {
    @Inject(method = "maybeTransferFluid", at = @At("HEAD"), cancellable = true)
    private static void gregitas$cancelFluidTransfer(CallbackInfo ci) {
        ci.cancel();
    }
}
