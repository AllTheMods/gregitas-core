package com.allthemods.gravitas2.machine.trait;

import com.allthemods.gravitas2.util.GregitasConstants;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;

public class AtmosphericPressureContainer extends NotifiablePressureContainer {

    /**
     * Atmopsheric pressure container which always remains at atmospheric
     *
     * @param io the I/O direction of the container.
     * @param volume the volume of the container, must be nonzero
     */
    public AtmosphericPressureContainer(MetaMachine metaTileEntity, double volume) {
        super(metaTileEntity, GregitasConstants.EARTH_PRESSURE * 0.9, GregitasConstants.EARTH_PRESSURE * 1.1, volume);
    }

    @Override
    public void setParticles(double amount) {/**/}
}