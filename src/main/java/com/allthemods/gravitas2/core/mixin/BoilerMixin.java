package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.simibubi.create.content.fluids.tank.BoilerData;
import com.simibubi.create.foundation.fluid.FluidHelper;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraftforge.fluids.FluidStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = BoilerData.BoilerFluidHandler.class , remap = false)
public class BoilerMixin {
    /**
     * @author thevortex
     * @reason Allow TFC waters and steam in boilers
     */
    @Overwrite
    public boolean isFluidValid(int tank, FluidStack stack) {
        return FluidHelper.isWater(stack.getFluid())
                || (TFCFluids.RIVER_WATER.get() == stack.getFluid())
                || (TFCFluids.SALT_WATER.getSource() == stack.getFluid())
                || stack.getFluid().is(GTMaterials.Steam.getFluidTag());
    }
}
