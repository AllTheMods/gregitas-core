package com.allthemods.gravitas2.core.mixin;

import java.util.Optional;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraftforge.registries.ForgeRegistries;

@Mixin(AbstractVillager.class)
public class MixinAbstractVillager {

    @SuppressWarnings("null")
    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/trading/MerchantOffers;add(Ljava/lang/Object;)Z"), method = {"addOffersFromItemListings"})
    private boolean replaceEmeraldsWithTokensInTrades(MerchantOffers instance, Object o) {
        MerchantOffer offer = (MerchantOffer) o;
        instance.add(new MerchantOffer(
                offer.getCostA().is(Items.EMERALD) ? new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("workerstfc","coin")), offer.getCostA().getCount() * 10 ) : offer.getCostA(),
                offer.getCostB().is(Items.EMERALD) ? new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("workerstfc","coin")), offer.getCostB().getCount() * 20) : offer.getCostB(),
                offer.getResult().is(Items.EMERALD) ? new ItemStack(ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("workerstfc","coin")), offer.getResult().getCount() * 10) : offer.getResult(),
                offer.getUses(),
                offer.getMaxUses(),
                offer.getXp(),
                offer.getPriceMultiplier(),
                offer.getDemand()
        ));
        return false;
    }


    @Inject(method = "canBeLeashed", at = @At("HEAD"), cancellable = true)
    private void beLeashed(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}
