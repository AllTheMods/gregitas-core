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

public class IAFEntityMap {

    public static final Map<EntityType<?>, KoppenClimateClassification> spawnList = new ConcurrentHashMap<>();

    public static void init() {
        spawnList.put(IafEntityRegistry.HIPPOGRYPH.get(), KoppenClimateClassification.TROPICAL_RAINFOREST);
        spawnList.put(IafEntityRegistry.CYCLOPS.get(), KoppenClimateClassification.HUMID_SUBTROPICAL);
        spawnList.put(IafEntityRegistry.AMPHITHERE.get(), KoppenClimateClassification.HOT_DESERT);

    }
}
