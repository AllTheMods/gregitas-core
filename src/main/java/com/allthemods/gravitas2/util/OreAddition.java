package com.allthemods.gravitas2.util;

import argent_matter.gcyr.GCYR;
import argent_matter.gcyr.common.worldgen.GCYRWorldGenLayers;
import argent_matter.gcyr.data.recipe.GCYRTags;
import com.gregtechceu.gtceu.api.data.worldgen.GTLayerPattern;
import com.gregtechceu.gtceu.api.data.worldgen.GTOreDefinition;
import com.gregtechceu.gtceu.api.data.worldgen.generator.indicators.SurfaceIndicatorGenerator;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import static argent_matter.gcyr.common.worldgen.GCYROres.MOON_RULES;

public class OreAddition {
    public static final GTOreDefinition TUNGSTATE_VEIN_MOON;
    public static final GTOreDefinition ZIRCON_VEIN_MOON;

    static {
        TUNGSTATE_VEIN_MOON = GTOres.create(GCYR.id("tungstate_vein_moon"), (vein) -> {
            vein.clusterSize(30).density(0.3F).weight(20).layer(GCYRWorldGenLayers.MOON).heightRangeUniform(10, 80).biomes(GCYRTags.IS_MOON).layeredVeinGenerator((generator) -> {
                generator.withLayerPattern(() -> {
                    return GTLayerPattern.builder(MOON_RULES).layer((l) -> {
                        l.weight(2).mat(GTMaterials.Scheelite).size(1, 2);
                    }).layer((l) -> {
                        l.weight(1).mat(GTMaterials.Bauxite).size(1, 2);
                    }).layer((l) -> {
                        l.weight(1).mat(GTMaterials.Tungstate).size(1, 1);
                    }).build();
                });
            }).surfaceIndicatorGenerator((indicator) -> {
                indicator.surfaceRock(GTMaterials.Scheelite).placement(SurfaceIndicatorGenerator.IndicatorPlacement.ABOVE);
            });
        });

        ZIRCON_VEIN_MOON = GTOres.create(new ResourceLocation("gravitas2", "zircon_vein_moon"), (vein) -> {
            var poor   = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("immersivegeology", "minecraft_poor_ore_block_zircon_stone")).defaultBlockState();
            var normal = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("immersivegeology", "minecraft_normal_ore_block_zircon_stone")).defaultBlockState();
            var rich   = ForgeRegistries.BLOCKS.getValue(new ResourceLocation("immersivegeology", "minecraft_rich_ore_block_zircon_stone")).defaultBlockState();
            vein.clusterSize(20).density(0.4F).weight(20).layer(GCYRWorldGenLayers.MOON).heightRangeUniform(0, 60).biomes(GCYRTags.IS_MOON).layeredVeinGenerator((generator) -> {
                generator.withLayerPattern(() -> {
                    return GTLayerPattern.builder(MOON_RULES).layer((l) -> {
                        l.weight(2).state(poor).size(1, 2);
                    }).layer((l) -> {
                        l.weight(3).state(normal).size(1, 2);
                    }).layer((l) -> {
                        l.weight(4).state(rich).size(1, 1);
                    }).build();
                });
            });
        });
    }
    public static void init() {}

}
