package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TieredEnergyMachine;
import com.gregtechceu.gtceu.api.machine.feature.IAutoOutputItem;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.common.machine.electric.FisherMachine;

import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.material.Fluids;

@Mixin(value = FisherMachine.class, remap = false)
public abstract class FisherMachineMixin extends TieredEnergyMachine implements IAutoOutputItem, IFancyUIMachine, IMachineModifyDrops{


    @Shadow
    @Final
    public static final int WATER_CHECK_SIZE = 5;
    @Shadow
    private boolean hasWater=false;
    
    public FisherMachineMixin(IMachineBlockEntity holder, int tier, Object[] args) {
        super(holder, tier, args);
    
    }

    @Overwrite
    private void updateHasWater(){
        for (int x = 0; x < WATER_CHECK_SIZE; x++)
            for (int z = 0; z < WATER_CHECK_SIZE; z++) {
                BlockPos waterCheckPos = getPos().below().offset(x - WATER_CHECK_SIZE / 2, 0, z - WATER_CHECK_SIZE / 2);
                if (!((getLevel().getBlockState(waterCheckPos).getFluidState().is(Fluids.WATER)) || (getLevel().getBlockState(waterCheckPos).getFluidState().is(TFCFluids.RIVER_WATER.get())))) {
                    hasWater = false;
                    return;
                }
            }
        hasWater = true;
    }
   
}
