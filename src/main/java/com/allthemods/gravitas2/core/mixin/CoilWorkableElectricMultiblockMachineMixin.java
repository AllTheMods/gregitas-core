package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.dries007.tfc.util.climate.Climate;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@Mixin(value = CoilWorkableElectricMultiblockMachine.class, remap = false)
public abstract class CoilWorkableElectricMultiblockMachineMixin extends WorkableElectricMultiblockMachine implements IHeatBlock {
    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(CoilWorkableElectricMultiblockMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    @Shadow private ICoilType coilType;
    @Shadow public abstract int getCoilTier();

    @Shadow public abstract ICoilType getCoilType();

    // Temperature, in Kelvin (because GT uses kelvin instead of celsius.)
    @Unique
    @Persisted(key = "currentTemp") @DescSynced
    private float gregitas$currentTemp = 273;
    @Unique
    private TickableSubscription gregitas$temperatureTick = null;

    public CoilWorkableElectricMultiblockMachineMixin(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public float getTemperature() {
        return gregitas$currentTemp - 273;
    }

    @Override
    public void setTemperature(float temp) {
        gregitas$currentTemp = temp + 273;
        this.onChanged();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (getTemperature() == 0) {
            setTemperature(Climate.getTemperature(this.getLevel(), this.getPos()));
        }
        if (gregitas$temperatureTick == null) {
            gregitas$temperatureTick = subscribeServerTick(this::gregitas$temperatureTick);
        }
    }

    @Override
    public void onUnload() {
        super.onUnload();
        if (gregitas$temperatureTick != null) {
            gregitas$temperatureTick.unsubscribe();
            gregitas$temperatureTick = null;
        }
    }

    @Unique
    private void gregitas$temperatureTick() {
        if (this.getLevel() instanceof ServerLevel level) {
            setTemperature(HeatCapability.adjustTempTowards(getTemperature(), Climate.getTemperature(level, this.getPos()), 0.5f));
        }
    }

    @Override
    public void onWorking() {
        super.onWorking();
        this.setTemperature(HeatCapability.adjustTempTowards(getTemperature(), (coilType.getCoilTemperature() + 100 * Math.max(0, this.getTier() - GTValues.MV)) - 273, (getCoilTier() + 1) / 1.5f));
        /* nah too evil.
        if (getTemperature() <= getCoilType().getCoilTemperature()) {
            if (!this.getCapabilitiesProxy().contains(IO.IN, EURecipeCapability.CAP)) return;

            if (getRecipeLogic().getLastRecipe() == null) return;
            long EUt = RecipeHelper.getInputEUt(getRecipeLogic().getLastRecipe());
            GTRecipe recipe = GTRecipeBuilder.ofRaw().EUt(EUt).buildRawRecipe();
            getRecipeLogic().handleTickRecipe(recipe);
        }
        */
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
