package com.allthemods.gravitas2.registry;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.enchants.RefreshingEnchant;
import com.allthemods.gravitas2.enchants.WarmingEnchant;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerTieredMachines;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class GregitasRegistry {
    public static GTRegistrate GREGITAS_REGISTRATE = GTRegistrate.create(GregitasCore.MOD_ID);

    public static final FoodTrait FreezeDried = FoodTrait.register(new ResourceLocation(GregitasCore.MOD_ID,"freeze_dried"),new FoodTrait(0.02F,"gregitas_core.freeze_dried"));

    public static final FoodTrait IceChilled = FoodTrait.register(new ResourceLocation(GregitasCore.MOD_ID,"ice_chilled"),new FoodTrait(2.0F,"gregitas_core.ice_chilled"));
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, GregitasCore.MOD_ID);
    public static final DeferredRegister<MobEffect> MOBEFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, GregitasCore.MOD_ID);

    public static final RegistryObject<MobEffect> REFRESHING = MOBEFFECTS.register("refreshing", () -> new RefreshingEnchant(MobEffectCategory.BENEFICIAL,0x98D8D8){} );
    public static final RegistryObject<MobEffect> WARMING = MOBEFFECTS.register("warming", () -> new WarmingEnchant(MobEffectCategory.BENEFICIAL,0xFF5733){} );

    public static final RegistryObject<Potion> REFRESHING_POTION = POTIONS.register("refreshing", () -> new Potion(new MobEffectInstance(REFRESHING.get(), 600)));

    public static final RegistryObject<Potion> WARMING_POTION = POTIONS.register("warming", () -> new Potion(new MobEffectInstance(WARMING.get(), 600)));



}
