package com.allthemods.gravitas2.machine.trait;

import com.allthemods.gravitas2.capability.IPressureContainer;
import com.allthemods.gravitas2.recipe.capability.PressureRecipeCapability;
import com.allthemods.gravitas2.util.GregitasConstants;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NotifiablePressureContainer extends NotifiableRecipeHandlerTrait<Double> implements IPressureContainer {
    public static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(NotifiablePressureContainer.class, NotifiableRecipeHandlerTrait.MANAGED_FIELD_HOLDER);

    @Getter
    protected IO handlerIO;
    @Getter
    private final double minPressure;
    @Getter
    private final double maxPressure;
    @Getter
    private final double volume;

    @Getter
    @Persisted @DescSynced
    private double particles;
    @Getter
    @Setter
    private long timeStamp;

    /**
     * Default pressure container
     * {@link IPressureContainer}
     *
     * @param volume the volume of the container, must be nonzero
     */
    public NotifiablePressureContainer(MetaMachine machine, IO handlerIO, double minPressure, double maxPressure, double volume) {
        super(machine);
        this.handlerIO = handlerIO;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.volume = volume;
        this.particles = volume * GregitasConstants.EARTH_PRESSURE;
    }

    @Override
    public void setParticles(double amount) {
        this.particles = amount;
        this.machine.markDirty();
    }

    @Override
    public List<Double> handleRecipeInner(IO io, GTRecipe recipe, List<Double> left, @Nullable String slotName, boolean simulate) {
        IPressureContainer container = this;
        double pressure = left.stream().reduce(0d, Double::sum);

        final double containerPressure = container.getPressure();
        double pressureToChange;

        // pressure changes by 1 percent per tick
        if (pressure != GregitasConstants.EARTH_PRESSURE) pressureToChange = containerPressure * 0.01;
        else return null;

        if (pressure > GregitasConstants.EARTH_PRESSURE) pressureToChange = -pressureToChange;

        final double newPressure = containerPressure + pressureToChange;
        // pressure must be within +/- 1 exponent of the target
        if (newPressure < pressure / 10 || newPressure > pressure * 10) {
            return left;
        }

        // P * V = n
        boolean isChangeSafe = container.changeParticles(pressureToChange * container.getVolume(), simulate);
        return isChangeSafe ? null : List.of(containerPressure - pressureToChange);
    }

    @Override
    public RecipeCapability<Double> getCapability() {
        return PressureRecipeCapability.CAP;
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }
}
