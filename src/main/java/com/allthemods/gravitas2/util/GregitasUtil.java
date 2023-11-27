package com.allthemods.gravitas2.util;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeat;
import net.minecraft.world.item.ItemStack;

public class GregitasUtil {

    public static ItemStack tickItemHeat(ItemStack stack) {
        if (!(stack.getItem() instanceof TagPrefixItem tagPrefixItem)) return stack;

        if (HeatCapability.has(stack)) {
            IHeat heat = HeatCapability.get(stack);
            if (heat.getTemperature() <= 0.0f) {
                return ChemicalHelper.get(TagPrefix.ingot, tagPrefixItem.material, stack.getCount());
            }
        }
        return stack;
    }
}
