package com.allthemods.gravitas2.item;

import com.allthemods.gravitas2.block.PressurePipeBlock;
import com.gregtechceu.gtceu.api.block.PipeBlock;
import com.gregtechceu.gtceu.api.item.PipeBlockItem;
import com.lowdragmc.lowdraglib.client.renderer.IItemRendererProvider;
import com.lowdragmc.lowdraglib.client.renderer.IRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

public class PressurePipeBlockItem extends PipeBlockItem {

    public PressurePipeBlockItem(PipeBlock block, Properties properties) {
        super(block, properties);
    }

    @Override
    public PressurePipeBlock getBlock() {
        return (PressurePipeBlock) super.getBlock();
    }
}
