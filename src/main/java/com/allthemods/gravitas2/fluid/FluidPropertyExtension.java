package com.allthemods.gravitas2.fluid;

import net.dries007.tfc.common.fluids.FluidProperty;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.world.level.material.Fluids;

import java.util.stream.Stream;

public interface FluidPropertyExtension {
    FluidProperty LAVA_AND_ALL_WATER = FluidProperty.create("fluid", Stream.of(Fluids.EMPTY, Fluids.WATER, TFCFluids.SALT_WATER, TFCFluids.SPRING_WATER, Fluids.LAVA));
}
