package com.allthemods.gravitas2.util;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.MissingMappingsEvent;

public class GregitasUtil {

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
        } else if (id.getNamespace().equals("gtceu") && id.getPath().startsWith("tfc_")) {
            ResourceLocation newId = GTCEu.id(id.getPath().substring(4));
            if (registry.containsKey(newId)) {
                return registry.getValue(newId);
            }
        }
        return null;
    }
}
