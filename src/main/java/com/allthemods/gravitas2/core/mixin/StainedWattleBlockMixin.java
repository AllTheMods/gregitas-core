package com.allthemods.gravitas2.core.mixin;

import net.dries007.tfc.common.blocks.StainedWattleBlock;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(value = StainedWattleBlock.class, remap = false)
public class StainedWattleBlockMixin {
    /**
     * @author Uncandango
     * @reason Following the GOAT 🐐 thevortex
     */
    @Overwrite
    private static @Nullable BlockState getPossibleDyedState(ItemStack item, BlockState current){
        if (item.getItem() instanceof DyeItem dyeItem) {
            var block = TFCBlocks.STAINED_WATTLE.get(dyeItem.getDyeColor());
            if (block == null) return null;
            var state = block.get().defaultBlockState();
            return state.getBlock() != current.getBlock() ? state : null;
        }
        return null;
    }
}
