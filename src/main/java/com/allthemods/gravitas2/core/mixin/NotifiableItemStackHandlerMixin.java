package com.allthemods.gravitas2.core.mixin;


import com.allthemods.gravitas2.compat.G2PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.transfer.item.CustomItemStackHandler;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NotifiableItemStackHandler.class, remap = false)
public abstract class NotifiableItemStackHandlerMixin {
    //adapted from TFG Coremod
    //https://github.com/TerraFirmaGreg-Team/Core-Modern/blob/dev/src/main/java/su/terrafirmagreg/core/mixins/common/gtceu/NotifiableItemStackHandlerMixin.java
    @Redirect(
            method = "handleRecipe",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/gregtechceu/gtceu/api/transfer/item/CustomItemStackHandler;insertItem(ILnet/minecraft/world/item/ItemStack;Z)Lnet/minecraft/world/item/ItemStack;",
                    ordinal = 0
            )
    )
    private static ItemStack injectHandleIngredient(CustomItemStackHandler capability, int slot, ItemStack stack, boolean simulated) {
        if(!simulated){
            MaterialStack materialStack = ChemicalHelper.getMaterialStack(stack);
            if(materialStack != null){
                Material material = materialStack.material();
                if(material != null && material.hasProperty(G2PropertyKey.TFC_PROPERTY)){
                    stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(handler -> {
                    });
                }
            }
        }
        ItemStack returnStack = capability.insertItem(slot, stack, simulated);
        return returnStack;
    }
}



