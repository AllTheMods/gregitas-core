package com.allthemods.gravitas2.block;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.block.entity.GregitasBlockEntities;
import com.allthemods.gravitas2.block.entity.PressurePipeBlockEntity;
import com.allthemods.gravitas2.capability.GregitasCapabilities;
import com.allthemods.gravitas2.pipelike.pressure.LevelPressureNet;
import com.allthemods.gravitas2.pipelike.pressure.PressurePipeData;
import com.allthemods.gravitas2.pipelike.pressure.PressurePipeType;
import com.gregtechceu.gtceu.api.block.PipeBlock;
import com.gregtechceu.gtceu.api.blockentity.PipeBlockEntity;
import com.gregtechceu.gtceu.api.pipenet.IPipeNode;
import com.gregtechceu.gtceu.api.registry.registrate.provider.GTBlockstateProvider;
import com.gregtechceu.gtceu.client.model.pipe.PipeModel;
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


    public PressurePipeBlock(Properties properties, PressurePipeType pressurePipeType) {
        super(properties, pressurePipeType);
    }

    @Override
    public PipeModel createPipeModel(GTBlockstateProvider provider) {
        return new PipeModel(this, provider, pipeType.getThickness(), GregitasCore.id("block/pipe/pressure_pipe_side"), GregitasCore.id("block/pipe/pressure_pipe_open"));
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
        var pipeType = pipeTile.getPipeType();
        if (pipeType == null) return getFallbackType();
        return this.pipeType.modifyProperties(PressurePipeData.EMPTY);
    }

    @Override
    public PressurePipeData getFallbackType() {
        return PressurePipeData.EMPTY;
    }

    @Override
    public boolean canPipesConnect(IPipeNode<PressurePipeType, PressurePipeData> selfTile, Direction side, IPipeNode<PressurePipeType, PressurePipeData> sideTile) {
        return selfTile instanceof PressurePipeBlockEntity && sideTile instanceof PressurePipeBlockEntity;
    }

    @Override
    public boolean canPipeConnectToBlock(IPipeNode<PressurePipeType, PressurePipeData> selfTile, Direction side, @Nullable BlockEntity tile) {
        return tile != null && tile.getCapability(GregitasCapabilities.CAPABILITY_PRESSURE_CONTAINER, side.getOpposite()).isPresent();
    }
}
