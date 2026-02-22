package com.allthemods.gravitas2.util;

import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.eureka.block.IWoodType;

import java.util.Locale;


public enum GWoodType implements IWoodType {
    BLACKWOOD(TFCBlocks.WOODS.get(Wood.BLACKWOOD).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.BLACKWOOD).get(Wood.BlockType.PLANKS).get()),
    ROSEWOOD(TFCBlocks.WOODS.get(Wood.ROSEWOOD).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.ROSEWOOD).get(Wood.BlockType.PLANKS).get()),
    WILLOW(TFCBlocks.WOODS.get(Wood.WILLOW).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.WILLOW).get(Wood.BlockType.PLANKS).get()),
    DOUGLASFIR(TFCBlocks.WOODS.get(Wood.DOUGLAS_FIR).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.DOUGLAS_FIR).get(Wood.BlockType.PLANKS).get()),
    OAK(TFCBlocks.WOODS.get(Wood.OAK).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.OAK).get(Wood.BlockType.PLANKS).get()),
    SPRUCE(TFCBlocks.WOODS.get(Wood.SPRUCE).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.SPRUCE).get(Wood.BlockType.PLANKS).get()),
    KAPOK(TFCBlocks.WOODS.get(Wood.KAPOK).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.KAPOK).get(Wood.BlockType.PLANKS).get()),
    SYCAMORE(TFCBlocks.WOODS.get(Wood.SYCAMORE).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.SYCAMORE).get(Wood.BlockType.PLANKS).get()),
    CHESTNUT(TFCBlocks.WOODS.get(Wood.CHESTNUT).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.CHESTNUT).get(Wood.BlockType.PLANKS).get()),
    PALM(TFCBlocks.WOODS.get(Wood.PALM).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.PALM).get(Wood.BlockType.PLANKS).get()),
    WHITECEDAR(TFCBlocks.WOODS.get(Wood.WHITE_CEDAR).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.WHITE_CEDAR).get(Wood.BlockType.PLANKS).get()),
    HICKORY(TFCBlocks.WOODS.get(Wood.HICKORY).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.HICKORY).get(Wood.BlockType.PLANKS).get()),
    MAPLE(TFCBlocks.WOODS.get(Wood.MAPLE).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.MAPLE).get(Wood.BlockType.PLANKS).get()),
    BIRCH(TFCBlocks.WOODS.get(Wood.BIRCH).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.BIRCH).get(Wood.BlockType.PLANKS).get()),
    ACACIA(TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.PLANKS).get()),
    MANGROVE(TFCBlocks.WOODS.get(Wood.MANGROVE).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.MANGROVE).get(Wood.BlockType.PLANKS).get()),
    ASPEN(TFCBlocks.WOODS.get(Wood.ASPEN).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.ASPEN).get(Wood.BlockType.PLANKS).get()),
    ASH(TFCBlocks.WOODS.get(Wood.ASH).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.ASH).get(Wood.BlockType.PLANKS).get()),
    SEQUOIA(TFCBlocks.WOODS.get(Wood.SEQUOIA).get(Wood.BlockType.LOG).get(), TFCBlocks.WOODS.get(Wood.SEQUOIA).get(Wood.BlockType.PLANKS).get());




    private final Block plankBlock;

    private final Block logBlock;
    private GWoodType(Block logBlock, Block plankBlock) {
        this.logBlock = logBlock;
        this.plankBlock = plankBlock;
    }
    static
    {


    }


    @NotNull
    public final Block getLogs() {
        return this.logBlock;
    }

    @NotNull
    public final Block getWood() {
        return this.logBlock;
    }
    @NotNull
    public final Block getPlanks() {
        return this.plankBlock;
    }



    public String getSerializedName() {
        String name = this.toString().toLowerCase(Locale.ROOT);
        return name;
    }
}
