package com.allthemods.gravitas2.mixin;

import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(value = PartAbility.class, remap = false) // Remove once GTCEu 1.0.16.a is published.
public interface PartAbilityAccessor {

    @Invoker("<init>")
    static PartAbility invokeInit(String id) {
        throw new AssertionError();
    }
}
