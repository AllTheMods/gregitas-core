package com.allthemods.gravitas2.core.mixin;


import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.dries007.tfc.common.blocks.rock.AqueductBlock;
import net.dries007.tfc.common.fluids.FluidProperty;
import net.dries007.tfc.common.fluids.IFluidLoggable;
import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.stream.Stream;

@Mixin(AqueductBlock.class)
public abstract class AqueductBlockMixin extends HorizontalDirectionalBlock implements IFluidLoggable {
    @Final
    @Shadow
    private static final FluidProperty FLUID = FluidProperty.create("fluid", Stream.of(Fluids.EMPTY, Fluids.WATER, TFCFluids.SALT_WATER, TFCFluids.SPRING_WATER, Fluids.LAVA));
    protected AqueductBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "pickupBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;scheduleTick(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;I)V"), cancellable = true)
    private void gregitas$cancelLavaPickup(LevelAccessor level, BlockPos pos, BlockState state, CallbackInfoReturnable<ItemStack> cir) {
        if (state.getValue(getFluidProperty()).getFluid().isSame(Fluids.LAVA)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public FluidProperty getFluidProperty() {
        return FLUID;
    }
}