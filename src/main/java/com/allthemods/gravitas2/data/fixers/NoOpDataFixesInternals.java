package com.allthemods.gravitas2.data.fixers;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.DataFixTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public class NoOpDataFixesInternals extends DataFixesInternals {

    private final Schema schema;

    public NoOpDataFixesInternals() {
        schema = new EmptySchema(0);
    }

    @Override
    public void registerFixer(@Range(from = 0, to = Integer.MAX_VALUE) int currentVersion, @NotNull DataFixer dataFixer) {}

    @Override
    public @Nullable DataFixerEntry getFixerEntry() {
        return null;
    }

    @Override
    public @NotNull Schema createBaseSchema() {
        return schema;
    }

    @Override
    public @NotNull CompoundTag updateWithAllFixers(@NotNull DataFixTypes dataFixTypes, @NotNull CompoundTag compound) {
        return compound.copy();
    }

    @Override
    public @NotNull CompoundTag addModDataVersions(@NotNull CompoundTag compound) {
        return compound;
    }
}