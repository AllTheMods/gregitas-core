package com.allthemods.gravitas2.core.mixin;
import com.allthemods.gravitas2.util.GregitasUtil;
import com.railwayteam.railways.compat.Mods;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Arrays;

@Mixin(Mods.class)
public class RailwaysModEnumMixin
{
    @Shadow(remap = false)
    @Final
    private static Mods[] $VALUES;

    @SuppressWarnings("SameParameterValue")
    @Invoker(value="<init>")
    private static Mods create(String name, int ordinal, String fabricId)
    {
        throw new IllegalStateException("Unreachable");
    }

    static
    {
        var entry = create("TFC", $VALUES.length, "tfc");

        GregitasUtil.RailwaysTFC = entry;

        //noinspection ShadowFinalModification
        $VALUES = Arrays.copyOf($VALUES, $VALUES.length + 1);
        $VALUES[$VALUES.length-1] = entry;
    }
}
