package com.allthemods.gravitas2;

import com.allthemods.gravitas2.recipe.capability.GregitasRecipeCapabilities;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.KJSRecipeKeyEvent;
import com.gregtechceu.gtceu.integration.kjs.recipe.components.ContentJS;
import com.mojang.datafixers.util.Pair;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;

@GTAddon
public class GregitasGTAddon implements IGTAddon {
    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return GregitasCore.MOD_ID;
    }


    public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, false);
    public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, true);
    public static final ContentJS<Float> TEMP_IN = new ContentJS<>(NumberComponent.ANY_FLOAT, GregitasRecipeCapabilities.TEMP, false);
    public static final ContentJS<Float> TEMP_OUT = new ContentJS<>(NumberComponent.ANY_FLOAT, GregitasRecipeCapabilities.TEMP, true);

    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {
        event.registerKey(GregitasRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
        event.registerKey(GregitasRecipeCapabilities.TEMP, Pair.of(TEMP_IN, TEMP_OUT));
    }
}
