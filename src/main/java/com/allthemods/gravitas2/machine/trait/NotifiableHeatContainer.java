package com.allthemods.gravitas2.machine.trait;

import com.allthemods.gravitas2.recipe.capability.TemperatureRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.capability.recipe.RecipeCapability;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableRecipeHandlerTrait;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import lombok.Getter;
import lombok.Setter;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.dries007.tfc.util.climate.Climate;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NotifiableHeatContainer extends NotifiableRecipeHandlerTrait<Float> implements IHeatBlock {

    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NotifiableHeatContainer.class, NotifiableRecipeHandlerTrait.MANAGED_FIELD_HOLDER);

    @Getter
    protected IO handlerIO;
    // store in kelvin
    @Persisted @DescSynced
    private float temperature;
    @Getter @Setter
    private long timeStamp;

    public NotifiableHeatContainer(MetaMachine machine, IO handlerIO) {
        super(machine);
        this.handlerIO = handlerIO;
        machine.subscribeServerTick(this::tickHeat);
    }

    @Override
    public List<Float> handleRecipeInner(IO io, GTRecipe recipe, List<Float> left, @Nullable String slotName, boolean simulate) {
        float heat = left.stream().reduce(0.0f, Float::sum);

        if (heat > 0) {
            this.setTemperature(HeatCapability.adjustTempTowards(this.temperature, heat));
            return this.temperature >= heat ? null : List.of(heat - this.temperature);
        } else if (heat < 0) {
            this.setTemperature(HeatCapability.adjustTempTowards(this.temperature, heat));
            return this.temperature <= heat ? null : List.of(this.temperature - heat);
        }

        return List.of(heat);
    }

    protected void tickHeat() {
        this.setTemperature(HeatCapability.adjustTempTowards(this.getTemperature(), Climate.getTemperature(machine.getLevel(), machine.getPos())));
    }

    @Override
    public RecipeCapability<Float> getCapability() {
        return TemperatureRecipeCapability.CAP;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public float getTemperature() {
        return temperature - 273.15f;
    }

    @Override
    public void setTemperature(float temp) {
        this.temperature = temp + 273.15f;
    }
}
