package com.allthemods.gravitas2;

import argent_matter.gcyr.common.data.GCYRItems;
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
import com.eerussianguy.firmalife.common.blocks.FLBlocks;
import com.eerussianguy.firmalife.common.blocks.OvenBottomBlock;
import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.IOverclockMachine;
import com.gregtechceu.gtceu.api.machine.feature.IRecipeLogicMachine;
import com.gregtechceu.gtceu.api.machine.feature.ITieredMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.CleanroomType;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.lumintorious.tfcambiental.api.AmbientalRegistry;
import com.lumintorious.tfcambiental.modifier.TempModifier;
import com.tterrag.registrate.providers.ProviderType;
import dev.ftb.mods.ftbchunks.api.FTBChunksAPI;
import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import net.dries007.tfc.common.blocks.SeaIceBlock;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.AqueductBlock;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.dries007.tfc.common.entities.TFCEntities;
import net.dries007.tfc.common.entities.predator.Predator;
import net.dries007.tfc.world.chunkdata.ChunkData;
import net.dries007.tfc.world.chunkdata.ChunkDataProvider;


import net.minecraft.sounds.SoundSource;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.IceBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LogicalSidedProvider;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;
import net.minecraftforge.registries.MissingMappingsEvent;
import net.minecraftforge.registries.RegisterEvent;
import top.ribs.scguns.entity.monster.BlundererEntity;
import top.ribs.scguns.entity.monster.CogKnightEntity;
import top.ribs.scguns.entity.monster.CogMinionEntity;
import top.ribs.scguns.entity.monster.DissidentEntity;
import top.ribs.scguns.entity.monster.HiveEntity;
import top.ribs.scguns.entity.monster.RedcoatEntity;
import top.ribs.scguns.entity.monster.SkyCarrierEntity;
import top.ribs.scguns.entity.monster.SupplyScampEntity;
import top.ribs.scguns.entity.monster.SwarmEntity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.function.Predicate;

@Mod(GregitasCore.MOD_ID)
public class GregitasCore {
    public static final String MOD_ID = "gregitas_core";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final CleanroomType CLEANER_ROOM = new CleanroomType("cleanerroom", "gregitas_core.recipe.cleanerroom.display_name");


    public GregitasCore() {
        //ConfigHolder.init();

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::addMaterialRegistries);
        modBus.addListener(this::addMaterials);
        modBus.addListener(this::modifyMaterials);
        modBus.addGenericListener(RecipeCapability.class, this::registerRecipeCaps);
        modBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
        modBus.addGenericListener(MachineDefinition.class, this::registerMachines);
        modBus.addGenericListener(Element.class, this::registerElements);

        modBus.addListener(this::fixDrawers);
        modBus.addListener(this::registerCapabilities);
        GregitasRegistry.MOBEFFECTS.register(modBus);
        GregitasRegistry.POTIONS.register(modBus);

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


        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("aqueduct_lava", 4.0F, 1.0F)).filter((mod) -> state.getBlock() instanceof AqueductBlock && state.getValue(((AqueductBlock) state.getBlock()).getFluidProperty()).getFluid() == Fluids.LAVA));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("aqueduct_water", -3.0F, 1.0F)).filter((mod) -> state.getBlock() instanceof AqueductBlock && state.getValue(((AqueductBlock) state.getBlock()).getFluidProperty()).getFluid() == Fluids.WATER));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("firmalife_oven", 6.0F, 1.0F)).filter((mod) -> state.getBlock() instanceof OvenBottomBlock && state.getValue(OvenBottomBlock.LIT)));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("packed_block", -9.0F, 1.0F)).filter((mod) -> state.getBlock() == Blocks.PACKED_ICE));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("blue_ice", -8.0F, 1.0F)).filter((mod) -> state.getBlock() == Blocks.BLUE_ICE));

        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("ice_block", -6.0F, 1.0F)).filter((mod) -> state.getBlock() instanceof IceBlock));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("cellar_blocks", -1.0F, 1.0F)).filter((mod) -> state.getBlock() == FLBlocks.SEALED_BRICKS.get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("sea_ice", -6.0F, 1.0F)).filter((mod) -> state.getBlock() instanceof SeaIceBlock));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("dragon_ice", -12.0F, 1.0F)).filter((mod) -> state.getBlock() == IafBlockRegistry.DRAGON_ICE.get()));
        
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_basalt", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.BASALT).get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_andesite", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.ANDESITE).get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_diorite", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.DIORITE).get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_dacite", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.DACITE).get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_rhyolite", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.RHYOLITE).get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_gabbro", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.GABBRO).get()));
        AmbientalRegistry.BLOCKS.register((player, blockPos, state) -> Optional.of(new TempModifier("magma_granite", 3.0F, 1.0F)).filter((mod) -> state.getBlock() == TFCBlocks.MAGMA_BLOCKS.get(Rock.GRANITE).get()));

        AmbientalRegistry.BLOCK_ENTITIES.register((player, blockEntity) -> {
            if (blockEntity instanceof IMachineBlockEntity machineBlockEntity && machineBlockEntity.getMetaMachine() instanceof IRecipeLogicMachine rlMachine) {
                
                if (machineBlockEntity.getMetaMachine() instanceof IHeatBlock heatBlock) {
                    return TempModifier.defined("coil_machine", (heatBlock.getTemperature() + 273) / 100, 3.0F);
                }
                if (rlMachine.isActive() && machineBlockEntity.getMetaMachine() instanceof IOverclockMachine overclockMachine){
                    return TempModifier.defined("machine", overclockMachine.getOverclockTier() * 6.0F, 0.0F);
                }
                if (rlMachine.isActive() && machineBlockEntity.getMetaMachine() instanceof ITieredMachine tieredMachine){
                    return TempModifier.defined("machine", tieredMachine.getTier() * 6.0F, 0.0F);
                }
            }
            return TempModifier.none();
        });


        AmbientalRegistry.EQUIPMENT.register((player, stack) -> Optional.of(new TempModifier("nanomuscle_armor", 0f, -10f)).filter((mod) -> {
            var item = stack.getItem();
            return (item == GTItems.NANO_HELMET.asItem()
                    || item == GTItems.NANO_CHESTPLATE.asItem()
                    || item == GTItems.NANO_LEGGINGS.asItem()
                    || item == GTItems.NANO_BOOTS.asItem()
                    || item == GTItems.NANO_CHESTPLATE_ADVANCED.asItem());
        }));

        AmbientalRegistry.EQUIPMENT.register((player, stack) -> Optional.of(new TempModifier("quarktech_armor", 0f, -10f)).filter((mod) -> {
            var item = stack.getItem();
            return (item == GTItems.QUANTUM_HELMET.asItem()
                    || item == GTItems.QUANTUM_CHESTPLATE.asItem()
                    || item == GTItems.QUANTUM_LEGGINGS.asItem()
                    || item == GTItems.QUANTUM_BOOTS.asItem()
                    || item == GTItems.QUANTUM_CHESTPLATE_ADVANCED.asItem());
        }));

        AmbientalRegistry.EQUIPMENT.register((player, stack) -> Optional.of(new TempModifier("space_suit", 0f, -10f)).filter((mod) -> {
            var item = stack.getItem();
            return (item == GCYRItems.SPACE_SUIT_HELMET.asItem() ||
                    item == GCYRItems.SPACE_SUIT_CHEST.asItem() ||
                    item == GCYRItems.SPACE_SUIT_LEGS.asItem() ||
                    item == GCYRItems.SPACE_SUIT_BOOTS.asItem());
        }));
    }

    // Register mod-bus events in init (like on line 49, with IEventBus#addListener)
    public void registerCapabilities(RegisterCapabilitiesEvent event) {
        GregitasCapabilities.register(event);
    }

    // try to repair old ore block IDs
    @SubscribeEvent
    public static void missingMappings(MissingMappingsEvent event) {
        event.getMappings(ForgeRegistries.Keys.BLOCKS, GTCEu.MOD_ID).forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.BLOCKS, "gregitas").forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.BLOCKS, "vintageimprovements").forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.ITEMS, GTCEu.MOD_ID).forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.ITEMS, "gregitas").forEach(GregitasUtil::remap);
        event.getMappings(ForgeRegistries.Keys.ITEMS, "vintageimprovements").forEach(GregitasUtil::remap);
    }

    public void fixDrawers(RegisterEvent event){
        if (event.getRegistryKey().equals(ForgeRegistries.BLOCK_ENTITY_TYPES.getRegistryKey())) {
            if (event.getForgeRegistry() instanceof ForgeRegistry<?> fr){
                LOGGER.info("Fixing Storage Drawers aliases for Gregitas Coremod");
                fr.addAlias(ResourceLocation.parse("everycomp:sd_full_drawers_1"), ResourceLocation.parse("storagedrawers:standard_drawers_1"));
                fr.addAlias(ResourceLocation.parse("everycomp:sd_full_drawers_2"), ResourceLocation.parse("storagedrawers:standard_drawers_2"));
                fr.addAlias(ResourceLocation.parse("everycomp:sd_full_drawers_4"), ResourceLocation.parse("storagedrawers:standard_drawers_4"));
                fr.addAlias(ResourceLocation.parse("everycomp:sd_half_drawers_1"), ResourceLocation.parse("storagedrawers:standard_drawers_1"));
                fr.addAlias(ResourceLocation.parse("everycomp:sd_half_drawers_2"), ResourceLocation.parse("storagedrawers:standard_drawers_2"));
                fr.addAlias(ResourceLocation.parse("everycomp:sd_half_drawers_4"), ResourceLocation.parse("storagedrawers:standard_drawers_4"));
            }
        }
    }

    @SubscribeEvent
    public void detectEnteringClaimedChunks(EntityEvent.EnteringSection event) {
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
    public void initSpawnData(ServerAboutToStartEvent event){
        LOGGER.info("Initializing Spawn Data for Gregitas Coremod");
        IAFEntityMap.init();
    }
    @SubscribeEvent
    public void spawnCheck(MobSpawnEvent.FinalizeSpawn event) {
        if((event.getEntity() instanceof BlundererEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof CogKnightEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof CogMinionEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof DissidentEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof HiveEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof RedcoatEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof SkyCarrierEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof SupplyScampEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }
        if((event.getEntity() instanceof SwarmEntity) && (event.getY() > 50) ) {
            event.getEntity().discard();
            event.setSpawnCancelled(true);
        }

        if(event.getEntity() instanceof Sheep){ event.getEntity().discard(); event.setSpawnCancelled(true); event.setCanceled(true); }
        if(event.getEntity() instanceof Cat){
            var executor = LogicalSidedProvider.WORKQUEUE.get(LogicalSide.SERVER);
            executor.tell(new TickTask(0, () -> {
            catSwap(event);
            }));
        }
        if(event.getEntity() instanceof Drowned) {
            var executor = LogicalSidedProvider.WORKQUEUE.get(LogicalSide.SERVER);
            executor.tell(new TickTask(0, () -> {
            event.getEntity().addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1000000, 0, false, false, true));
        }));
        }
        if (!IAFEntityMap.spawnList.containsKey(event.getEntity().getType())) return;
        if (!(event.getLevel().getLevel().dimension() == Level.OVERWORLD)) return;
        var start = Util.getNanos();
        if (event.getLevel() instanceof WorldGenLevel wgl){
            BlockPos pos = new BlockPos((int) event.getX(), (int) event.getY(), (int) event.getZ());
            ChunkDataProvider provider = ChunkDataProvider.get(wgl);
            ChunkData data = provider.get(wgl, pos);
            float rainfall = data.getRainfall(pos);
            float avgAnnualTemperature = data.getAverageTemp(pos);
            EntityType<?> entityType = event.getEntity().getType();
            Predicate<float[]> climateTest = IAFEntityMap.spawnList.get(entityType);
            if(climateTest == null) { return; }
            float[] tempAndRainfall = new float[]{avgAnnualTemperature, rainfall};
            if (!climateTest.test(tempAndRainfall)) {
                event.setSpawnCancelled(true);
                event.setCanceled(true);

            } else {
            }

        }
    }
    public void catSwap(MobSpawnEvent.FinalizeSpawn event) {
        event.getEntity().discard();
        event.setSpawnCancelled(true);
        TFCEntities.CAT.get().spawn(event.getLevel().getLevel(),new BlockPos((int)event.getX(),(int)event.getY(),(int)event.getZ()), MobSpawnType.NATURAL);
    }
}


