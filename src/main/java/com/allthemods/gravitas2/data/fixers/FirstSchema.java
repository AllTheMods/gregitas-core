package com.allthemods.gravitas2.data.fixers;

import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.templates.TypeTemplate;
import org.jetbrains.annotations.Range;

import java.util.Map;
import java.util.function.Supplier;

public class FirstSchema extends Schema {
    /**
     * Creates a schema.
     * @param versionKey the data version key
     */
    public FirstSchema(@Range(from = 0, to = Integer.MAX_VALUE) int versionKey) {
        super(versionKey, null);
    }

    // all of these methods refer to this.parent without checking if its null
    @Override
    public void registerTypes(Schema schema, Map<String, Supplier<TypeTemplate>> entityTypes,
                              Map<String, Supplier<TypeTemplate>> blockEntityTypes) {}

    @Override
    public Map<String, Supplier<TypeTemplate>> registerEntities(Schema schema) {
        return Map.of();
    }

    @Override
    public Map<String, Supplier<TypeTemplate>> registerBlockEntities(Schema schema) {
        return Map.of();
    }
}