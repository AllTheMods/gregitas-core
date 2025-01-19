package com.allthemods.gravitas2.registry;

import com.allthemods.gravitas2.GregitasCore;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;

import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.minecraft.resources.ResourceLocation;

public class GregitasRegistry {
    public static GTRegistrate GREGITAS_REGISTRATE = GTRegistrate.create(GregitasCore.MOD_ID);

    public static final FoodTrait FreezeDried = FoodTrait.register(new ResourceLocation(GregitasCore.MOD_ID,"freeze_dried"),new FoodTrait(0.02F,"gregitas_core.freeze_dried"));
}
