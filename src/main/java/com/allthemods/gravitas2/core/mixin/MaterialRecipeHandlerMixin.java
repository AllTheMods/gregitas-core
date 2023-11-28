package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.data.recipe.generated.MaterialRecipeHandler;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeat;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.function.Consumer;

@Mixin(value = MaterialRecipeHandler.class, remap = false)
public class MaterialRecipeHandlerMixin {

    @Contract("_, _, _, _ -> param3")
    @ModifyArg(
            method = "processDust",
            index = 2,
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/data/recipe/generated/MaterialRecipeHandler;processEBFRecipe(Lcom/gregtechceu/gtceu/api/data/chemical/material/Material;Lcom/gregtechceu/gtceu/api/data/chemical/material/properties/BlastProperty;Lnet/minecraft/world/item/ItemStack;Ljava/util/function/Consumer;)V"
            )
    )
    private static @NotNull ItemStack modifyEbfOutput(Material material, BlastProperty property, ItemStack output, Consumer<FinishedRecipe> provider) {
        if (!output.isEmpty() && HeatCapability.has(output)) {
            IHeat heat = HeatCapability.get(output);
            heat.setTemperature(property.getBlastTemperature());
            output.serializeNBT(); // force a data save to save the heat values to stack NBT.
        }
        return output;
    }
}
