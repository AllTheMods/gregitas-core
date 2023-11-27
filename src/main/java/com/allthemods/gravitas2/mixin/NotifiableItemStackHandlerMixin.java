package com.allthemods.gravitas2.mixin;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.trait.ICapabilityTrait;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableRecipeHandlerTrait;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.side.item.IItemTransfer;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = NotifiableItemStackHandler.class, remap = false)
public abstract class NotifiableItemStackHandlerMixin extends NotifiableRecipeHandlerTrait<Ingredient> implements ICapabilityTrait, IItemTransfer {

    public NotifiableItemStackHandlerMixin(MetaMachine machine) {
        super(machine);
    }

    @Unique
    private static final ThreadLocal<GTRecipe> gregitas$recipeLocal = ThreadLocal.withInitial(() -> null);

    @Inject(method = "handleRecipeInner", at = @At("HEAD"))
    private void gregitas$saveRecipeToLocal(IO io, GTRecipe recipe, List<Ingredient> left, @Nullable String slotName, boolean simulate, CallbackInfoReturnable<List<Ingredient>> cir) {
        gregitas$recipeLocal.set(recipe);
    }

    @Inject(method = "handleRecipeInner", at = @At("TAIL"))
    private void gregitas$removeRecipeLocal(IO io, GTRecipe recipe, List<Ingredient> left, @Nullable String slotName, boolean simulate, CallbackInfoReturnable<List<Ingredient>> cir) {
        gregitas$recipeLocal.remove();
    }

    @ModifyArg(method = "handleIngredient", at = @At(value = "INVOKE", target = "Lcom/lowdragmc/lowdraglib/misc/ItemStackTransfer;insertItem(ILnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/item/ItemStack;"), index = 1)
    private static ItemStack gregitas$heatHeatableOutput(ItemStack stack) {
        if (HeatCapability.has(stack)) {
            IHeat heatItem = HeatCapability.get(stack);
            GTRecipe recipe = gregitas$recipeLocal.get();
            if (recipe != null && recipe.data.contains("ebf_temp")) {
                heatItem.setTemperature(recipe.data.getInt("ebf_temp") + 273.15f);
            }
        }
        return stack;
    }
}
