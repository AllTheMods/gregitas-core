package com.allthemods.gravitas2.data.fixers;

import com.allthemods.gravitas2.GregitasCore;
import com.google.common.base.Preconditions;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.SharedConstants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.util.datafix.DataFixers;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.function.BiFunction;

public abstract class DataFixesInternals {
    public static final BiFunction<Integer, Schema, Schema> BASE_SCHEMA = (version, parent) -> {
        Preconditions.checkArgument(version == 0, "version must be 0");
        Preconditions.checkArgument(parent == null, "parent must be null");
        return get().createBaseSchema();
    };

    public record DataFixerEntry(DataFixer dataFixer, int currentVersion) {}

    @Contract(pure = true)
    @Range(from = 0, to = Integer.MAX_VALUE)
    public static int getModDataVersion(@NotNull CompoundTag compound) {
        return compound.getInt("Gregitas_DataVersion");
    }

    private static DataFixesInternals instance;

    public static @NotNull DataFixesInternals get() {
        if (instance == null) {
            Schema latestVanillaSchema;
            try {
                latestVanillaSchema = DataFixers.getDataFixer()
                        .getSchema(DataFixUtils.makeKey(SharedConstants.getCurrentVersion().getDataVersion().getVersion()));
            } catch (Exception e) {
                latestVanillaSchema = null;
            }

            if (latestVanillaSchema == null) {
                GregitasCore.LOGGER.warn("[GregitasCore DFU] Failed to initialize! Either someone stopped DFU from initializing,");
                GregitasCore.LOGGER.warn("[GregitasCore DFU]  or this Minecraft build is hosed.");
                GregitasCore.LOGGER.warn("[GregitasCore DFU] Using no-op implementation.");
                instance = new NoOpDataFixesInternals();
            } else {
                instance = new DataFixesInternalsImpl(latestVanillaSchema);
            }
        }

        return instance;
    }

    public abstract void registerFixer(@Range(from = 0, to = Integer.MAX_VALUE) int currentVersion,
                                       @NotNull DataFixer dataFixer);

    public abstract @Nullable DataFixerEntry getFixerEntry();

    @Contract(value = "-> new", pure = true)
    public abstract @NotNull Schema createBaseSchema();

    public abstract @NotNull CompoundTag updateWithAllFixers(@NotNull DataFixTypes dataFixTypes, @NotNull CompoundTag compound);

    public abstract @NotNull CompoundTag addModDataVersions(@NotNull CompoundTag compound);

}
