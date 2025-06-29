package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.IRecipeHandler;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IDisplayUIMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidIngredient;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.LargeBoilerMachine;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import net.minecraft.core.Direction;
import net.minecraft.server.TickTask;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.gregtechceu.gtceu.common.machine.multiblock.steam.LargeBoilerMachine.TICKS_PER_STEAM_GENERATION;

@Mixin(value = LargeBoilerMachine.class, remap = false)
public abstract class LargeBoilerMixin extends WorkableMultiblockMachine implements IExplosionMachine, IDisplayUIMachine {

    @Shadow
    @Nullable
    protected TickableSubscription temperatureSubs;

    @Shadow
    @Persisted
    private int currentTemperature;

    @Mutable
    @Shadow
    @Final
    public final int maxTemperature;

    @Mutable
    @Shadow
    @Final
    public final int heatSpeed;

    @Shadow
    @Persisted
    private int throttle;
    @Shadow
    private boolean hasNoWater;
    @Shadow
    private int steamGenerated;

    public LargeBoilerMixin(IMachineBlockEntity holder,int maxTemperature, int heatSpeed, Object... args) {
        super(holder, args);
        this.maxTemperature = maxTemperature;
        this.heatSpeed = heatSpeed;
        this.throttle = 100;
    }


    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateSteamSubscription));
        }
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        if (getLevel() instanceof ServerLevel serverLevel) {
            serverLevel.getServer().tell(new TickTask(0, this::updateSteamSubscription));
        }
    }

    @Override
    public void onUnload() {
        if (temperatureSubs != null) {
            temperatureSubs.unsubscribe();
            temperatureSubs = null;
        }
        super.onUnload();
    }

    @Shadow
    public abstract void updateSteamSubscription();

    /**
     * @author
     * @reason
     */
    @Overwrite
    protected void updateCurrentTemperature() {
        if (recipeLogic.isWorking()) {
            if (getOffsetTimer() % 10 == 0) {
                if (currentTemperature < getMaxTemperature()) {
                    currentTemperature = Mth.clamp(currentTemperature + heatSpeed * 10, 0, getMaxTemperature());
                }
            }
        } else if (currentTemperature > 0) {
            currentTemperature -= getCoolDownRate();
        }
        if (isFormed() && getOffsetTimer() % TICKS_PER_STEAM_GENERATION == 0) {
            // drain water
            var maxDrain = currentTemperature * throttle * TICKS_PER_STEAM_GENERATION / (ConfigHolder.INSTANCE.machines.largeBoilers.steamPerWater * 100);
            var drainWater = List.of(FluidIngredient.of(maxDrain, Fluids.WATER));
            List<IRecipeHandler<?>> inputTanks = new ArrayList<>();
            if (getCapabilitiesProxy().contains(IO.IN, FluidRecipeCapability.CAP)) {
                inputTanks.addAll(Objects.requireNonNull(getCapabilitiesProxy().get(IO.IN, FluidRecipeCapability.CAP)));
            }
            if (getCapabilitiesProxy().contains(IO.BOTH, FluidRecipeCapability.CAP)) {
                inputTanks.addAll(Objects.requireNonNull(getCapabilitiesProxy().get(IO.BOTH, FluidRecipeCapability.CAP)));
            }
            if (currentTemperature < 100) {
                steamGenerated = 0;
                for (IRecipeHandler<?> tank : inputTanks) {
                    drainWater = (List<FluidIngredient>) tank.handleRecipe(IO.IN, null, drainWater, null, true);
                    this.hasNoWater = !(drainWater == null || drainWater.isEmpty() || drainWater.get(0).getAmount() > 0);
                    if (!this.hasNoWater) {
                        break;
                    }
                }
            } else {
                for (IRecipeHandler<?> tank : inputTanks) {
                    drainWater = (List<FluidIngredient>) tank.handleRecipe(IO.IN, null, drainWater, null, false);
                    if (drainWater == null || drainWater.isEmpty()) {
                        break;
                    }
                }
                var drained = (drainWater == null || drainWater.isEmpty()) ? maxDrain : maxDrain - drainWater.get(0).getAmount();
                boolean hasDrainedWater = drained > 0;
                steamGenerated = drained * ConfigHolder.INSTANCE.machines.largeBoilers.steamPerWater;
                if (hasDrainedWater) {
                    // fill steam
                    var fillSteam = List.of(FluidIngredient.of(GTMaterials.Steam.getFluid(steamGenerated)));
                    List<IRecipeHandler<?>> outputTanks = new ArrayList<>();
                    if (getCapabilitiesProxy().contains(IO.OUT, FluidRecipeCapability.CAP)) {
                        outputTanks.addAll(Objects.requireNonNull(getCapabilitiesProxy().get(IO.OUT, FluidRecipeCapability.CAP)));
                    }
                    if (getCapabilitiesProxy().contains(IO.BOTH, FluidRecipeCapability.CAP)) {
                        outputTanks.addAll(Objects.requireNonNull(getCapabilitiesProxy().get(IO.BOTH, FluidRecipeCapability.CAP)));
                    }
                    for (IRecipeHandler<?> tank : outputTanks) {
                        fillSteam = (List<FluidIngredient>) tank.handleRecipe(IO.OUT, null, fillSteam, null, false);
                        if (fillSteam == null) break;
                    }
                }
                // check explosion
                if (this.hasNoWater && hasDrainedWater) {
                    doExplosion(2.0F);
                    var center = getPos().below().relative(getFrontFacing().getOpposite());
                    if (GTValues.RNG.nextInt(100) > 80) {
                        doExplosion(center, 2.0F);
                    }
                    for (Direction x : Direction.Plane.HORIZONTAL) {
                        for (Direction y : Direction.Plane.HORIZONTAL) {
                            if (GTValues.RNG.nextInt(100) > 80) {
                                doExplosion(center.relative(x).relative(y), 2.0F);
                            }
                        }
                    }
                } else {
                    this.hasNoWater = !hasDrainedWater;
                }
            }
        }
        updateSteamSubscription();
    }

    @Shadow
    public abstract int getMaxTemperature();
    @Shadow
    public abstract int getCoolDownRate();
}
