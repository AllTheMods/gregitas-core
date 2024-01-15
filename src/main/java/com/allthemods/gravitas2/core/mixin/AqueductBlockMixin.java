package com.allthemods.gravitas2.core.mixin;


import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.dries007.tfc.common.blocks.TFCBlockStateProperties;
import net.dries007.tfc.common.blocks.rock.AqueductBlock;
import net.dries007.tfc.common.fluids.FluidProperty;
import net.dries007.tfc.common.fluids.IFluidLoggable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AqueductBlock.class)
public abstract class AqueductBlockMixin extends HorizontalDirectionalBlock implements IFluidLoggable {

    protected AqueductBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "pickupBlock", cancellable = true, at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;scheduleTick(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;I)V"))
    private void gregitas$cancelLavaPickup(LevelAccessor level, BlockPos pos, BlockState state, CallbackInfoReturnable<ItemStack> cir) {
        if (state.getValue(getFluidProperty()).getFluid().isSame(Fluids.LAVA)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }

    @ModifyReturnValue(method = "getFluidProperty", at = @At("TAIL"), remap = false)
    private FluidProperty gregitas$changeProperty(FluidProperty original) {
        return TFCBlockStateProperties.WATER_AND_LAVA;
    }
}