package com.allthemods.gravitas2.core.mixin;

import net.dries007.tfc.common.blocks.TFCBlockStateProperties;
import net.dries007.tfc.common.blocks.rock.AqueductBlock;
import net.dries007.tfc.common.fluids.FluidProperty;
import net.dries007.tfc.common.fluids.IFluidLoggable;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = AqueductBlock.class, remap = false)
public abstract class FluiDuct extends HorizontalDirectionalBlock implements IFluidLoggable {

    @Shadow
    @Final
    public static final FluidProperty FLUID = TFCBlockStateProperties.WATER_AND_LAVA;


    protected FluiDuct(Properties properties) {
        super(properties);
    }
}