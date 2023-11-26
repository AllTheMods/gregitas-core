package com.allthemods.gravitas2.block.entity;

import com.allthemods.gravitas2.block.GregitasBlocks;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

import static com.allthemods.gravitas2.registry.GregitasRegistry.GREGITAS_REGISTRATE;

public class GregitasBlockEntities {

    public static final BlockEntityEntry<PressurePipeBlockEntity> PRESSURE_PIPE = GREGITAS_REGISTRATE
            .blockEntity("pressure_pipe", PressurePipeBlockEntity::new)
            .validBlocks(GregitasBlocks.PRESSURE_PIPE_BLOCKS)
            .register();

    public static void init() {

    }
}
