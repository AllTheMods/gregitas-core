package com.allthemods.gravitas2.util;

import com.github.alexthe666.iceandfire.entity.IafEntityRegistry;
import com.ibm.icu.impl.CollectionSet;
import net.dries007.tfc.util.climate.KoppenClimateClassification;
import net.minecraft.world.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.channels.AsynchronousByteChannel;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class IAFEntityMap {

    public static final Map<EntityType<?>, Predicate<float[]>> spawnList = new ConcurrentHashMap<>();

    public static void init() {
        spawnList.put(IafEntityRegistry.HIPPOGRYPH.get(), tempAndRainfall -> tempAndRainfall[0] >= 18 && tempAndRainfall[1] >= 300); // TROPICAL_RAINFOREST+
        spawnList.put(IafEntityRegistry.CYCLOPS.get(), tempAndRainfall -> tempAndRainfall[0] >= 12 && tempAndRainfall[1] >= 350); // HUMID SUBTROPICAL+
        spawnList.put(IafEntityRegistry.AMPHITHERE.get(), tempAndRainfall -> tempAndRainfall[0] >= 4 && tempAndRainfall[1] < 150); // HOT DESERT+
    }
}
