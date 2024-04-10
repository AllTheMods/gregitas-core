package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IExplosionMachine;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.machine.steam.SteamBoilerMachine;
import com.gregtechceu.gtceu.api.machine.steam.SteamWorkableMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;

import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.world.level.material.Fluids;


@Mixin(value = SteamBoilerMachine.class, remap = false)
public abstract class SteamBoilerMachineMixin extends SteamWorkableMachine implements IUIMachine, IExplosionMachine {
    @Shadow
    @Final
    @Persisted
    public NotifiableFluidTank waterTank;

    public SteamBoilerMachineMixin(IMachineBlockEntity holder, boolean isHighPressure, Object[] args) {
        
        super(holder, isHighPressure, args);
        
    }
   
    @Inject(method = "<init>", at = @At("TAIL"), remap = false)
    private void init(IMachineBlockEntity holder, boolean isHighPressure, Object[] args ,CallbackInfo ci) {
        this.waterTank.setFilter(fluid -> ((TFCFluids.RIVER_WATER.get() == fluid.getFluid()) || (Fluids.WATER == fluid.getFluid())));
    }
 
    @Shadow
    protected abstract NotifiableFluidTank createWaterTank(Object[] args);
}
