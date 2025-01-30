package com.allthemods.gravitas2.core.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import immersive_machinery.Common;
import net.dries007.tfc.common.blocks.Gem;
import net.dries007.tfc.common.items.TFCItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

@Mixin(value = Common.class, remap = false)
public class MixinIM_Shards {
   private static final Item SWAP = TFCItems.GEMS.get(Gem.AMETHYST).get();


   @ModifyArg(method = "lambda$static$0", at = @At(value = "INVOKE", target = "net/minecraft/world/item/crafting/Ingredient.of"))
    private static ItemLike[] registerShards(ItemLike[] items) {
        return new ItemLike[]{SWAP};
    }
}
