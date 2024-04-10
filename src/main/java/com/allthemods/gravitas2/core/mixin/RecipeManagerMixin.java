package com.allthemods.gravitas2.core.mixin;

import com.google.gson.JsonElement;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Mixin(value = RecipeManager.class, priority = 1001)
public abstract class RecipeManagerMixin {

    @Shadow private Map<RecipeType<?>, Map<ResourceLocation, Recipe<?>>> recipes;

    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At(value = "TAIL"), cancellable = true)
    private void gregitas$temporaryFixRecipes(Map<ResourceLocation, JsonElement> object, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci) {
        for (RecipeType<?> recipeType : BuiltInRegistries.RECIPE_TYPE) {
            if (recipeType instanceof GTRecipeType gtRecipeType) {
                gtRecipeType.getLookup().removeAllRecipes();

                var proxyRecipes = gtRecipeType.getProxyRecipes();
                for (Map.Entry<RecipeType<?>, List<GTRecipe>> entry : proxyRecipes.entrySet()) {
                    var type = entry.getKey();
                    var recipes = entry.getValue();
                    recipes.clear();
                    if (this.recipes.containsKey(type)) {
                        for (var recipe : this.recipes.get(type).entrySet()) {
                            recipes.add(gtRecipeType.toGTrecipe(recipe.getKey(), recipe.getValue()));
                        }
                    }
                }

                if (this.recipes.containsKey(gtRecipeType)) {
                    Stream.concat(
                                    this.recipes.get(gtRecipeType).values().stream(),
                                    proxyRecipes.entrySet().stream()
                                            .flatMap(entry -> entry.getValue().stream()))
                            .filter(GTRecipe.class::isInstance)
                            .map(GTRecipe.class::cast)
                            .forEach(gtRecipe -> gtRecipeType.getLookup().addRecipe(gtRecipe));
                } else if (!proxyRecipes.isEmpty()) {
                    proxyRecipes.values().stream()
                            .flatMap(List::stream)
                            .forEach(gtRecipe -> gtRecipeType.getLookup().addRecipe(gtRecipe));
                }
            }
        }
        ci.cancel();
    }
}
