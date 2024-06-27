package com.allthemods.gravitas2.core.mixin;


import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.soil.SandBlockType;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.dries007.tfc.common.blocks.wood.Wood.BlockType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceType;
import net.minecraft.world.level.levelgen.structure.structures.BuriedTreasurePieces;
import net.minecraft.world.level.levelgen.structure.structures.BuriedTreasureStructure;
import net.minecraft.world.level.levelgen.structure.structures.BuriedTreasurePieces.BuriedTreasurePiece;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;

@Mixin(BuriedTreasurePiece.class)
public abstract class BuriedTreasureMixin extends StructurePiece{

    public BuriedTreasureMixin(StructurePieceType type, CompoundTag tag) {
        super(type, tag);
        //TODO Auto-generated constructor stub
    }

    
    @Inject(method = "postProcess", at = @At("RETURN"), cancellable = true)
    public void postProcessing(WorldGenLevel level, StructureManager structureManager, ChunkGenerator generator, RandomSource random, BoundingBox box, ChunkPos chunkPos, BlockPos pos, CallbackInfo cir) {
      int i = level.getHeight(Types.OCEAN_FLOOR_WG, this.boundingBox.minX(), this.boundingBox.minZ());
      BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos(this.boundingBox.minX(), i-3, this.boundingBox.minZ());

      while(mutableBlockPos.getY() > level.getMinBuildHeight()) {
         BlockState blockState = level.getBlockState(mutableBlockPos);
         BlockState blockState2 = level.getBlockState(mutableBlockPos.below());
         
            BlockState blockState3 = !blockState.isAir() && !this.isLiquid(blockState) ? blockState : getSandforPOS(mutableBlockPos.below(), level);
            Direction[] var13 = Direction.values();
            int var14 = var13.length;

            for(int var15 = 0; var15 < var14; ++var15) {
               Direction direction = var13[var15];
               BlockPos blockPos = mutableBlockPos.relative(direction);
               BlockState blockState4 = level.getBlockState(blockPos);
               if (blockState4.isAir() || this.isLiquid(blockState4)) {
                  BlockPos blockPos2 = blockPos.below();
                  BlockState blockState5 = level.getBlockState(blockPos2);
                  if ((blockState5.isAir() || this.isLiquid(blockState5)) && direction != Direction.UP) {
                     level.setBlock(blockPos, blockState2, 3);
                  } else {
                     level.setBlock(blockPos, blockState3, 3);
                  }
               }
            }

            this.boundingBox = new BoundingBox(mutableBlockPos);
            level.setBlock(mutableBlockPos.above(), TFCBlocks.WOODS.get(Wood.PALM).get(BlockType.LOG).get().defaultBlockState(), 3);
            this.createChest(level, box, random, mutableBlockPos, BuiltInLootTables.BURIED_TREASURE, (BlockState)null);
            cir.cancel();
            return;
         

        
      }

  
   }
   private boolean isLiquid(BlockState state) {
    return state == Blocks.WATER.defaultBlockState() || state == Blocks.LAVA.defaultBlockState();
 }
 private BlockState getSandforPOS(BlockPos pos, WorldGenLevel level){
   BlockState blockState = level.getBlockState(pos.below());
   return !blockState.isAir() && !this.isLiquid(blockState) ? blockState : TFCBlocks.SAND.get(SandBlockType.YELLOW).get().defaultBlockState();
 }
}
