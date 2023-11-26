package com.allthemods.gravitas2.mixin;

import com.allthemods.gravitas2.capability.GregitasCapabilities;
import com.allthemods.gravitas2.capability.IPressureContainer;
import com.gregtechceu.gtceu.api.blockentity.MetaMachineBlockEntity;
import com.gregtechceu.gtceu.api.blockentity.forge.MetaMachineBlockEntityImpl;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = MetaMachineBlockEntityImpl.class, remap = false)
public class MetaMachineBlockEntityImplMixin extends MetaMachineBlockEntity {
    protected MetaMachineBlockEntityImplMixin(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    @Inject(method = "getCapability(Lcom/gregtechceu/gtceu/api/machine/MetaMachine;Lnet/minecraftforge/common/capabilities/Capability;Lnet/minecraft/core/Direction;)Lnet/minecraftforge/common/util/LazyOptional;", at = @At("TAIL"), cancellable = true)
    private static <T> void gregitas$injectCustomMachineCapabilitiesBecauseForgeEventIsTooEarly(MetaMachine machine, @NotNull Capability<T> cap, @Nullable Direction side, CallbackInfoReturnable<@Nullable LazyOptional<T>> cir) {
        if (cap == HeatCapability.BLOCK_CAPABILITY) {
            if (machine instanceof IHeatBlock heatBlock) {
                cir.setReturnValue(HeatCapability.BLOCK_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> heatBlock)));
            }
            var list = machine.getTraits().stream().filter(IHeatBlock.class::isInstance).filter(t -> t.hasCapability(side)).map(IHeatBlock.class::cast).toList();
            if (!list.isEmpty()) {
                // TODO wrap list?
                cir.setReturnValue(HeatCapability.BLOCK_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> list.get(0))));
            }
        } else if (cap == GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER) {
            if (machine instanceof IPressureContainer pressureContainer) {
                cir.setReturnValue(GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER.orEmpty(cap, LazyOptional.of(() -> pressureContainer)));
            }
            var list = machine.getTraits().stream().filter(IPressureContainer.class::isInstance).filter(t -> t.hasCapability(side)).map(IPressureContainer.class::cast).toList();
            if (!list.isEmpty()) {
                // TODO wrap list?
                cir.setReturnValue(GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER.orEmpty(cap, LazyOptional.of(() -> list.get(0))));
            }
        }
    }
}
