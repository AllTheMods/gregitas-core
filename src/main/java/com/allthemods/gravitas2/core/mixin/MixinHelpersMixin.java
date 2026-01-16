package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.core.MixinHelpers;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.dries007.tfc.common.TFCTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagEntry;
import net.minecraft.tags.TagLoader;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.block;

@Mixin(value = MixinHelpers.class, remap = false)
public class MixinHelpersMixin {

    @Inject(method = "lambda$generateGTDynamicTags$20", at = @At("HEAD"))
    private static void gregitas$addFallingTag(Map tagMap, MaterialEntry entry, List blocks, CallbackInfo ci) {

        entry.tagPrefix().getAllBlockTags(entry.material());
        if (TagPrefix.ORES.containsKey(entry.tagPrefix())) {
            tagMap.computeIfAbsent(TFCTags.Blocks.CAN_COLLAPSE.location(), $ -> new ArrayList<>().add(new TagLoader.EntryWithSource(TagEntry.element(entry.material().getResourceLocation()), GTValues.CUSTOM_TAG_SOURCE)));
            tagMap.computeIfAbsent(TFCTags.Blocks.CAN_START_COLLAPSE.location(), $ -> new ArrayList<>().add(new TagLoader.EntryWithSource(TagEntry.element(entry.material().getResourceLocation()), GTValues.CUSTOM_TAG_SOURCE)));
            tagMap.computeIfAbsent(TFCTags.Blocks.CAN_TRIGGER_COLLAPSE.location(), $ -> new ArrayList<>().add(new TagLoader.EntryWithSource(TagEntry.element(entry.material().getResourceLocation()), GTValues.CUSTOM_TAG_SOURCE)));
        }
    }
}
