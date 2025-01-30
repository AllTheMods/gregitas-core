package com.allthemods.gravitas2.core.mixin;


import net.minecraft.world.item.crafting.Ingredient;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

import immersive_machinery.Common;
import net.dries007.tfc.common.blocks.Gem;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(value = Common.class, remap = false)
public class MixinIM_Shards {
            @ModifyArg(method = "lambda$static$0", at = @At(value = "INVOKE", target = "Limmersive_aircraft/entity/inventory/slots/IngredientSlotDescription;<init>(Ljava/lang/String;IIILcom/google/gson/JsonObject;Lnet/minecraft/world/item/crafting/Ingredient;I)V"), index = 5)
            private static Ingredient modifyIngredient(Ingredient ingredient){
                return Ingredient.of(TFCItems.GEMS.get(Gem.AMETHYST).get());
            }

}
