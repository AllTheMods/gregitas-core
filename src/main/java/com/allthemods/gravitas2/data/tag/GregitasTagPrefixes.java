package com.allthemods.gravitas2.data.tag;

import com.allthemods.gravitas2.core.mixin.TagPrefixOreTypeAccessor;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class GregitasTagPrefixes {

    public static final TagPrefix oreGabbro = TagPrefix.oreTagPrefix("gabbro", BlockTags.MINEABLE_WITH_PICKAXE)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Gabbro, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/gabbro"));

    public static final TagPrefix oreShale = TagPrefix.oreTagPrefix("shale", BlockTags.MINEABLE_WITH_PICKAXE)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.SHALE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Shale, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/shale"));

    public static final TagPrefix oreClaystone = TagPrefix.oreTagPrefix("claystone", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Claystone %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CLAYSTONE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Claystone, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/claystone"));

    public static final TagPrefix oreLimestone = TagPrefix.oreTagPrefix("limestone", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Limestone %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.LIMESTONE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Limestone, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/limestone"));

    public static final TagPrefix oreConglomerate = TagPrefix.oreTagPrefix("conglomerate", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Conglomerate %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CONGLOMERATE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Conglomerate, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/conglomerate"));

    public static final TagPrefix oreDolomite = TagPrefix.oreTagPrefix("dolomite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Dolomite %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.DOLOMITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Dolomite, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/dolomite"));

    public static final TagPrefix oreChert = TagPrefix.oreTagPrefix("chert", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Chert %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CHERT).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Chert, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/chert"));

    public static final TagPrefix oreChalk = TagPrefix.oreTagPrefix("chalk", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Chalk %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CHALK).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Chalk, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/chalk"));

    public static final TagPrefix oreRhyolite = TagPrefix.oreTagPrefix("rhyolite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Rhyolite %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Rhyolite, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/rhyolite"));

    public static final TagPrefix oreDacite = TagPrefix.oreTagPrefix("dacite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Dacite %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Dacite, BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/dacite"));

    public static final TagPrefix oreQuartzite = TagPrefix.oreTagPrefix("quartzite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Quartzite %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.QUARTZITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GTMaterials.Quartzite, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/quartzite"));

    public static final TagPrefix oreSlate = TagPrefix.oreTagPrefix("slate", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Slate %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.SLATE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Slate, BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/slate"));

    public static final TagPrefix orePhyllite = TagPrefix.oreTagPrefix("phyllite", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Phyllite %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.PHYLLITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Phyllite, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/phyllite"));

    public static final TagPrefix oreSchist = TagPrefix.oreTagPrefix("schist", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Schist %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.SCHIST).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Schist, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/schist"));

    public static final TagPrefix oreGneiss = TagPrefix.oreTagPrefix("gneiss", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Gneiss %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.GNEISS).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GregitasMaterials.Gneiss, BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/gneiss"));

    public static final TagPrefix oreMarble = TagPrefix.oreTagPrefix("marble", BlockTags.MINEABLE_WITH_PICKAXE)
            .langValue("Marble %s Ore")
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.MARBLE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), () -> GTMaterials.Marble, BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.STONE).strength(6.5F, 10.0F).requiresCorrectToolForDrops(), new ResourceLocation("tfc", "block/rock/raw/marble"));

    // nope, it works. IntelliJ doesn't know what it's talking about.
    @SuppressWarnings("DataFlowIssue")
    public static void init() {
        //TagPrefix.ORES.remove(TagPrefix.oreDeepslate);
        TagPrefix.ORES.remove(TagPrefix.oreTuff);
        TagPrefix.ORES.remove(TagPrefix.oreSand);
        TagPrefix.ORES.remove(TagPrefix.oreRedSand);
        TagPrefix.ORES.remove(TagPrefix.oreGravel);

        // Replace some ore prefix values, to: 1: make basalt not a nether ore, 2: make the base stones be TFC stones instead of vanilla.
        TagPrefixOreTypeAccessor oreBasaltAccessor = (TagPrefixOreTypeAccessor)(Object)TagPrefix.ORES.get(TagPrefix.oreBasalt);
        oreBasaltAccessor.setIsNether(false);

        TagPrefixOreTypeAccessor oreGraniteAccessor = (TagPrefixOreTypeAccessor)(Object)TagPrefix.ORES.get(TagPrefix.oreGranite);
        oreGraniteAccessor.setStoneType(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState());
    }
}
