package com.allthemods.gravitas2;

import com.allthemods.gravitas2.block.CleanerroomFilterType;
import com.allthemods.gravitas2.block.GregitasBlocks;
import com.allthemods.gravitas2.data.recipe.GregitasRecipes;
import com.allthemods.gravitas2.data.tag.GregitasTagPrefixes;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.allthemods.gravitas2.recipe.capability.GregitasRecipeCapabilities;
import com.allthemods.gravitas2.registry.GregitasRegistry;
import com.allthemods.gravitas2.util.OreAddition;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.KJSRecipeKeyEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.integration.kjs.recipe.components.ContentJS;
import com.mojang.datafixers.util.Pair;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@GTAddon
public class GregitasGTAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return GregitasRegistry.GREGITAS_REGISTRATE;
    }

    @Override
    public void initializeAddon() {
        GTCEuAPI.CLEANROOM_FILTERS.put(CleanerroomFilterType.INSTANCE, GregitasBlocks.ULTRA_STERILIZING_FILTER_CASING);
    }

    @Override
    public String addonModId() {
        return GregitasCore.MOD_ID;
    }

    @Override
    public void registerTagPrefixes() {
        GregitasTagPrefixes.init();
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GregitasRecipes.addRecipes(provider);
    }

    public static final ContentJS<Double> PRESSURE_IN = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, false);
    public static final ContentJS<Double> PRESSURE_OUT = new ContentJS<>(NumberComponent.ANY_DOUBLE, GregitasRecipeCapabilities.PRESSURE, true);
    public static final ContentJS<Float> TEMP_IN = new ContentJS<>(NumberComponent.ANY_FLOAT, GregitasRecipeCapabilities.TEMP, false);
    public static final ContentJS<Float> TEMP_OUT = new ContentJS<>(NumberComponent.ANY_FLOAT, GregitasRecipeCapabilities.TEMP, true);

    @Override
    public void registerOreVeins() {
        OreAddition.init();
    }
    @Override
    public void registerRecipeKeys(KJSRecipeKeyEvent event) {
        event.registerKey(GregitasRecipeCapabilities.PRESSURE, Pair.of(PRESSURE_IN, PRESSURE_OUT));
        event.registerKey(GregitasRecipeCapabilities.TEMP, Pair.of(TEMP_IN, TEMP_OUT));
    }
}
