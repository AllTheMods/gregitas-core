package com.allthemods.gravitas2;

import com.allthemods.gravitas2.block.GregitasBlocks;
import com.allthemods.gravitas2.block.entity.GregitasBlockEntities;
import com.allthemods.gravitas2.capability.GregitasCapabilities;
import com.allthemods.gravitas2.capability.IPressureContainer;
import com.allthemods.gravitas2.data.lang.LangHandler;
import com.allthemods.gravitas2.machine.GregitasMachines;
import com.allthemods.gravitas2.recipe.capability.GregitasRecipeCapabilities;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.registry.GregitasRegistry;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.blockentity.forge.MetaMachineBlockEntityImpl;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lumintorious.tfcambiental.api.AmbientalRegistry;
import com.lumintorious.tfcambiental.modifier.TempModifier;
import com.tterrag.registrate.providers.ProviderType;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.HeatHandler;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("cupronickel_coil", 3.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_CUPRONICKEL.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("kanthal_coil", 4.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_KANTHAL.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("nichrome_coil", 5.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_NICHROME.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("tungstensteel_coil", 6.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_TUNGSTENSTEEL.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("hssg_coil", 7.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_HSSG.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("naquadah_coil", 8.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_NAQUADAH.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("trinium_coil", 9.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_TRINIUM.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("tritanium_coil", 10.0F, 3.0F)).filter((mod) -> state.getBlock() == GTBlocks.COIL_TRITANIUM.get()));
    }

    @SubscribeEvent
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        GregitasCapabilities.register(event);
    }

    @SubscribeEvent
    public void addBECapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof MetaMachineBlockEntityImpl mte) {
            MetaMachine machine = mte.getMetaMachine();
            event.addCapability(GregitasCore.id("heat"), new ICapabilityProvider() {
                @Override
                public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
                    if (capability == HeatCapability.BLOCK_CAPABILITY) {
                        if (machine instanceof IHeatBlock heatBlock) {
                            return HeatCapability.BLOCK_CAPABILITY.orEmpty(capability, LazyOptional.of(() -> heatBlock));
                        }
                        var list = machine.getTraits().stream().filter(IHeatBlock.class::isInstance).filter(t -> t.hasCapability(side)).map(IHeatBlock.class::cast).toList();
                        if (!list.isEmpty()) {
                            // TODO wrap list?
                            return HeatCapability.BLOCK_CAPABILITY.orEmpty(capability, LazyOptional.of(() -> list.get(0)));
                        }
                    }
                    return LazyOptional.empty();
                }
            });

            event.addCapability(GregitasCore.id("pressure"), new ICapabilityProvider() {
                @Override
                public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction side) {
                    if (capability == GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
                        if (machine instanceof IPressureContainer pressureContainer) {
                            return GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER.orEmpty(capability, LazyOptional.of(() -> pressureContainer));
                        }
                        var list = machine.getTraits().stream().filter(IPressureContainer.class::isInstance).filter(t -> t.hasCapability(side)).map(IPressureContainer.class::cast).toList();
                        if (!list.isEmpty()) {
                            // TODO wrap list?
                            return GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER.orEmpty(capability, LazyOptional.of(() -> list.get(0)));
                        }
                    }
                    return LazyOptional.empty();
                }
            });
        }
    }

    @SubscribeEvent
    public void addItemCapabilities(AttachCapabilitiesEvent<ItemStack> event) {
        if (event.getObject().is(Tags.Items.INGOTS)) {
            MaterialStack materialStack = ChemicalHelper.getMaterial(event.getObject());
            if (materialStack == null) return;

            Material material = materialStack.material();
            BlastProperty prop = material.getProperty(PropertyKey.BLAST);
            if (prop == null) return;

            event.addCapability(GregitasCore.id("ingot"), new HeatHandler((material.getMass() / 512.0f) * ((float) materialStack.amount() / GTValues.M), (prop.getBlastTemperature() - 273.15F) * 0.6F, (prop.getBlastTemperature() - 273.15F) * 0.8F));
        }
    }
}
