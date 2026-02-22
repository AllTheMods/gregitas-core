package com.allthemods.gravitas2.util;

import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.eureka.block.IWoodType;

import java.util.Locale;
import java.util.function.Supplier;


public enum GWoodType implements IWoodType {
BLACKWOOD(Wood.BLACKWOOD.getBlock(Wood.BlockType.LOG), Wood.BLACKWOOD.getBlock(Wood.BlockType.PLANKS)),
ROSEWOOD(Wood.ROSEWOOD.getBlock(Wood.BlockType.LOG), Wood.ROSEWOOD.getBlock(Wood.BlockType.PLANKS)),
WILLOW(Wood.WILLOW.getBlock(Wood.BlockType.LOG), Wood.WILLOW.getBlock(Wood.BlockType.PLANKS)),
DOUGLASFIR(Wood.DOUGLAS_FIR.getBlock(Wood.BlockType.LOG), Wood.DOUGLAS_FIR.getBlock(Wood.BlockType.PLANKS)),
OAK(Wood.OAK.getBlock(Wood.BlockType.LOG), Wood.OAK.getBlock(Wood.BlockType.PLANKS)),
SPRUCE(Wood.SPRUCE.getBlock(Wood.BlockType.LOG), Wood.SPRUCE.getBlock(Wood.BlockType.PLANKS)),
KAPOK(Wood.KAPOK.getBlock(Wood.BlockType.LOG), Wood.KAPOK.getBlock(Wood.BlockType.PLANKS)),
SYCAMORE(Wood.SYCAMORE.getBlock(Wood.BlockType.LOG), Wood.SYCAMORE.getBlock(Wood.BlockType.PLANKS)),
CHESTNUT(Wood.CHESTNUT.getBlock(Wood.BlockType.LOG), Wood.CHESTNUT.getBlock(Wood.BlockType.PLANKS)),
PALM(Wood.PALM.getBlock(Wood.BlockType.LOG), Wood.PALM.getBlock(Wood.BlockType.PLANKS)),
WHITECEDAR(Wood.WHITE_CEDAR.getBlock(Wood.BlockType.LOG), Wood.WHITE_CEDAR.getBlock(Wood.BlockType.PLANKS)),
HICKORY(Wood.HICKORY.getBlock(Wood.BlockType.LOG), Wood.HICKORY.getBlock(Wood.BlockType.PLANKS)),
MAPLE(Wood.MAPLE.getBlock(Wood.BlockType.LOG), Wood.MAPLE.getBlock(Wood.BlockType.PLANKS)),
BIRCH(Wood.BIRCH.getBlock(Wood.BlockType.LOG), Wood.BIRCH.getBlock(Wood.BlockType.PLANKS)),
ACACIA(Wood.ACACIA.getBlock(Wood.BlockType.LOG), Wood.ACACIA.getBlock(Wood.BlockType.PLANKS)),
MANGROVE(Wood.MANGROVE.getBlock(Wood.BlockType.LOG), Wood.MANGROVE.getBlock(Wood.BlockType.PLANKS)),
ASPEN(Wood.ASPEN.getBlock(Wood.BlockType.LOG), Wood.ASPEN.getBlock(Wood.BlockType.PLANKS)),
ASH(Wood.ASH.getBlock(Wood.BlockType.LOG), Wood.ASH.getBlock(Wood.BlockType.PLANKS)),
SEQUOIA(Wood.SEQUOIA.getBlock(Wood.BlockType.LOG), Wood.SEQUOIA.getBlock(Wood.BlockType.PLANKS));





private final Supplier<Block> logBlock;
private final Supplier<Block> plankBlock;

private GWoodType(Supplier<Block> logBlock, Supplier<Block> plankBlock) {
    this.logBlock = logBlock;
    this.plankBlock = plankBlock;
}

    @NotNull
    public final Block getLogs() {
        return this.logBlock.get();
    }

    @NotNull
    public final Block getWood() {
        return this.logBlock.get();
    }
    @NotNull
    public final Block getPlanks() {
        return this.plankBlock.get();
    }



    public String getSerializedName() {
        String name = this.toString().toLowerCase(Locale.ROOT);
        return name;
    }
}
