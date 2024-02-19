package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.registry.TFCTrackCompat;
import com.railwayteam.railways.Railways;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Railways.class, remap = false)
public class RailwaysMixin {

    @Shadow @Final public static Logger LOGGER;

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lorg/spongepowered/asm/mixin/MixinEnvironment;audit()V"))
    private static void gregitas$noAudit(MixinEnvironment instance) {
        LOGGER.info("Skipping Railways Mixin Audit...");
    }
}
