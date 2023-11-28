package com.allthemods.gravitas2;

import com.allthemods.gravitas2.block.GregitasBlocks;
import com.allthemods.gravitas2.block.entity.GregitasBlockEntities;
import com.allthemods.gravitas2.capability.GregitasCapabilities;
import com.allthemods.gravitas2.data.lang.LangHandler;
import com.allthemods.gravitas2.machine.GregitasMachines;
import com.allthemods.gravitas2.recipe.capability.GregitasRecipeCapabilities;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.registry.GregitasRegistry;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lumintorious.tfcambiental.api.AmbientalRegistry;
import com.lumintorious.tfcambiental.modifier.TempModifier;
import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

@Mod(GregitasCore.MOD_ID)
public class GregitasCore {
    public static final String MOD_ID = "gregitas_core";
    public static final Logger LOGGER = LogManager.getLogger();

    public GregitasCore() {
        ConfigHolder.init();

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::registerCapabilities);

        MinecraftForge.EVENT_BUS.register(this);

        // Initialize GT stuffs
        GregitasRecipeCapabilities.init();
        GregitasBlocks.init();
        GregitasBlockEntities.init();
        GregitasRecipeTypes.init();
        GregitasMachines.init();

        GregitasRegistry.GREGITAS_REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);

        GregitasRegistry.GREGITAS_REGISTRATE.registerRegistrate();

        // Register Integration content
        registerTFCAmbientalBlocks();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static void registerTFCAmbientalBlocks() {
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("cupronickel_coil", 18.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_CUPRONICKEL.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("kanthal_coil", 27.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_KANTHAL.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("nichrome_coil", 36.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_NICHROME.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("tungstensteel_coil", 45.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_TUNGSTENSTEEL.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("hssg_coil", 54.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_HSSG.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("naquadah_coil", 72.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_NAQUADAH.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("trinium_coil", 90.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_TRINIUM.get() && state.getValue(ActiveBlock.ACTIVE)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("tritanium_coil", 108.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_TRITANIUM.get() && state.getValue(ActiveBlock.ACTIVE)));
    }

    // Register mod-bus events in init (like on line 49, with IEventBus#addListener)
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        GregitasCapabilities.register(event);
    }

}
