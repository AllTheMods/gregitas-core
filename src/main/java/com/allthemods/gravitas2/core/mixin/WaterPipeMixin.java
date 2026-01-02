package com.allthemods.gravitas2.core.mixin;

import com.simibubi.create.content.fluids.OpenEndedPipe;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = OpenEndedPipe.class, remap = false)
public class WaterPipeMixin {

    @Inject(method = "removeFluidFromSpace", at = @At("RETURN"), cancellable = true, remap = false)
    private void gregitas$removeFluidFromSpace(CallbackInfoReturnable<FluidStack> cir) {
        FluidStack stack = cir.getReturnValue();

        if (stack.getFluid() == TFCFluids.RIVER_WATER.get() || stack.getFluid() == TFCFluids.SALT_WATER.getSource()) {
            cir.setReturnValue(new FluidStack(Fluids.WATER.getSource(), stack.getAmount()));
            cir.cancel();
        }
    }

}
