package com.allthemods.gravitas2.registry;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.block.GregitasBlocks;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import static com.allthemods.gravitas2.registry.GregitasRegistry.GREGITAS_REGISTRATE;

public class GregitasCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> GREGITAS_CORE = GREGITAS_REGISTRATE.defaultCreativeTab(GregitasCore.MOD_ID,
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GregitasCore.MOD_ID, GREGITAS_REGISTRATE))
                            .icon(GregitasBlocks.ULTRA_STERILIZING_FILTER_CASING::asStack)
                            .title(GREGITAS_REGISTRATE.addLang("itemGroup", GregitasCore.id("all"), "Gravitas² Core Mod"))
                            .build())
            .register();

    public static void init() {

    }
}