package com.allthemods.gravitas2.core.mixin;


import com.allthemods.gravitas2.fluid.FluidPropertyExtension;
import net.dries007.tfc.common.blocks.rock.AqueductBlock;
import net.dries007.tfc.common.fluids.FluidProperty;
import net.dries007.tfc.common.fluids.IFluidLoggable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AqueductBlock.class)
public abstract class AqueductBlockMixin extends HorizontalDirectionalBlock implements FluidPropertyExtension, IFluidLoggable {

    protected AqueductBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "pickupBlock", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/LevelAccessor;scheduleTick(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;I)V"), cancellable = true)
    private void gregitas$cancelLavaPickup(LevelAccessor level, BlockPos pos, BlockState state, CallbackInfoReturnable<ItemStack> cir) {
        if (state.getValue(getFluidProperty()).getFluid().isSame(Fluids.LAVA)) {
            cir.setReturnValue(ItemStack.EMPTY);
        }
    }

    @Inject(method = "getFluidProperty", at = @At(value = "RETURN"), cancellable = true, remap = false)
    private void gregitas$getFluidProperty(CallbackInfoReturnable<FluidProperty> cir) {
        cir.setReturnValue(LAVA_AND_ALL_WATER);
    }

     @Override
    public int getLightEmission(BlockState state, BlockGetter level, BlockPos pos)
    {
        return state.getFluidState().getType().isSame(Fluids.LAVA) ? 15 : 0;
    }
}