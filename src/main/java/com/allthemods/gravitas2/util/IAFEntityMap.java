package com.allthemods.gravitas2.util;

import com.github.alexthe666.iceandfire.entity.IafEntityRegistry;
import net.minecraft.world.entity.EntityType;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class IAFEntityMap {

    public static final Map<EntityType<?>, Predicate<float[]>> spawnList = new ConcurrentHashMap<>();
    public static final Map<EntityType<?>, Predicate<float[]>> dragonList = new ConcurrentHashMap<>();

    public static void init() {
        spawnList.put(IafEntityRegistry.HIPPOGRYPH.get(), tempAndRainfall -> tempAndRainfall[0] >= 18 && tempAndRainfall[1] >= 300); // TROPICAL_RAINFOREST+
        spawnList.put(IafEntityRegistry.CYCLOPS.get(), tempAndRainfall -> tempAndRainfall[0] >= 12 && tempAndRainfall[1] >= 350); // HUMID SUBTROPICAL+
        spawnList.put(IafEntityRegistry.AMPHITHERE.get(), tempAndRainfall -> tempAndRainfall[0] >= 4 && tempAndRainfall[1] < 150); // HOT DESERT+
        spawnList.put(IafEntityRegistry.SEA_SERPENT.get(), tempAndRainfall -> tempAndRainfall[0] >= 0 && tempAndRainfall[1] >= 200); // just about anywhere

        dragonList.put(IafEntityRegistry.ICE_DRAGON.get(),tempAndRainfall -> tempAndRainfall[0] <= 4 && tempAndRainfall[1] < 400);
        dragonList.put(IafEntityRegistry.FIRE_DRAGON.get(),tempAndRainfall -> tempAndRainfall[0] >= 15 && tempAndRainfall[1] > 300);
        dragonList.put(IafEntityRegistry.LIGHTNING_DRAGON.get(),tempAndRainfall -> tempAndRainfall[0] >= 15 && tempAndRainfall[1] < 200);
    }
}
