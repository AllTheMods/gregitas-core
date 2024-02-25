package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.recipe.type.GregitasRecipeCache;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.atomic.AtomicInteger;

@Mixin(value = RecipeLogic.class, remap = false)
public abstract class RecipeLogicMixin implements GregitasRecipeCache {

    @Unique
    private final AtomicInteger gregitas$ticksSinceLastRecipe = new AtomicInteger(20);

    @Override
    public AtomicInteger gregitas$getTicksSinceLastRecipe(){
        return gregitas$ticksSinceLastRecipe;
    }

    @Inject(method = "checkMatchedRecipeAvailable", at = @At(value = "HEAD"))
    private void gregitas$heatEBFWhileRecipeActive(GTRecipe match, CallbackInfoReturnable<Boolean> cir){
        if (match != null) gregitas$ticksSinceLastRecipe.set(0);
    }
}
