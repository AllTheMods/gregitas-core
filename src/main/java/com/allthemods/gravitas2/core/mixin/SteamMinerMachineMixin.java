package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.common.machine.steam.SteamMinerMachine;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SteamMinerMachine.class)
public class SteamMinerMachineMixin {
    @Inject(
            method = "createSteamTank",
            remap = false,
            at = @At("RETURN"),
            cancellable = true)
    private void gregitas$fixSteamTank(Object[] args, CallbackInfoReturnable<NotifiableFluidTank> cir){
        cir.setReturnValue(new NotifiableFluidTank((SteamMinerMachine) ((Object) this), 1, 16 * FluidHelper.getBucket(), IO.BOTH));
    }
}

