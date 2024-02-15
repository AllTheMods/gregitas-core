package com.allthemods.gravitas2.compat;

import com.eerussianguy.firmalife.common.blocks.OvenBottomBlock;
import com.eerussianguy.firmalife.common.blocks.OvenHopperBlock;
import com.eerussianguy.firmalife.common.blocks.OvenTopBlock;
import com.simibubi.create.Create;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPoint;
import com.simibubi.create.content.kinetics.mechanicalArm.ArmInteractionPointType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Function;

public class ArmCompat {
    public static final BrickOvenTop BRICK_OVEN_TOP = register("brick_oven_top", BrickOvenTop::new);
    public static final BrickOvenBottom BRICK_OVEN_BOTTOM = register("brick_oven_bottom", BrickOvenBottom::new);
    public static final OvenHopper OVEN_HOPPER = register("oven_hopper", OvenHopper::new);

    public ArmCompat() {
    }

    private static <T extends ArmInteractionPointType> T register(String id, Function<ResourceLocation, T> factory) {
        T type = (T) factory.apply(Create.asResource(id));
        ArmInteractionPointType.register(type);
        return type;
    }

    public static void registerAll() {
    }

    public static class BrickOvenTop extends ArmInteractionPointType {
        public BrickOvenTop(ResourceLocation id) {
            super(id);
        }

        public boolean canCreatePoint(Level level, BlockPos pos, BlockState state) {
            return state.getBlock() instanceof OvenTopBlock;
        }

        public ArmInteractionPoint createPoint(Level level, BlockPos pos, BlockState state) {
            return new ArmInteractionPoint(this, level, pos, state);
        }
    }

    public static class BrickOvenBottom extends ArmInteractionPointType {
        public BrickOvenBottom(ResourceLocation id) {
            super(id);
        }

        public boolean canCreatePoint(Level level, BlockPos pos, BlockState state) {
            return state.getBlock() instanceof OvenBottomBlock;
        }

        public ArmInteractionPoint createPoint(Level level, BlockPos pos, BlockState state) {
            return new ArmInteractionPoint(this, level, pos, state);
        }
    }

    public static class OvenHopper extends ArmInteractionPointType {
        public OvenHopper(ResourceLocation id) {
            super(id);
        }

        public boolean canCreatePoint(Level level, BlockPos pos, BlockState state) {
            return state.getBlock() instanceof OvenHopperBlock;
        }

        public ArmInteractionPoint createPoint(Level level, BlockPos pos, BlockState state) {
            return new ArmInteractionPoint(this, level, pos, state);
        }
    }

}