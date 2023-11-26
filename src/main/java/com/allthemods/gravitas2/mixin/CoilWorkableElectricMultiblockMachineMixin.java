package com.allthemods.gravitas2.mixin;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.dries007.tfc.TerraFirmaCraft;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.dries007.tfc.util.calendar.Calendar;
import net.dries007.tfc.util.calendar.CalendarWorldData;
import net.dries007.tfc.util.climate.Climate;
import net.dries007.tfc.util.climate.ClimateModels;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@Mixin(value = CoilWorkableElectricMultiblockMachine.class, remap = false)
public abstract class CoilWorkableElectricMultiblockMachineMixin extends WorkableElectricMultiblockMachine implements IHeatBlock {
    private static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(CoilWorkableElectricMultiblockMachine.class, WorkableMultiblockMachine.MANAGED_FIELD_HOLDER);

    // Temperature, in Kelvin (because GT uses kelvin instead of celsius.)
    @Unique
    @Persisted(key = "currentTemp") @DescSynced
    private float gregitas$currentTemp = 273.15F;

    public CoilWorkableElectricMultiblockMachineMixin(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    @Override
    public float getTemperature() {
        return gregitas$currentTemp - 273.15F;
    }

    @Override
    public void setTemperature(float temp) {
        gregitas$currentTemp = temp + 273.15F;
        this.onChanged();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        if (this.getLevel() instanceof ServerLevel level) {
            this.gregitas$currentTemp = Climate.getTemperature(level, this.getPos(), CalendarWorldData.get(level).getCalendar());
        }
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
