package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.At;

import com.allthemods.gravitas2.GregitasCore;

import immersive_aircraft.entity.inventory.VehicleInventoryDescription;
import immersive_aircraft.entity.inventory.slots.IngredientSlotDescription;
import immersive_machinery.Common;
import net.dries007.tfc.common.blocks.Gem;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;

@Mixin(value = Common.class, remap = false)
public class MixinIM_Shards {
   private static final Item SWAP = TFCItems.GEMS.get(Gem.AMETHYST).get();

    

      @ModifyArg(
      method = "registerSlotType",
      at = @At(
          value = "INVOKE",
          target = "Lnet/minecraft/world/item/crafting/Ingredient;of([Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/item/crafting/Ingredient;"
      ),
      index = 0
  )
  private static ItemLike[] modifyIngredient(ItemLike[] original) {
    
      return new ItemLike[]{SWAP}; 
}
}
