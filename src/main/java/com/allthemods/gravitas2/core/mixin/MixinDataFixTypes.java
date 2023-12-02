package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.data.fixers.DataFixesInternals;
import com.mojang.datafixers.DataFixer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.DataFixTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DataFixTypes.class)
public class MixinDataFixTypes {
    @Inject(
        method = "update(Lcom/mojang/datafixers/DataFixer;Lnet/minecraft/nbt/CompoundTag;II)Lnet/minecraft/nbt/CompoundTag;",
        at = @At("RETURN"),
        cancellable = true
    )
    private void updateDataWithFixers(DataFixer fixer, CompoundTag tag, int version, int newVersion, CallbackInfoReturnable<CompoundTag> cir) {
        cir.setReturnValue(DataFixesInternals.get().updateWithAllFixers((DataFixTypes) (Object) this, cir.getReturnValue()));
    }
}