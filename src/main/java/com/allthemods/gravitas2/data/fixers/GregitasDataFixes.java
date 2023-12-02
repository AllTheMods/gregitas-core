package com.allthemods.gravitas2.data.fixers;

import com.allthemods.gravitas2.GregitasCore;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.mojang.datafixers.DataFixerBuilder;
import com.mojang.datafixers.schemas.Schema;
import net.minecraft.SharedConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.fixes.BlockRenameFix;
import net.minecraft.util.datafix.schemas.NamespacedSchema;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

import static com.allthemods.gravitas2.data.fixers.DataFixesInternals.BASE_SCHEMA;

public class GregitasDataFixes {

    private static final BiFunction<Integer, Schema, Schema> SAME = Schema::new;
    private static final BiFunction<Integer, Schema, Schema> SAME_NAMESPACED = NamespacedSchema::new;

    public static void register() {
        GregitasCore.LOGGER.info("registering DataFixers");
        DataFixesInternals api = DataFixesInternals.get();

        DataFixerBuilder builder = new DataFixerBuilder(GregitasCore.DATA_FIXER_VERSION);
        addFixers(builder);

        ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("GregitasCore Datafixer Bootstrap").setDaemon(true).setPriority(1).build());
        api.registerFixer(GregitasCore.DATA_FIXER_VERSION, builder.buildOptimized(SharedConstants.DATA_FIX_TYPES_TO_OPTIMIZE, executor));
    }

    private static void addFixers(DataFixerBuilder builder) {
        builder.addSchema(0, BASE_SCHEMA);

        // Register a schema, and then the fixes to get *to* that schema

        // For v1, need to upgrade gregitas:ore/<material>/<stone> and gtceu:tfc_<stone>_<material>_ore to gtceu:<stone>_<material>_ore
        Schema schemaV1 = builder.addSchema(1, SAME_NAMESPACED);
        builder.addFixer(BlockRenameFix.create(schemaV1, "update_gregitas_ore_blocks", blockId -> {
            ResourceLocation id = ResourceLocation.tryParse(blockId);
            if (id == null) return blockId;
            if (id.getNamespace().equals("gregitas")) {
                String[] path = id.getPath().split("/");
                if (path.length >= 2) {
                    return "gtceu:%s_%s_ore".formatted(path[1], path[0]);
                }
            } else if (id.getNamespace().equals("gtceu") && id.getPath().startsWith("tfc_")) {
                return "gtceu:" + id.getPath().substring(4);
            }
            return blockId;
        }));
    }
}
