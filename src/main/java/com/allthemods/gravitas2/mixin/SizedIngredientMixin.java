package com.allthemods.gravitas2.mixin;

import com.gregtechceu.gtceu.api.recipe.ingredient.SizedIngredient;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.stream.Stream;

@Mixin(value = SizedIngredient.class, remap = false)
public abstract class SizedIngredientMixin extends Ingredient {

    protected SizedIngredientMixin(Stream<? extends Value> values) {
        super(values);
    }

    // evil hack to get it to save forge caps.
    @Redirect(method = "<init>(Lnet/minecraft/world/item/ItemStack;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;hasTag()Z"))
    private static boolean gregitas$hasTag(ItemStack instance) {
        return instance.hasTag() || instance.save(new CompoundTag()).contains("ForgeCaps");
    }
}
