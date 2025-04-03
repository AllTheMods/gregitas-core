package com.allthemods.gravitas2.recipe.capability;

import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.content.SerializerFloat;

public class TemperatureRecipeCapability extends RecipeCapability<Float> {
    public static final TemperatureRecipeCapability CAP = new TemperatureRecipeCapability();

    protected TemperatureRecipeCapability() {
        super("temp", 0xFFEE9933, true,0, SerializerFloat.INSTANCE);
    }

    @Override
    public Float copyInner(Float content) {
        return content;
    }

    public Float copyWithModifier(Float content, ContentModifier modifier){
        return modifier.apply(content);
    }
}
