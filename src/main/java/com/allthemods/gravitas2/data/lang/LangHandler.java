package com.allthemods.gravitas2.data.lang;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {

    public static void init(RegistrateLangProvider provider) {

        // GUI text
        provider.add("gregitas_core.multiblock.blast_furnace.temperature", "Current Temperature: %sK");

    }
}
