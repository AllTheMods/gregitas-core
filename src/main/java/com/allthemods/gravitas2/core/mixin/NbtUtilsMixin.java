package com.allthemods.gravitas2.core.mixin;

import com.allthemods.gravitas2.data.fixers.DataFixesInternals;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(NbtUtils.class)
public class NbtUtilsMixin {
    @Inject(method = "addDataVersion", at = @At("HEAD"))
    private static void gregitas$addModDataVersion(CompoundTag tag, int dataVersion, CallbackInfoReturnable<CompoundTag> cir) {
        DataFixesInternals.get().addModDataVersions(tag);
    }
}
