package com.allthemods.gravitas2.block;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.block.entity.GregitasBlockEntities;
import com.allthemods.gravitas2.pipelike.pressure.LevelPressureNet;
import com.allthemods.gravitas2.pipelike.pressure.PressurePipeData;
import com.allthemods.gravitas2.pipelike.pressure.PressurePipeType;
import com.gregtechceu.gtceu.api.block.PipeBlock;
import com.gregtechceu.gtceu.api.blockentity.PipeBlockEntity;
import com.gregtechceu.gtceu.api.pipenet.IPipeNode;
import com.gregtechceu.gtceu.client.model.PipeModel;
import com.gregtechceu.gtceu.client.renderer.block.PipeBlockRenderer;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class PressurePipeBlock extends PipeBlock<PressurePipeType, PressurePipeData, LevelPressureNet> {

    public final PipeBlockRenderer renderer;
    @Getter
    public final PipeModel pipeModel;

    public PressurePipeBlock(Properties properties, PressurePipeType pressurePipeType) {
        super(properties, pressurePipeType);
        this.pipeModel = new PipeModel(pressurePipeType.getThickness(), () -> GregitasCore.id("block/pipe/pressure_pipe_side"), () -> GregitasCore.id("block/pipe/pressure_pipe_open"), null, null);
        this.renderer = new PipeBlockRenderer(this.pipeModel);
    }

    @Override
    public LevelPressureNet getWorldPipeNet(ServerLevel level) {
        return LevelPressureNet.getOrCreate(level);
    }

    @Override
    public BlockEntityType<? extends PipeBlockEntity<PressurePipeType, PressurePipeData>> getBlockEntityType() {
        return GregitasBlockEntities.PRESSURE_PIPE.get();
    }

    @Override
    public PressurePipeData createRawData(BlockState pState, @Nullable ItemStack pStack) {
        return new PressurePipeData(this.pipeType.getMinPressure(), this.pipeType.getMaxPressure(), this.pipeType.getVolume(), (byte) 0);
    }

    @Override
    public PressurePipeData createProperties(IPipeNode<PressurePipeType, PressurePipeData> pipeTile) {
        return null;
    }

    @Override
    public PressurePipeData getFallbackType() {
        return PressurePipeData.EMPTY;
    }

    @Override
    public @Nullable PipeBlockRenderer getRenderer(BlockState state) {
        return renderer;
    }

    @Override
    public boolean canPipesConnect(IPipeNode<PressurePipeType, PressurePipeData> selfTile, Direction side, IPipeNode<PressurePipeType, PressurePipeData> sideTile) {
        return false;
    }

    @Override
    public boolean canPipeConnectToBlock(IPipeNode<PressurePipeType, PressurePipeData> selfTile, Direction side, @Nullable BlockEntity tile) {
        return false;
    }
}
