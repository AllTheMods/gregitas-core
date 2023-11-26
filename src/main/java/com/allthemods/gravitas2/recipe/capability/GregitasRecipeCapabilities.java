package com.allthemods.gravitas2.recipe.capability;

import com.gregtechceu.gtceu.api.registry.GTRegistries;

public class GregitasRecipeCapabilities {

    public static final TemperatureRecipeCapability TEMP = TemperatureRecipeCapability.CAP;
    public static final PressureRecipeCapability PRESSURE = PressureRecipeCapability.CAP;

    public static void init() {
        GTRegistries.RECIPE_CAPABILITIES.register(TEMP.name, TEMP);
        GTRegistries.RECIPE_CAPABILITIES.register(PRESSURE.name, PRESSURE);
    }
}
