package com.allthemods.gravitas2.mixin;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.data.recipe.generated.MaterialRecipeHandler;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeat;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Consumer;

@Mixin(value = MaterialRecipeHandler.class, remap = false)
public class MaterialRecipeHandlerMixin {

    @ModifyArg(
            method = "processDust",
            index = 2,
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/data/recipe/generated/MaterialRecipeHandler;processEBFRecipe(Lcom/gregtechceu/gtceu/api/data/chemical/material/Material;Lcom/gregtechceu/gtceu/api/data/chemical/material/properties/BlastProperty;Lnet/minecraft/world/item/ItemStack;Ljava/util/function/Consumer;)V"
            )
    )
    private static ItemStack modifyEbfOutput(Material material, BlastProperty property, ItemStack output, Consumer<FinishedRecipe> provider) {
        ItemStack newOutput = ChemicalHelper.get(TagPrefix.ingot, material);
        if (newOutput.getCapability(HeatCapability.CAPABILITY).isPresent()) {
            IHeat heat = newOutput.getCapability(HeatCapability.CAPABILITY).orElse(null);
            heat.setTemperature(property.getBlastTemperature());
            return newOutput;
        }
        return output;
    }
}
