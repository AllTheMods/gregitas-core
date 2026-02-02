package com.allthemods.gravitas2.data.recipe;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.ItemMaterialData;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;
import static com.gregtechceu.gtceu.api.GTValues.HV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ROCK_BREAKER_RECIPES;

public class GregitasRecipes {

    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).values()), TagPrefix.rock, GTMaterials.Granite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).values()), TagPrefix.rock, GTMaterials.Diorite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).values()), TagPrefix.rock, GTMaterials.Basalt);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).values()), TagPrefix.rock, GTMaterials.Andesite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).values()), TagPrefix.rock, GregitasMaterials.Gabbro);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.SHALE).values()), TagPrefix.rock, GregitasMaterials.Shale);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.CLAYSTONE).values()), TagPrefix.rock, GregitasMaterials.Claystone);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.LIMESTONE).values()), TagPrefix.rock, GregitasMaterials.Limestone);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.CONGLOMERATE).values()), TagPrefix.rock, GregitasMaterials.Conglomerate);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.DOLOMITE).values()), TagPrefix.rock, GregitasMaterials.Dolomite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.CHERT).values()), TagPrefix.rock, GregitasMaterials.Chert);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.CHALK).values()), TagPrefix.rock, GregitasMaterials.Chalk);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).values()), TagPrefix.rock, GregitasMaterials.Rhyolite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).values()), TagPrefix.rock, GregitasMaterials.Dacite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.QUARTZITE).values()), TagPrefix.rock, GTMaterials.Quartzite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.SLATE).values()), TagPrefix.rock, GregitasMaterials.Slate);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.PHYLLITE).values()), TagPrefix.rock, GregitasMaterials.Phyllite);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.SCHIST).values()), TagPrefix.rock, GregitasMaterials.Schist);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.GNEISS).values()), TagPrefix.rock, GregitasMaterials.Gneiss);
        ItemMaterialData.registerMaterialEntries(new ArrayList<>(TFCBlocks.ROCK_BLOCKS.get(Rock.MARBLE).values()), TagPrefix.rock, GTMaterials.Marble);


        // overrides
        ROCK_BREAKER_RECIPES.recipeBuilder("andesite")
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(60)
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("granite")
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(60)
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder("diorite")
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(60)
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("tfc_basalt"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("gabbro"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("shale"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.SHALE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.SHALE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("claystone"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.CLAYSTONE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.CLAYSTONE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("limestone"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.LIMESTONE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.LIMESTONE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("conglomerate"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.CONGLOMERATE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.CONGLOMERATE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("dolomite"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.DOLOMITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.DOLOMITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("chert"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.CHERT).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.CHERT).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("chalk"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.CHALK).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.CHALK).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("rhyolite"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("dacite"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("quartzite"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.QUARTZITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.QUARTZITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("slate"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.SLATE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.SLATE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("phyllite"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.PHYLLITE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.PHYLLITE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("schist"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.SCHIST).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.SCHIST).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("gneiss"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.GNEISS).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.GNEISS).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        ROCK_BREAKER_RECIPES.recipeBuilder(GregitasCore.id("marble"))
                .notConsumable(TFCBlocks.ROCK_BLOCKS.get(Rock.MARBLE).get(Rock.BlockType.RAW).get().asItem())
                .outputItems(TFCBlocks.ROCK_BLOCKS.get(Rock.MARBLE).get(Rock.BlockType.RAW).get().asItem())
                .duration(16)
                .EUt(VA[HV])
                .adjacentFluids(Fluids.WATER)
                .adjacentFluids(Fluids.LAVA)
                .save(provider);

        }
}
