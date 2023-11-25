package com.allthemods.gravitas2.recipe.capability;

import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.content.SerializerInteger;

public class TemperatureRecipeCapability extends RecipeCapability<Integer> {
    public static final TemperatureRecipeCapability CAP = new TemperatureRecipeCapability();


    protected TemperatureRecipeCapability() {
        super("temp", 0xFF0033AA, SerializerInteger.INSTANCE);
    }

    @Override
    public Integer copyInner(Integer content) {
        return content;
    }

    public Integer copyWithModifier(Integer content, ContentModifier modifier){
        return modifier.apply(content).intValue();
    }
}
