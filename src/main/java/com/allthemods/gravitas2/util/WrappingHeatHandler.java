package com.allthemods.gravitas2.util;

import com.allthemods.gravitas2.GregitasCore;
import lombok.Getter;
import net.dries007.tfc.common.capabilities.heat.HeatCapability;
import net.dries007.tfc.common.capabilities.heat.HeatHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;

import java.util.Objects;

public class WrappingHeatHandler extends HeatHandler {
    @Getter
    private final ItemStack stack;

    public WrappingHeatHandler(ItemStack stack, float heatCapacity, float forgingTemp, float weldingTemp) {
        super(heatCapacity, forgingTemp, weldingTemp);
        this.stack = stack;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = super.serializeNBT();
        stack.addTagElement(HeatCapability.KEY.toString(), tag);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        CompoundTag stackTag = (stack.hasTag() && stack.getTag().contains(HeatCapability.KEY.toString())) ? stack.getTag().getCompound(HeatCapability.KEY.toString()) : null;
        stackTag = Objects.requireNonNullElse(stackTag, nbt);
        super.deserializeNBT(stackTag);
    }
}
