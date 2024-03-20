package com.allthemods.gravitas2.data.recipe;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.data.recipe.builder.CollapseRecipeBuilder;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
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

        

        // misc
        VanillaRecipeHelper.addShapelessRecipe(provider, "wrought_iron_magnetic_stick", ChemicalHelper.get(rod, WroughtIronMagnetic), new UnificationEntry(rod, WroughtIron), new UnificationEntry(dust, Redstone), new UnificationEntry(dust, Redstone), new UnificationEntry(dust, Redstone), new UnificationEntry(dust, Redstone));
    }
}
