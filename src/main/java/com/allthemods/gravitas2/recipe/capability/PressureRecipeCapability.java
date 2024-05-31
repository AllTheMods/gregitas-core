package com.allthemods.gravitas2.recipe.capability;

import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.content.SerializerDouble;

public class PressureRecipeCapability extends RecipeCapability<Double> {
    public static final PressureRecipeCapability CAP = new PressureRecipeCapability();


    protected PressureRecipeCapability() {
        super("psi", 0xFFAA33AA, true, 0, SerializerDouble.INSTANCE);
    }

    @Override
    public Double copyInner(Double content) {
        return content;
    }

    public Double copyWithModifier(Double content, ContentModifier modifier){
        return modifier.apply(content).doubleValue();
    }
}
