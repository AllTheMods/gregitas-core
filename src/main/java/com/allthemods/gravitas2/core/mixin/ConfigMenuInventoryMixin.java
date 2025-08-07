package com.allthemods.gravitas2.core.mixin;

import appeng.api.stacks.GenericStack;
import appeng.util.ConfigMenuInventory;
import com.allthemods.gravitas2.compat.G2PropertyKey;
import com.allthemods.gravitas2.compat.TFCProperty;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ConfigMenuInventory.class, remap = false)
public abstract class ConfigMenuInventoryMixin {


    private static void applyItemCapabilities(ItemStack stack){
        MaterialStack materialStack = ChemicalHelper.getMaterial(stack);
        if(materialStack == null){
            return;
        }
        Material material = materialStack.material();
        if(material == null){
            return;
        }
        if(material.hasProperty(G2PropertyKey.TFC_PROPERTY)){
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(handler -> {
            });
        }
    }

    @Inject(
            method = "convertToSuitableStack",
            at = @At(
                    value = "INVOKE",
                    target = "Lappeng/api/stacks/GenericStack;unwrapItemStack(Lnet/minecraft/world/item/ItemStack;)Lappeng/api/stacks/GenericStack;",
                    ordinal = 0
            ),
            cancellable = false

    )
    private void injectEncode(ItemStack stack, CallbackInfoReturnable<GenericStack> cil) {
        applyItemCapabilities(stack);
    }

    @Inject(
            method = "convertToSuitableStack",
            at = @At(
                    value = "INVOKE",
                    target= "Lappeng/api/stacks/AEItemKey;of(Lnet/minecraft/world/item/ItemStack;)Lappeng/api/stacks/AEItemKey;",
                    ordinal = 0
            ),
            cancellable = false
    )

    private void injectEncodeOf(ItemStack stack , CallbackInfoReturnable<GenericStack> cil){
        applyItemCapabilities(stack);
    }

}
