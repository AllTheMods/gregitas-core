package com.allthemods.gravitas2.pipelike.pressure;

import com.allthemods.gravitas2.block.entity.PressurePipeBlockEntity;
import com.gregtechceu.gtceu.api.pipenet.PipeNetWalker;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PressureNetWalker extends PipeNetWalker<PressurePipeBlockEntity,PressurePipeData, PressurePipeNet> {

    private double pressure = -1;

    public static void checkPressure(PressurePipeNet net, BlockPos start, double pressure) {
        PressureNetWalker walker = new PressureNetWalker(net, start, 0);
        walker.pressure = pressure;
        walker.traversePipeNet();
    }

    protected PressureNetWalker(PressurePipeNet world, BlockPos sourcePipe, int walkedBlocks) {
        super(world, sourcePipe, walkedBlocks);
    }

    @NotNull
    @Override
    protected PipeNetWalker<PressurePipeBlockEntity,PressurePipeData, PressurePipeNet> createSubWalker(PressurePipeNet pipeNet, Direction facingToNextPos, BlockPos nextPos, int walkedBlocks) {
        PressureNetWalker walker = new PressureNetWalker(pipeNet, nextPos, walkedBlocks);
        walker.pressure = pressure;
        return walker;
    }

    @Override
    protected Class<PressurePipeBlockEntity> getBasePipeClass() {
        return PressurePipeBlockEntity.class;
    }

    @Override
    protected void checkPipe(PressurePipeBlockEntity pipeTile, BlockPos pos) {
        Objects.requireNonNull(pipeTile.getNodeData()).checkPressure(pressure, this.pipeNet, pos);
    }
}