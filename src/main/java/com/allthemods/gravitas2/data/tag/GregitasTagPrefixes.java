package com.allthemods.gravitas2.data.tag;

import com.allthemods.gravitas2.core.mixin.TagPrefixOreTypeAccessor;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconType;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.Conditions.hasOreProperty;

public class GregitasTagPrefixes {

    public static final TagPrefix oreGabbro = TagPrefix.oreTagPrefix("gabbro")
            .langValue("Gabbro %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.GABBRO.color());

    public static final TagPrefix oreShale = TagPrefix.oreTagPrefix("shale")
            .langValue("Shale %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.SHALE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.SHALE.color());

    public static final TagPrefix oreClaystone = TagPrefix.oreTagPrefix("claystone")
            .langValue("Claystone %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CLAYSTONE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.CLAYSTONE.color());

    public static final TagPrefix oreLimestone = TagPrefix.oreTagPrefix("limestone")
            .langValue("Limestone %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.LIMESTONE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.LIMESTONE.color());

    public static final TagPrefix oreConglomerate = TagPrefix.oreTagPrefix("conglomerate")
            .langValue("Conglomerate %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CONGLOMERATE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.CONGLOMERATE.color());

    public static final TagPrefix oreDolomite = TagPrefix.oreTagPrefix("dolomite")
            .langValue("Dolomite %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.DOLOMITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.DOLOMITE.color());

    public static final TagPrefix oreChert = TagPrefix.oreTagPrefix("chert")
            .langValue("Chert %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CHERT).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.CHERT.color());

    public static final TagPrefix oreChalk = TagPrefix.oreTagPrefix("chalk")
            .langValue("Shale %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.CHALK).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.CHALK.color());

    public static final TagPrefix oreRhyolite = TagPrefix.oreTagPrefix("rhyolite")
            .langValue("Rhyolite %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.RHYOLITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.RHYOLITE.color());

    public static final TagPrefix oreDacite = TagPrefix.oreTagPrefix("dacite")
            .langValue("Dacite %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.DACITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.DACITE.color());

    public static final TagPrefix oreQuartzite = TagPrefix.oreTagPrefix("quartzite")
            .langValue("Quartzite %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.QUARTZITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.QUARTZITE.color());

    public static final TagPrefix oreSlate = TagPrefix.oreTagPrefix("slate")
            .langValue("Slate %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.SLATE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.SLATE.color());

    public static final TagPrefix orePhyllite = TagPrefix.oreTagPrefix("phyllite")
            .langValue("Phyllite %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.PHYLLITE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.PHYLLITE.color());

    public static final TagPrefix oreSchist = TagPrefix.oreTagPrefix("schist")
            .langValue("Schist %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.SCHIST).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.SCHIST.color());

    public static final TagPrefix oreGneiss = TagPrefix.oreTagPrefix("gneiss")
            .langValue("Gneiss %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.GNEISS).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.GNEISS.color());

    public static final TagPrefix oreMarble = TagPrefix.oreTagPrefix("marble")
            .langValue("Marble %s Ore")
            .materialIconType(MaterialIconType.ore)
            .miningToolTag(BlockTags.MINEABLE_WITH_PICKAXE)
            .unificationEnabled(true)
            .generationCondition(hasOreProperty)
            .registerOre(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.MARBLE).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState(), false, Rock.MARBLE.color());

    public static void init() {
        //TagPrefix.ORES.remove(TagPrefix.oreDeepslate);
        TagPrefix.ORES.remove(TagPrefix.oreTuff);
        TagPrefix.ORES.remove(TagPrefix.oreSand);
        TagPrefix.ORES.remove(TagPrefix.oreRedSand);
        TagPrefix.ORES.remove(TagPrefix.oreGravel);
        TagPrefixOreTypeAccessor oreBasaltAccessor = (TagPrefixOreTypeAccessor)(Object)TagPrefix.ORES.get(TagPrefix.oreBasalt);
        // nope, it works. IntelliJ doesn't know what it's talking about.
        //noinspection DataFlowIssue
        oreBasaltAccessor.setIsNether(false);
        oreBasaltAccessor.setStoneType(() -> TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.RAW).orElse(Blocks.DEEPSLATE).defaultBlockState());
    }
}
