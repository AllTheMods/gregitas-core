package com.allthemods.gravitas2;

import com.allthemods.gravitas2.capability.GregitasCapabilities;
import com.allthemods.gravitas2.capability.IPressureContainer;
import com.allthemods.gravitas2.machine.GregitasMachines;
import com.allthemods.gravitas2.recipe.capability.GregitasRecipeCapabilities;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.registry.GregitasRegistry;
import com.gregtechceu.gtceu.api.blockentity.forge.MetaMachineBlockEntityImpl;
import com.gregtechceu.gtceu.api.capability.IPlatformEnergyStorage;
import com.gregtechceu.gtceu.api.capability.forge.GTCapability;
import com.gregtechceu.gtceu.api.capability.forge.GTEnergyHelperImpl;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.level.ExplosionEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Mod(GregitasCore.MOD_ID)
public class GregitasCore {
    public static final String MOD_ID = "gregitas_core";
    public static final Logger LOGGER = LogManager.getLogger();

    public GregitasCore() {

        // This is our mod's event bus, used for things like registry or lifecycle events
        IEventBus MOD_BUS = FMLJavaModLoadingContext.get().getModEventBus();

        // This listener is fired on both client and server during setup.
        MOD_BUS.addListener(this::commonSetup);
        // This listener is only fired during client setup, so we can use client-side methods here.
        MOD_BUS.addListener(this::clientSetup);

        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
        MinecraftForge.EVENT_BUS.register(this);

        // Initialize GT stuffs
        GregitasRegistry.init();
        GregitasRecipeCapabilities.init();
        GregitasRecipeTypes.init();
        GregitasMachines.init();

        GregitasRegistry.GREGITAS_REGISTRATE.registerRegistrate();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
        LOGGER.info("Look, I found a {}!", Items.DIAMOND);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

    @SubscribeEvent
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        GregitasCapabilities.register(event);
    }

    @SubscribeEvent
    public void addBECapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof MetaMachineBlockEntityImpl mte) {
            MetaMachine machine = mte.getMetaMachine();
            event.addCapability(GregitasCore.id("pressure"), new ICapabilityProvider() {
                @Override
                public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
                    if (capability == GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
                        if (machine instanceof IPressureContainer pressureContainer) {
                            return GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER.orEmpty(capability, LazyOptional.of(() -> pressureContainer));
                        }
                        var list = machine.getTraits().stream().filter(IPressureContainer.class::isInstance).filter(t -> t.hasCapability(side)).map(IPressureContainer.class::cast).toList();
                        if (!list.isEmpty()) {
                            return GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER.orEmpty(capability, LazyOptional.of(() -> list.get(0)));
                        }
                    }
                    return LazyOptional.empty();
                }
            });
        }
    }
}
