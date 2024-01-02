package com.allthemods.gravitas2.data.recipe;

import com.allthemods.gravitas2.data.recipe.builder.CollapseRecipeBuilder;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MACERATOR_RECIPES;

public class GregitasRecipes {

    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        for (Material material : GTRegistries.MATERIALS) {
            if (!material.hasProperty(PropertyKey.ORE)) continue;

            for (TagPrefix prefix : TagPrefix.ORES.keySet()) {
                BlockEntry<? extends MaterialBlock> block = GTBlocks.MATERIAL_BLOCKS.get(prefix, material);
                if (block != null && block.isPresent()) {
                    new CollapseRecipeBuilder().ingredient(block.get()).result(block.get()).save(provider);
                }
            }
        }

        // overrides
        MACERATOR_RECIPES.recipeBuilder("macerate_diorite")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Diorite)).toArray(ItemLike[]::new)))
                .outputItems(dust, Diorite)
                .chancedOutput(dustSmall, Stone, 100, 40)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_granite")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Granite)).toArray(ItemLike[]::new)))
                .outputItems(dust, Granite)
                .chancedOutput(dustSmall, Stone, 100, 40)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_basalt")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Basalt)).toArray(ItemLike[]::new)))
                .outputItems(dust, Basalt)
                .chancedOutput(dust, Basalt, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_slate")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Slate)).toArray(ItemLike[]::new)))
                .outputItems(dust, Slate)
                .chancedOutput(dust, Thorium, 100, 40)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_marble")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Marble)).toArray(ItemLike[]::new)))
                .outputItems(dust, Marble)
                .chancedOutput(dust, Marble, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_gabbro")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Gabbro)).toArray(ItemLike[]::new)))
                .outputItems(dust, Marble)
                .chancedOutput(dust, Marble, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_shale")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Shale)).toArray(ItemLike[]::new)))
                .outputItems(dust, Shale)
                .chancedOutput(dust, Shale, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_claystone")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Claystone)).toArray(ItemLike[]::new)))
                .outputItems(dust, Claystone)
                .chancedOutput(dust, Claystone, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_limestone")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Limestone)).toArray(ItemLike[]::new)))
                .outputItems(dust, Limestone)
                .chancedOutput(dust, Limestone, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_conglomerate")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Conglomerate)).toArray(ItemLike[]::new)))
                .outputItems(dust, Conglomerate)
                .chancedOutput(dust, Conglomerate, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_dolomite")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Dolomite)).toArray(ItemLike[]::new)))
                .outputItems(dust, Dolomite)
                .chancedOutput(dust, Dolomite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_chert")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Chert)).toArray(ItemLike[]::new)))
                .outputItems(dust, Chert)
                .chancedOutput(dust, Chert, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_chalk")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Chalk)).toArray(ItemLike[]::new)))
                .outputItems(dust, Chalk)
                .chancedOutput(dust, Chalk, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_rhyolite")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Rhyolite)).toArray(ItemLike[]::new)))
                .outputItems(dust, Rhyolite)
                .chancedOutput(dust, Rhyolite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_dacite")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Dacite)).toArray(ItemLike[]::new)))
                .outputItems(dust, Dacite)
                .chancedOutput(dust, Dacite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_phyllite")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Phyllite)).toArray(ItemLike[]::new)))
                .outputItems(dust, Phyllite)
                .chancedOutput(dust, Phyllite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_schist")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Schist)).toArray(ItemLike[]::new)))
                .outputItems(dust, Schist)
                .chancedOutput(dust, Schist, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_gneiss")
                .inputItems(Ingredient.of(ChemicalHelper.getItems(new UnificationEntry(rock, Gneiss)).toArray(ItemLike[]::new)))
                .outputItems(dust, Gneiss)
                .chancedOutput(dust, Gneiss, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);
    }
}
