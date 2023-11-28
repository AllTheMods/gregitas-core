package com.allthemods.gravitas2.block;

import com.allthemods.gravitas2.item.PressurePipeBlockItem;
import com.allthemods.gravitas2.pipelike.pressure.PressurePipeType;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.gregtechceu.gtceu.api.block.RendererMaterialBlock;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.item.LaserPipeBlockItem;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.block.LaserPipeBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.dries007.tfc.common.blocks.rock.Ore;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.allthemods.gravitas2.registry.GregitasRegistry.GREGITAS_REGISTRATE;

@SuppressWarnings("removal")
public class GregitasBlocks {

    @SuppressWarnings("unchecked")
    public static final BlockEntry<PressurePipeBlock>[] PRESSURE_PIPE_BLOCKS = new BlockEntry[PressurePipeType.values().length];

    private static void generatePressurePipeBlocks() {
        for (int i = 0; i < PressurePipeType.values().length; ++i) {
            var type = PressurePipeType.values()[i];
            PRESSURE_PIPE_BLOCKS[i] = GREGITAS_REGISTRATE.block("%s_pipe".formatted(type.getSerializedName()), (p) -> new PressurePipeBlock(p, type))
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .properties(p -> p.dynamicShape().noOcclusion())
                    .blockstate(NonNullBiConsumer.noop())
                    .addLayer(() -> RenderType::cutoutMipped)
                    .item(PressurePipeBlockItem::new)
                    .model(NonNullBiConsumer.noop())
                    .build()
                    .register();
        }
    }

    public static void init() {
        generatePressurePipeBlocks();
    }
}
