package com.allthemods.gravitas2.data.recipe;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.data.recipe.builder.CollapseRecipeBuilder;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.IntersectionIngredient;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.MACERATOR_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ROCK_BREAKER_RECIPES;

public class GregitasRecipes {

    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GTMaterials.Granite, TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GTMaterials.Diorite, TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Gabbro, TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Shale, TFCBlocks.ROCK_BLOCKS.get(Rock.SHALE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Claystone, TFCBlocks.ROCK_BLOCKS.get(Rock.CLAYSTONE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Limestone, TFCBlocks.ROCK_BLOCKS.get(Rock.LIMESTONE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Conglomerate, TFCBlocks.ROCK_BLOCKS.get(Rock.CONGLOMERATE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Dolomite, TFCBlocks.ROCK_BLOCKS.get(Rock.DOLOMITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Chert, TFCBlocks.ROCK_BLOCKS.get(Rock.CHERT).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Chalk, TFCBlocks.ROCK_BLOCKS.get(Rock.CHALK).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Rhyolite, TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GTMaterials.Basalt, TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GTMaterials.Andesite, TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Dacite, TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GTMaterials.Quartzite, TFCBlocks.ROCK_BLOCKS.get(Rock.QUARTZITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Slate, TFCBlocks.ROCK_BLOCKS.get(Rock.SLATE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Phyllite, TFCBlocks.ROCK_BLOCKS.get(Rock.PHYLLITE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Schist, TFCBlocks.ROCK_BLOCKS.get(Rock.SCHIST).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GregitasMaterials.Gneiss, TFCBlocks.ROCK_BLOCKS.get(Rock.GNEISS).values().stream().map(Supplier::get).toArray(ItemLike[]::new));
        ChemicalHelper.registerUnificationItems(TagPrefix.rock, GTMaterials.Marble, TFCBlocks.ROCK_BLOCKS.get(Rock.MARBLE).values().stream().map(Supplier::get).toArray(ItemLike[]::new));

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
        ROCK_BREAKER_RECIPES.recipeBuilder("andesite")
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(60)
                .addData("fluidA", "minecraft:lava")
                .addData("fluidB", "minecraft:water")
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("granite")
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(60)
                .addData("fluidA", "minecraft:lava")
                .addData("fluidB", "minecraft:water")
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("diorite")
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(60)
                .addData("fluidA", "minecraft:lava")
                .addData("fluidB", "minecraft:water")
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("tfc_basalt"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .addData("fluidA", "minecraft:lava")
                .addData("fluidB", "minecraft:water")
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_diorite")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Diorite)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Diorite)
                .chancedOutput(dustSmall, Stone, 100, 40)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_granite")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Granite)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Granite)
                .chancedOutput(dustSmall, Stone, 100, 40)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_basalt")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Basalt)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Basalt)
                .chancedOutput(dust, Basalt, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_slate")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Slate)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Slate)
                .chancedOutput(dust, Thorium, 100, 40)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_marble")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Marble)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Marble)
                .chancedOutput(dust, Marble, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_gabbro")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Gabbro)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Marble)
                .chancedOutput(dust, Marble, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_shale")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Shale)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Shale)
                .chancedOutput(dust, Shale, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_claystone")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Claystone)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Claystone)
                .chancedOutput(dust, Claystone, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_limestone")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Limestone)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Limestone)
                .chancedOutput(dust, Limestone, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_conglomerate")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Conglomerate)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Conglomerate)
                .chancedOutput(dust, Conglomerate, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_dolomite")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Dolomite)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Dolomite)
                .chancedOutput(dust, Dolomite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_chert")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Chert)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Chert)
                .chancedOutput(dust, Chert, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_chalk")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Chalk)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Chalk)
                .chancedOutput(dust, Chalk, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_rhyolite")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Rhyolite)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Rhyolite)
                .chancedOutput(dust, Rhyolite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_dacite")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Dacite)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Dacite)
                .chancedOutput(dust, Dacite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_phyllite")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Phyllite)), Ingredient.of(Tags.Items.STONE)))
                .outputItems(dust, Phyllite)
                .chancedOutput(dust, Phyllite, 1000, 380)
                .duration(150).EUt(2)
                .save(provider);

        MACERATOR_RECIPES.recipeBuilder("macerate_schist")
                .inputItems(IntersectionIngredient.of(Ingredient.of(ChemicalHelper.getTag(rock, Schist)), Ingredient.of(Tags.Items.STONE)))
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
