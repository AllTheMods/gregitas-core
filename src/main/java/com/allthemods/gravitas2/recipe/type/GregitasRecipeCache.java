package com.allthemods.gravitas2.recipe.type;

import dev.latvian.mods.kubejs.core.NoMixinException;

import java.util.concurrent.atomic.AtomicInteger;

public interface GregitasRecipeCache {
    default AtomicInteger gregitas$getTicksSinceLastRecipe() {
        throw new NoMixinException();
    }
}
