package com.allthemods.gravitas2.block;

import com.allthemods.gravitas2.GregitasCore;
import com.gregtechceu.gtceu.api.block.IFilterType;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import org.jetbrains.annotations.NotNull;

public class CleanerroomFilterType implements IFilterType {
    public static CleanerroomFilterType INSTANCE = new CleanerroomFilterType();

    @NotNull
    @Override
    public CleanroomType getCleanroomType() {
        return GregitasCore.CLEANER_ROOM;
    }

    @Override
    public String getSerializedName() {
        return "ultra_sterilizing_filter_casing";
    }
}
