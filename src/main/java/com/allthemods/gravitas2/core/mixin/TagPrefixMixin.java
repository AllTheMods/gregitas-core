package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.UnificationEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.annotation.Nullable;

@Mixin(value = TagPrefix.class, remap = false)
public abstract class TagPrefixMixin {

    @Shadow private long materialAmount;

    @Inject(method = "getMaterialAmount", at = @At("TAIL"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void gregitas$fixMaterialAmounts(@Nullable Material material, CallbackInfoReturnable<Long> cir, UnificationEntry key) {
        if (cir.getReturnValue() == materialAmount) {
            cir.setReturnValue(GregitasMaterials.MATERIAL_AMOUNT_MAP.getOrDefault(key, materialAmount));
        }
    }
}
