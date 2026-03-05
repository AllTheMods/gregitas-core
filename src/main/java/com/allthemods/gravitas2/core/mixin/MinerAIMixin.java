package com.allthemods.gravitas2.core.mixin;

import com.talhanation.workers.entities.ai.MinerAI;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.minecraft.world.level.block.Block;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinerAI.class)
public class MinerAIMixin {

    @Redirect(
            method = "working",
            remap = false,
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/world/level/block/Blocks;OAK_PLANKS:Lnet/minecraft/world/level/block/Block;",
                    opcode = Opcodes.GETSTATIC
            )
    )
    private Block gregitas$replaceOakPlanksReference() {
        return TFCBlocks.WOODS.get(Wood.ACACIA).get(Wood.BlockType.PLANKS).get();
    }
}

