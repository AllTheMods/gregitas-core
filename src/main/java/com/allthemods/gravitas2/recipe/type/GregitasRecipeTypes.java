package com.allthemods.gravitas2.recipe.type;

import com.allthemods.gravitas2.GregitasCore;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;

public class GregitasRecipeTypes {

    public static final String GREGITAS = "gregitas";

//    public static GTRecipeType BURNER_REACTOR_RECIPES = register("burner_reactor", GREGITAS)
//            .setMaxIOSize(0, 3, 0, 2)
//            .setEUIO(IO.IN)
//            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, LEFT_TO_RIGHT)
//            .setSound(GTSoundEntries.ARC);


    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        var recipeType = new GTRecipeType(GregitasCore.id(name), group, proxyRecipes);
        ForgeRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        ForgeRegistries.RECIPE_SERIALIZERS.register(recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }

    public static void init() {

    }
}
