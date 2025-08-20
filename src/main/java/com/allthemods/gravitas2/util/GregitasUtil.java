package com.allthemods.gravitas2.util;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.MissingMappingsEvent;

public class GregitasUtil {

    public static TagKey<Block> MINEABLE_WITH_WRENCH = TagKey.create(Registries.BLOCK, new ResourceLocation("forge", "mineable/wrench"));

    public static <T> void remap(MissingMappingsEvent.Mapping<T> mapping) {
        ResourceLocation key = mapping.getKey();
        T newThing = remapId(key, mapping.getRegistry());
        if (newThing != null) {
            mapping.remap(newThing);
        }

    }

    private static <T> T remapId(ResourceLocation id, IForgeRegistry<T> registry) {
        if (id.getNamespace().equals("gregitas")) {
            String[] path = id.getPath().split("/");
            if (path.length == 3) {
                ResourceLocation newId = GTCEu.id("%s_%s_ore".formatted(path[2], path[1]));
                if (registry.containsKey(newId)) {
                    return registry.getValue(newId);
                }
            }
        }
        if (id.getNamespace().equals("vintageimprovements")) {
                ResourceLocation newId = new ResourceLocation("vintage", id.getPath());
                if (registry.containsKey(newId)) {
                    return registry.getValue(newId);
                }
            }
        else if (id.getNamespace().equals("gtceu") && id.getPath().startsWith("tfc_")) {
            ResourceLocation newId = GTCEu.id(id.getPath().substring(4));
            if (registry.containsKey(newId)) {
                return registry.getValue(newId);
            }
        }
        return null;
    }
}
