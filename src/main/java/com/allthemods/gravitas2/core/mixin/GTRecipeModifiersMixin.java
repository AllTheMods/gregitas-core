package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import javax.annotation.Nonnull;

@Mixin(value = GTRecipeModifiers.class, remap = false)
public abstract class GTRecipeModifiersMixin {

    @ModifyVariable(method = "ebfOverclock", at = @At(value = "STORE"), ordinal = 0)
    private static int gregitas$modifyEbfHeatValue(int originalCoilTemp, MetaMachine machine, @Nonnull GTRecipe recipe) {
        if (machine instanceof IHeatBlock heatBlock) {
            return Math.round(heatBlock.getTemperature() + 273);
        }
        return originalCoilTemp;
    }
}
