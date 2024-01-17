package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.material.GregitasElements;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;

public class GregitasElementMaterials {

    public static void init() {
        WeaponsGradeNaquadah = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("weapons_grade_naquadah"))
                        .ingot(5).fluid()
                        .color(0x586357).iconSet(MaterialIconSet.DULL)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_FRAME)
                        .element(GregitasElements.WeaponsGradeNaquadah)
                        .blastTemp(8000, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.ZPM], 1500)
        );


        LowGradeHypogen = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("low_grade_hypogen"))
                        .ingot(5)
                        .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(16100))
                        .fluid(FluidStorageKeys.MOLTEN, FluidState.LIQUID)
                        .color(0xed6f15).secondaryColor(0xc98642).iconSet(MaterialIconSet.METALLIC)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD)
                        .element(GregitasElements.Hypogen422)
                        .blastTemp(10062, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UHV], 1800)
        );

        HighGradeHypogen = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("high_grade_hypogen"))
                        .ingot(5)
                        .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(16100))
                        .fluid(FluidStorageKeys.MOLTEN, FluidState.LIQUID)
                        .color(0xf55d00).secondaryColor(0xbf670d).iconSet(MaterialIconSet.METALLIC)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD)
                        .element(GregitasElements.Hypogen414)
                        .blastTemp(10062, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UHV], 1800)
        );

        WeaponsGradeHypogen = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("weapons_grade_hypogen"))
                        .ingot(6)
                        .fluid(FluidStorageKeys.LIQUID, new FluidBuilder().temperature(16100))
                        .fluid(FluidStorageKeys.MOLTEN, FluidState.LIQUID)
                        .color(0xf04f0a).secondaryColor(0xedad09).iconSet(MaterialIconSet.SHINY)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                        .element(GregitasElements.Hypogen403)
                        .blastTemp(10062, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 2200)
        );


        InfinityMatter = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("infinity_matter"))
                        .ingot(7).fluid()
                        .color(0xebf5eb).secondaryColor(0xf0d3ec).iconSet(MaterialIconSet.SHINY)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD, MaterialFlags.GENERATE_DENSE)
                        .element(GregitasElements.InfinityMatter)
        );

        Time = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("time"))
                        .element(GregitasElements.Time)
        );


        AllTheModium = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("allthemodium"))
                        .ingot(6).fluid()
                        .color(0xf5c414).secondaryColor(0xf2ac0a).iconSet(MaterialIconSet.SHINY)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                        .element(GregitasElements.AllTheModium)
                        .blastTemp(3000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.ZPM], 1800)
        );

        Unobtainium = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("unobtainium"))
                        .ingot(7).fluid()
                        .color(0xa62be0).secondaryColor(0x7d28a6).iconSet(MaterialIconSet.SHINY)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD, MaterialFlags.GENERATE_LONG_ROD)
                        .element(GregitasElements.Unobtainium)
                        .blastTemp(3000, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.UHV], 1800)
        );


        Certus = GregitasMaterials.registerMaterial(
                new Material.Builder(GregitasCore.id("certus"))
                        .gem()
                        .color(0xc5e3de).iconSet(MaterialIconSet.CERTUS)
                        .flags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD)
                        .element(GregitasElements.Certus)
        );

    }
}
