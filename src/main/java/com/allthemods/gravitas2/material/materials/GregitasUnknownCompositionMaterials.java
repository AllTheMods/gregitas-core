package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;

public class GregitasUnknownCompositionMaterials {

    public static void init() {
        Gabbro = GregitasMaterials.registerMaterial(
                new Material.Builder("gabbro")
                        .dust()
                        .color(0x4C4C4C).secondaryColor(0x707159).iconSet(MaterialIconSet.ROUGH)
        );

        Shale = GregitasMaterials.registerMaterial(
                new Material.Builder("shale")
                        .dust()
                        .color(0x383838).secondaryColor(0x4C4C4C).iconSet(MaterialIconSet.ROUGH)
        );

        Claystone = GregitasMaterials.registerMaterial(
                new Material.Builder("claystone")
                        .dust()
                        .color(0xBA8524).secondaryColor(0x707159).iconSet(MaterialIconSet.FINE)
        );

        Limestone = GregitasMaterials.registerMaterial(
                new Material.Builder("limestone")
                        .dust()
                        .color(0xcacac9).secondaryColor(0xD1B1A1).iconSet(MaterialIconSet.FINE)
        );

        Conglomerate = GregitasMaterials.registerMaterial(
                new Material.Builder("conglomerate")
                        .dust()
                        .color(0x876B62).secondaryColor(0x6a7451)
        );

        Dolomite = GregitasMaterials.registerMaterial(
                new Material.Builder("dolomite")
                        .dust()
                        .color(0x4C4C4C).secondaryColor(0x383838)
        );

        Chert = GregitasMaterials.registerMaterial(
                new Material.Builder("chert")
                        .dust()
                        .color(0x9F5224).secondaryColor(0xd7c48c)
        );

        Chalk = GregitasMaterials.registerMaterial(
                new Material.Builder("chalk")
                        .dust()
                        .color(0xFFFCF5).secondaryColor(0xcacac9)
        );

        Rhyolite = GregitasMaterials.registerMaterial(
                new Material.Builder("rhyolite")
                        .dust()
                        .color(0x876B62).secondaryColor(0x7d6354)
        );

        Dacite = GregitasMaterials.registerMaterial(
                new Material.Builder("dacite")
                        .dust()
                        .color(0x707070).secondaryColor(0x7d6354)
        );

        Slate = GregitasMaterials.registerMaterial(
                new Material.Builder("slate")
                        .dust()
                        .color(0x8F7748).secondaryColor(0x707159)
        );

        Phyllite = GregitasMaterials.registerMaterial(
                new Material.Builder("phyllite")
                        .dust()
                        .color(0x706C8A).secondaryColor(0x707159)
        );

        Schist = GregitasMaterials.registerMaterial(
                new Material.Builder("schist")
                        .dust()
                        .color(0x677535).secondaryColor(0x6a7451)
        );

        Gneiss = GregitasMaterials.registerMaterial(
                new Material.Builder("gneiss")
                        .dust()
                        .color(0x876B62).secondaryColor(0x6a7451)
        );


        Space = GregitasMaterials.registerMaterial(
                new Material.Builder("space")
                        .dust()
                        .color(0x2e213b).iconSet(MaterialIconSet.SHINY)
        );

        TraceMinerals = GregitasMaterials.registerMaterial(
                new Material.Builder("trace_minerals")
                        .dust()
                        .color(0x537854).iconSet(MaterialIconSet.ROUGH)
        );

        ExtraterrestialMaterials = GregitasMaterials.registerMaterial(
                new Material.Builder("extraterrestial_materials")
                        .dust()
                        .color(0x5be3de).iconSet(MaterialIconSet.ROUGH)
        );

        StarMatter = GregitasMaterials.registerMaterial(
                new Material.Builder("star_matter")
                        .fluid()
                        .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().state(FluidState.PLASMA).customStill())
                        .color(0xb219d1)
        );

        RawHypogen = GregitasMaterials.registerMaterial(
                new Material.Builder("raw_hypogen")
                        .fluid()
                        .color(0xab6527)
        );

        DirtyHypogen = GregitasMaterials.registerMaterial(
                new Material.Builder("dirty_hypogen")
                        .fluid()
                        .color(0xc9893a)
        );

        DirtyHypogenSolution = GregitasMaterials.registerMaterial(
                new Material.Builder("dirty_hypogen_solution")
                        .fluid()
                        .color(0xc9b63a)
        );

        PurifiedHypogenSolution = GregitasMaterials.registerMaterial(
                new Material.Builder("purified_hypogen_solution")
                        .fluid()
                        .color(0xe39714)
        );

        ImpureHypogenSolution = GregitasMaterials.registerMaterial(
                new Material.Builder("impure_hypogen_solution")
                        .fluid()
                        .color(0xe69e10)
        );

        AcidicPurifiedHypogenSolution = GregitasMaterials.registerMaterial(
                new Material.Builder("acidic_purified_hypogen_solution")
                        .fluid()
                        .color(0xed7e1c)
        );

        AcidicImpureHypogenSolution = GregitasMaterials.registerMaterial(
                new Material.Builder("acidic_impure_hypogen_solution")
                        .fluid()
                        .color(0xeda71c)
        );

        WeaponsGradeHypogenSolution = GregitasMaterials.registerMaterial(
                new Material.Builder("weapons_grade_hypogen_solution")
                        .fluid()
                        .color(0xe33714)
        );

        PurifiedHypogenWaste = GregitasMaterials.registerMaterial(
                new Material.Builder("purified_hypogen_waste")
                        .fluid()
                        .color(0xede20c)
        );

        ImpureHypogenWaste = GregitasMaterials.registerMaterial(
                new Material.Builder("impure_hypogen_waste")
                        .fluid()
                        .color(0xd8ed1c)
        );


        InfinityMatterPrecursor = GregitasMaterials.registerMaterial(
                new Material.Builder("infinity_matter_precursor")
                        .fluid()
                        .color(0xe39e14)
        );

        ImpureInfinityMatter = GregitasMaterials.registerMaterial(
                new Material.Builder("impure_infinity_matter")
                        .plasma()
                        .color(0xdcebbe)
        );

        ReactiveInfinityMatter = GregitasMaterials.registerMaterial(
                new Material.Builder("reactive_infinity_matter")
                        .fluid()
                        .color(0xbeebe0)
        );

        SpacetimeJunk = GregitasMaterials.registerMaterial(
                new Material.Builder("spacetime_junk")
                        .dust()
                        .color(0x734b6c)
        );

        Igneous = GregitasMaterials.registerMaterial(
                new Material.Builder("igneous")
                        .dust()
                        .color(0xbebebe)
        );

        BioMedium = GregitasMaterials.registerMaterial(
                new Material.Builder("bio_medium")
                        .fluid()
                        .color(0xb5ba54)
        );

    }
}
