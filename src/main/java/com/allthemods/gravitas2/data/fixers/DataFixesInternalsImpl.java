package com.allthemods.gravitas2.data.fixers;

import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.serialization.Dynamic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.datafix.DataFixTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

public final class DataFixesInternalsImpl extends DataFixesInternals {
    private final @NotNull Schema latestVanillaSchema;

    private DataFixerEntry dataFixer;

    public DataFixesInternalsImpl(@NotNull Schema latestVanillaSchema) {
        this.latestVanillaSchema = latestVanillaSchema;

        this.dataFixer = null;
    }

    @Override
    public void registerFixer(@Range(from = 0, to = Integer.MAX_VALUE) int currentVersion,
                              @NotNull DataFixer dataFixer) {
        if (this.dataFixer != null) {
            throw new IllegalArgumentException("GregitasCore already has a registered data fixer");
        }

        this.dataFixer = new DataFixerEntry(dataFixer, currentVersion);
    }

    @Override
    public @Nullable DataFixerEntry getFixerEntry() {
        return dataFixer;
    }

    @Override
    public @NotNull Schema createBaseSchema() {
        return new Schema(0, this.latestVanillaSchema);
    }

    @Override
    public @NotNull CompoundTag updateWithAllFixers(@NotNull DataFixTypes dataFixTypes, @NotNull CompoundTag compound) {
        var current = new Dynamic<>(NbtOps.INSTANCE, compound);

        if (dataFixer != null) {
            int modDataVersion = DataFixesInternals.getModDataVersion(compound);
            current = dataFixTypes.update(dataFixer.dataFixer(), current, modDataVersion, dataFixer.currentVersion());
        }

        return (CompoundTag) current.getValue();
    }

    @Override
    public @NotNull CompoundTag addModDataVersions(@NotNull CompoundTag compound) {
        if (dataFixer != null)
            compound.putInt("Gregitas_DataVersion", dataFixer.currentVersion());

        return compound;
    }
}