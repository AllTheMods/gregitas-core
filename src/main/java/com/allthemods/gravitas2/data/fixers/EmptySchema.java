package com.allthemods.gravitas2.data.fixers;

import com.mojang.datafixers.DSL;
import com.mojang.datafixers.schemas.Schema;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.templates.TypeTemplate;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import org.jetbrains.annotations.Range;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Represents an empty {@link Schema}, having no parent and containing no type definitions.
 */
public final class EmptySchema extends FirstSchema {
    /**
     * Constructs an empty schema.
     *
     * @param versionKey the data version key
     */
    public EmptySchema(@Range(from = 0, to = Integer.MAX_VALUE) int versionKey) {
        super(versionKey);
    }

    // Ensure the schema stays empty.
    @Override
    public void registerType(boolean recursive, DSL.TypeReference type, Supplier<TypeTemplate> template) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Map<String, Type<?>> buildTypes() {
        return Object2ObjectMaps.emptyMap();
    }
}