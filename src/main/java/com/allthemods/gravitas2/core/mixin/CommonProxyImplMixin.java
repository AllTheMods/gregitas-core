package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.GregitasCore;
import com.gregtechceu.gtceu.common.CommonProxy;
import com.gregtechceu.gtceu.common.forge.CommonProxyImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = CommonProxyImpl.class, remap = false)
public class CommonProxyImplMixin {

    // godawful fix this is. hope it works!
    @Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/common/CommonProxy;init()V"))
    private void gregitas$delayLoad() {
        synchronized (GregitasCore.LOCK) {
            if (!GregitasCore.isTfcSetup) {
                try { GregitasCore.LOCK.wait(); } catch (InterruptedException ignored) {}
            }
        }
        CommonProxy.init();
    }
}
