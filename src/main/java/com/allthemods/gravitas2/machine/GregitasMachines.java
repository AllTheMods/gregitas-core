package com.allthemods.gravitas2.machine;

import com.allthemods.gravitas2.machine.multiblock.part.PressureHatchPartMachine;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.mixin.PartAbilityAccessor;
import com.allthemods.gravitas2.util.GregitasConstants;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.*;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.registry.registrate.MachineBuilder;
import com.gregtechceu.gtceu.common.data.GCyMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lowdragmc.lowdraglib.side.fluid.FluidHelper;
import it.unimi.dsi.fastutil.ints.Int2LongFunction;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiFunction;

import static com.allthemods.gravitas2.registry.GregitasRegistry.GREGITAS_REGISTRATE;
import static com.gregtechceu.gtceu.api.GTValues.VLVH;
import static com.gregtechceu.gtceu.api.GTValues.VLVT;
import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.utils.FormattingUtil.toEnglishName;

@SuppressWarnings({"Convert2MethodRef", "FunctionalExpressionCanBeFolded"})
public class GregitasMachines {
    public static final PartAbility PRESSURE_CONTAINER = PartAbilityAccessor.invokeInit("pressure_container");

    public final static int[] ELECTRIC_TIERS = GTCEu.isHighTier() ?
            new int[] {GTValues.LV, GTValues.MV, GTValues.HV, GTValues.EV, GTValues.IV, GTValues.LuV, GTValues.ZPM, GTValues.UV, GTValues.UHV, GTValues.UEV, GTValues.UIV, GTValues.UXV, GTValues.OpV} :
            new int[] {GTValues.LV, GTValues.MV, GTValues.HV, GTValues.EV, GTValues.IV, GTValues.LuV, GTValues.ZPM, GTValues.UV};
    public final static int[] HIGH_TIERS = GTCEu.isHighTier() ?
            new int[] {GTValues.IV, GTValues.LuV, GTValues.ZPM, GTValues.UV, GTValues.UHV, GTValues.UEV, GTValues.UIV, GTValues.UXV, GTValues.OpV} :
            new int[] {GTValues.IV, GTValues.LuV, GTValues.ZPM, GTValues.UV, GTValues.UHV};
    public static final Int2LongFunction defaultTankSizeFunction = tier -> (tier <= GTValues.LV ? 8 : tier == GTValues.MV ? 12 : tier == GTValues.HV ? 16 : tier == GTValues.EV ? 32 : 64) * FluidHelper.getBucket();


    public static final MachineDefinition[] PRESSURE_HATCH = registerPressureTieredMachines("pressure_hatch", (holder, tier) -> {
        double min = GregitasConstants.P[GregitasConstants.EAP];
        double max = GregitasConstants.P[GregitasConstants.EAP];
        if (tier < GregitasConstants.EAP) min = GregitasConstants.P[tier];
        else if (tier > GregitasConstants.EAP) max = GregitasConstants.P[tier];

        tier = Math.abs(GregitasConstants.EAP - tier);
        return new PressureHatchPartMachine(holder, tier, IO.BOTH, min, max);
        }, (tier, builder) -> builder
                    .langValue("%s Pressure Hatch".formatted(GregitasConstants.PNF[tier]))
                    .abilities(PRESSURE_CONTAINER)
                    .rotationState(RotationState.ALL)
                    .overlayTieredHullRenderer("pressure_hatch")
                    .register(),
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13);

    public static final MultiblockMachineDefinition BURNER_REACTOR = GREGITAS_REGISTRATE.multiblock("burner_reactor", WorkableElectricMultiblockMachine::new)
            .langValue("Burner Reactor")
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(GregitasRecipeTypes.BURNER_REACTOR_RECIPES)
            .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .appearanceBlock(() -> GTBlocks.CASING_INVAR_HEATPROOF.get())
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle("F   F", "F X F", "FXXXF", "F X F", "F   F", "     ")
                    .aisle("  X  ", " XCX ", "XCCCX", " XCX ", "  X  ", "  X  ")
                    .aisle(" XXX ", "XCCCX", "XK#KX", "XC#CX", " XCX ", " XMX ")
                    .aisle("  X  ", " XCX ", "XCCCX", " XCX ", "  X  ", "  X  ")
                    .aisle("F   F", "F X F", "FXSXF", "F X F", "F   F", "     ")
                    .where('S', controller(blocks(definition.getBlock())))
                    .where('X', blocks(GTBlocks.CASING_INVAR_HEATPROOF.get()).setMinGlobalLimited(25)
                            .or(autoAbilities(definition.getRecipeTypes()))
                            .or(autoAbilities(true, false, false)
                            .or(pressurePredicate())))
                    .where('F', frames(GTMaterials.MaragingSteel300))
                    .where('C', blocks(GTBlocks.CASING_STAINLESS_CLEAN.get()))
                    .where('K', blocks(GCyMBlocks.MOLYBDENUM_DISILICIDE_COIL_BLOCK.get()))
                    .where('M', abilities(PartAbility.MUFFLER))
                    .where(' ', any())
                    .where('#', air())
                    .build())
            .workableCasingRenderer(GTCEu.id("block/casings/solid/machine_casing_heatproof"),
                    GTCEu.id("block/multiblock/implosion_compressor"), false)
            .register();


    public static TraceabilityPredicate pressurePredicate() {
        return abilities(PRESSURE_CONTAINER).setMaxGlobalLimited(1).setPreviewCount(1);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType, Int2LongFunction tankScalingFunction) {
        return registerSimpleMachines(name, recipeType, tankScalingFunction, ELECTRIC_TIERS);
    }

    public static MachineDefinition[] registerSimpleMachines(String name, GTRecipeType recipeType) {
        return registerSimpleMachines(name, recipeType, defaultTankSizeFunction);
    }
    public static MachineDefinition[] registerSimpleMachines(String name,
                                                             GTRecipeType recipeType,
                                                             Int2LongFunction tankScalingFunction,
                                                             int... tiers) {
        return registerTieredMachines(name, (holder, tier) -> new SimpleTieredMachine(holder, tier, tankScalingFunction), (tier, builder) -> builder
                .langValue("%s %s %s".formatted(VLVH[tier], toEnglishName(name), VLVT[tier]))
                .editableUI(SimpleTieredMachine.EDITABLE_UI_CREATOR.apply(GTCEu.id(name), recipeType))
                .rotationState(RotationState.NON_Y_AXIS)
                .recipeType(recipeType)
                .recipeModifier(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.NON_PERFECT_OVERCLOCK))
                .workableTieredHullRenderer(GTCEu.id("block/machines/" + name))
                .tooltips(explosion())
                .tooltips(workableTiered(tier, GTValues.V[tier], GTValues.V[tier] * 64, recipeType, tankScalingFunction.apply(tier), true))
                .compassNode(name)
                .register(), tiers);
    }

    public static MachineDefinition[] registerTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GTValues.TIER_COUNT];
        for (int tier : tiers) {
            var register = GREGITAS_REGISTRATE.machine(GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name, holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }
    public static MachineDefinition[] registerPressureTieredMachines(String name,
                                                             BiFunction<IMachineBlockEntity, Integer, MetaMachine> factory,
                                                             BiFunction<Integer, MachineBuilder<MachineDefinition>, MachineDefinition> builder,
                                                             int... tiers) {
        MachineDefinition[] definitions = new MachineDefinition[GregitasConstants.P.length];
        for (int tier : tiers) {
            var register = GREGITAS_REGISTRATE.machine(GregitasConstants.PN[tier].toLowerCase(Locale.ROOT) + "_" + name, holder -> factory.apply(holder, tier))
                    .tier(tier);
            definitions[tier] = builder.apply(tier, register);
        }
        return definitions;
    }

    public static Component explosion() {
        if (ConfigHolder.INSTANCE.machines.doTerrainExplosion)
            return Component.translatable("gtceu.universal.tooltip.terrain_resist");
        return null;
    }

    public static Component[] workableTiered(int tier, long voltage, long energyCapacity, GTRecipeType recipeType, long tankCapacity, boolean input) {
        List<Component> tooltipComponents = new ArrayList<>();
        tooltipComponents.add(input ? Component.translatable("gtceu.universal.tooltip.voltage_in", voltage, GTValues.VNF[tier]) :
                Component.translatable("gtceu.universal.tooltip.voltage_out", voltage, GTValues.VNF[tier]));
        tooltipComponents.add(Component.translatable("gtceu.universal.tooltip.energy_storage_capacity", energyCapacity));
        if (recipeType.getMaxInputs(FluidRecipeCapability.CAP) > 0 || recipeType.getMaxOutputs(FluidRecipeCapability.CAP) > 0)
            tooltipComponents.add(Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity", tankCapacity));
        return tooltipComponents.toArray(Component[]::new);
    }

    public static void init() {

    }
}
