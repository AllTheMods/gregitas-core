package com.allthemods.gravitas2;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;

@GTAddon
public class GregitasGTAddon implements IGTAddon {
    @Override
    public void initializeAddon() {

    }

    @Override
    public String addonModId() {
        return GregitasCore.MOD_ID;
    }
}
