package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.registry.TFCTrackCompat;
import com.railwayteam.railways.ModSetup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModSetup.class, remap = false)
public class RailwaysModSetupMixin {

    @Inject(method = "register()V", at = @At("TAIL"))
    private static void gregitas$registerTFC(CallbackInfo ci) {
        TFCTrackCompat.register();
    }
}
