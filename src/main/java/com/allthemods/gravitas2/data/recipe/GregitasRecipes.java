package com.allthemods.gravitas2.data.recipe;

import com.allthemods.gravitas2.data.recipe.builder.CollapseRecipeBuilder;
import com.gregtechceu.gtceu.api.block.MaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class GregitasRecipes {

    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        for (TagPrefix prefix : TagPrefix.ORES.keySet()) {
            for (Material material : GTRegistries.MATERIALS) {
                if (!material.hasProperty(PropertyKey.ORE)) continue;

                BlockEntry<? extends MaterialBlock> block = GTBlocks.MATERIAL_BLOCKS.get(prefix, material);
                if (block != null && block.isPresent()) {
                    new CollapseRecipeBuilder().ingredient(block.get()).result(block.get()).save(provider);
                }
            }
        }
    }
}
