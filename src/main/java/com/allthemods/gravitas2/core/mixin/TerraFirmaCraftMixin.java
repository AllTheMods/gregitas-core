package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.GregitasCore;
import net.dries007.tfc.TerraFirmaCraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = TerraFirmaCraft.class, remap = false)
public class TerraFirmaCraftMixin {

    @Inject(method = "<init>", at = @At("TAIL"))
    private void gregitas$tfcInit(CallbackInfo ci) {
        GregitasCore.onTfcSetup();
    }
}
