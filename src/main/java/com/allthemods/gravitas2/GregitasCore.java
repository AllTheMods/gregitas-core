package com.allthemods.gravitas2;

import com.allthemods.gravitas2.block.GregitasBlocks;
import com.allthemods.gravitas2.block.entity.GregitasBlockEntities;
import com.allthemods.gravitas2.capability.GregitasCapabilities;
import com.allthemods.gravitas2.data.lang.LangHandler;
import com.allthemods.gravitas2.machine.GregitasMachines;
import com.allthemods.gravitas2.material.GregitasElements;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.allthemods.gravitas2.recipe.capability.GregitasRecipeCapabilities;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.registry.GregitasRegistry;
import com.allthemods.gravitas2.util.GregitasUtil;
import com.allthemods.gravitas2.util.IAFEntityMap;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lumintorious.tfcambiental.api.AmbientalRegistry;
import com.lumintorious.tfcambiental.modifier.TempModifier;
import com.tterrag.registrate.providers.ProviderType;
import dev.ftb.mods.ftbchunks.api.FTBChunksAPI;
import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import net.dries007.tfc.world.TFCChunkGenerator;
import net.dries007.tfc.world.chunkdata.ChunkDataGenerator;
import net.dries007.tfc.world.chunkdata.LerpFloatLayer;
import net.dries007.tfc.world.region.Region;
import net.dries007.tfc.world.region.RegionGenerator;
import net.dries007.tfc.world.region.Units;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityEvent.EnteringSection;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.MissingMappingsEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Optional;

@Mod(GregitasCore.MOD_ID)
public class GregitasCore {
    public static final String MOD_ID = "gregitas_core";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final CleanroomType CLEANER_ROOM = new CleanroomType("cleanerroom", "gregitas_core.recipe.cleanerroom.display_name");

    public GregitasCore() {
        ConfigHolder.init();

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::addMaterialRegistries);
        modBus.addListener(this::addMaterials);
        modBus.addListener(this::modifyMaterials);
        modBus.addGenericListener(RecipeCapability.class, this::registerRecipeCaps);
        modBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        modBus.addGenericListener(Element.class, this::registerElements);

        modBus.addListener(this::registerCapabilities);

        MinecraftForge.EVENT_BUS.register(this);

        // Initialize GT stuffs
        GregitasBlocks.init();
        GregitasBlockEntities.init();

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

        AmbientalRegistry.BLOCK_ENTITIES.register((player, blockEntity) -> {
            if (blockEntity instanceof IMachineBlockEntity machineBlockEntity && machineBlockEntity.getMetaMachine() instanceof IRecipeLogicMachine rlMachine) {
                if (rlMachine.isActive()) {
                    return TempModifier.defined("machine", rlMachine.getChanceTier() * 6.0F, 0.0F);
                }
            }
            return TempModifier.none();
        });
    }

    // Register mod-bus events in init (like on line 49, with IEventBus#addListener)
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        GregitasCapabilities.register(event);
    }

    // try to repair old ore block IDs
    @SubscribeEvent
    public void missingMappings(MissingMappingsEvent event) {
        event.getMappings(ForgeRegistries.Keys.BLOCKS, GTCEu.MOD_ID).forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.BLOCKS, "gregitas").forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.ITEMS, GTCEu.MOD_ID).forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.ITEMS, "gregitas").forEach(GregitasUtil::remap);
    }

    @SubscribeEvent
    public void detectEnteringClaimedChunks(EnteringSection event) {
        if (!(event.getEntity() instanceof ServerPlayer player)) return;
        if (!event.didChunkChange()) return;
        if (!FTBChunksAPI.api().isManagerLoaded()) return;
        var chunkManager = FTBChunksAPI.api().getManager();
        var oldChunkDimPos = new ChunkDimPos(player.level().dimension(), event.getOldPos().chunk());
        var newChunkDimPos = new ChunkDimPos(player.level().dimension(), event.getNewPos().chunk());
        var oldChunkManager = chunkManager.getChunk(oldChunkDimPos);
        var newChunkManager = chunkManager.getChunk(newChunkDimPos);
        var oldTeam = oldChunkManager != null ? oldChunkManager.getTeamData().getTeam() : null;
        var newTeam = newChunkManager != null ? newChunkManager.getTeamData().getTeam() : null;

        if (newTeam != null && (!newTeam.equals(oldTeam))) {
            if (newTeam.getRankForPlayer(player.getUUID()).isAllyOrBetter()) {
                player.displayClientMessage(Component.translatable("gregitas_core.message.enter_ally_area").append(newTeam.getColoredName()).withStyle(ChatFormatting.GREEN), true);
            } else {
                player.displayClientMessage(Component.translatable("gregitas_core.message.enter_area").append(newTeam.getColoredName()).withStyle(ChatFormatting.RED), true);
                player.playNotifySound(SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.AMBIENT, 0.2f, 1);
            }
        } else if (newTeam == null && oldTeam != null) {
            player.displayClientMessage(Component.translatable("gregitas_core.message.leave_area").append(oldTeam.getColoredName()).withStyle(ChatFormatting.GREEN), true);
        }
    }

    public void addMaterialRegistries(MaterialRegistryEvent event) {
        GTCEuAPI.materialManager.createRegistry(GregitasCore.MOD_ID);
    }

    public void addMaterials(MaterialEvent event) {
        GregitasMaterials.init();
    }

    public void modifyMaterials(PostMaterialEvent event) {
        GregitasMaterials.modify();
    }

    public void registerRecipeCaps(GTCEuAPI.RegisterEvent<String, RecipeCapability<?>> event) {
        GregitasRecipeCapabilities.init();
    }

    public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        GregitasRecipeTypes.init();
    }

    public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        GregitasMachines.init();
    }

    public void registerElements(GTCEuAPI.RegisterEvent<String, Element> event) {
        GregitasElements.init();
    }


    @SubscribeEvent
    public void initSpawnData(ServerStartingEvent event){
        IAFEntityMap.init();
    }
    @SubscribeEvent
    public void spawnCheck(MobSpawnEvent.FinalizeSpawn event) {
        if (!IAFEntityMap.spawnList.containsKey(event.getEntity().getType())) return;
        LOGGER.info("Entering ENTITY CHECK *************************************************");
        var start = Util.getNanos();
        if (event.getLevel().getChunkSource() instanceof ServerChunkCache scc){
            if (scc.getGenerator() instanceof TFCChunkGenerator chunkGenerator){
                var regionGenerator = new RegionGenerator(chunkGenerator.settings(), new XoroshiroRandomSource(event.getLevel().getLevel().getSeed()));
                BlockPos pos = new BlockPos((int) event.getX(), (int) event.getY(), (int) event.getZ());
                var tempAndRainfall = getTempAndRainfall(regionGenerator, pos);
                LOGGER.info("Got climate values *************************************************");
                EntityType<?> entityType = event.getEntity().getType();
                var climateTest = IAFEntityMap.spawnList.get(entityType);
                if (!climateTest.test(tempAndRainfall)) {
                    event.setSpawnCancelled(true);
                    event.setCanceled(true);
                    LOGGER.info(" Entity " + entityType.getDescriptionId() + " blocked! " + Arrays.toString(tempAndRainfall));
                    LOGGER.info("This process took " + Math.floor((double) (Util.getNanos() - start) /1000) + " µs.");
                } else {
                    LOGGER.info("Entity " + entityType.getDescriptionId() + " allowed! " + Arrays.toString(tempAndRainfall));
                    LOGGER.info("This process took " + Math.floor((double) (Util.getNanos() - start) /1000) + " µs.");
                    MutableComponent component = ComponentUtils.wrapInSquareBrackets(Component.translatable("chat.coordinates", pos.getX(), pos.getY(), pos.getZ())).withStyle(text -> text.withColor(ChatFormatting.GREEN).withClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + pos.getX() + " " + pos.getY() + " " + pos.getZ())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Component.translatable("chat.coordinates.tooltip"))));
                    event.getLevel().getLevel().players().forEach(player -> player.sendSystemMessage(Component.translatable("Located entity %s at coordinate %s", event.getEntity().getDisplayName(), component)));
                }
            }
        }
    }

    private float[] getTempAndRainfall(RegionGenerator regionGenerator, BlockPos pos){
        final ChunkPos chunkPos = new ChunkPos(pos);
        final int blockX = chunkPos.getMinBlockX(), blockZ = chunkPos.getMinBlockZ();

        final int gridX = Units.blockToGrid(blockX);
        final int gridZ = Units.blockToGrid(blockZ);

        final Region.Point point00 = regionGenerator.getOrCreateRegionPoint(gridX, gridZ);
        final Region.Point point01 = regionGenerator.getOrCreateRegionPoint(gridX, gridZ + 1);
        final Region.Point point10 = regionGenerator.getOrCreateRegionPoint(gridX + 1, gridZ);
        final Region.Point point11 = regionGenerator.getOrCreateRegionPoint(gridX + 1, gridZ + 1);

        final double deltaX = Units.blockToGridExact(blockX) - gridX;
        final double deltaZ = Units.blockToGridExact(blockZ) - gridZ;

        final LerpFloatLayer rainfallLayer = ChunkDataGenerator.sampleInterpolatedGridLayer(point00.rainfall, point01.rainfall, point10.rainfall, point11.rainfall, deltaX, deltaZ);
        final LerpFloatLayer temperatureLayer = ChunkDataGenerator.sampleInterpolatedGridLayer(point00.temperature, point01.temperature, point10.temperature, point11.temperature, deltaX, deltaZ);
        final float temp = temperatureLayer.getValue((pos.getZ() & 15) / 16f, (pos.getX() & 15) / 16f);
        final float rainfall = rainfallLayer.getValue((pos.getX() & 15) / 16f, (pos.getZ() & 15) / 16f);
        return new float[]{temp, rainfall};
    }
}


