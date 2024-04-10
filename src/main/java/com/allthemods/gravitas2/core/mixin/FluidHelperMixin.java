package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;
import com.simibubi.create.foundation.fluid.FluidHelper;

import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

@Mixin(FluidHelper.class)
public class FluidHelperMixin {

	@Inject(method="isWater", at=@At("INVOKE"), cancellable=true,remap = false)
	private static void isWaterFix(Fluid fluid, CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue((fluid == Fluids.WATER) || (fluid == TFCFluids.RIVER_WATER.get()));
	}

   

}
