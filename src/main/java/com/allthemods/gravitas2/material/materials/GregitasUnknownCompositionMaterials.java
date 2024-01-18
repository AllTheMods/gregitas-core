package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.GregitasCore;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.fluids.FluidState;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;

public class GregitasUnknownCompositionMaterials {

    public static void init() {
        Gabbro = new Material.Builder(GregitasCore.id("gabbro"))
                .dust()
                .color(0x4C4C4C).secondaryColor(0x707159).iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        Shale = new Material.Builder(GregitasCore.id("shale"))
                .dust()
                .color(0x383838).secondaryColor(0x4C4C4C).iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        Claystone = new Material.Builder(GregitasCore.id("claystone"))
                .dust()
                .color(0xBA8524).secondaryColor(0x707159).iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        Limestone = new Material.Builder(GregitasCore.id("limestone"))
                .dust()
                .color(0xcacac9).secondaryColor(0xD1B1A1).iconSet(MaterialIconSet.FINE)
                .buildAndRegister();

        Conglomerate = new Material.Builder(GregitasCore.id("conglomerate"))
                .dust()
                .color(0x876B62).secondaryColor(0x6a7451)
                .buildAndRegister();

        Dolomite = new Material.Builder(GregitasCore.id("dolomite"))
                .dust()
                .color(0x4C4C4C).secondaryColor(0x383838)
                .buildAndRegister();

        Chert = new Material.Builder(GregitasCore.id("chert"))
                .dust()
                .color(0x9F5224).secondaryColor(0xd7c48c)
                .buildAndRegister();

        Chalk = new Material.Builder(GregitasCore.id("chalk"))
                .dust()
                .color(0xFFFCF5).secondaryColor(0xcacac9)
                .buildAndRegister();

        Rhyolite = new Material.Builder(GregitasCore.id("rhyolite"))
                .dust()
                .color(0x876B62).secondaryColor(0x7d6354)
                .buildAndRegister();

        Dacite = new Material.Builder(GregitasCore.id("dacite"))
                .dust()
                .color(0x707070).secondaryColor(0x7d6354)
                .buildAndRegister();

        Phyllite = new Material.Builder(GregitasCore.id("phyllite"))
                .dust()
                .color(0x706C8A).secondaryColor(0x707159).iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        Schist = new Material.Builder(GregitasCore.id("schist"))
                .dust()
                .color(0x677535).secondaryColor(0x6a7451)
                .buildAndRegister();

        Gneiss = new Material.Builder(GregitasCore.id("gneiss"))
                .dust()
                .color(0x876B62).secondaryColor(0x6a7451)
                .buildAndRegister();


        Space = new Material.Builder(GregitasCore.id("space"))
                .dust()
                .color(0x2e213b).iconSet(MaterialIconSet.SHINY)
                .buildAndRegister();

        TraceMinerals = new Material.Builder(GregitasCore.id("trace_minerals"))
                .dust()
                .color(0x537854).iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        ExtraterrestialMaterials = new Material.Builder(GregitasCore.id("extraterrestial_materials"))
                .dust()
                .color(0x5be3de).iconSet(MaterialIconSet.ROUGH)
                .buildAndRegister();

        StarMatter = new Material.Builder(GregitasCore.id("star_matter"))
                .fluid()
                .fluid(FluidStorageKeys.PLASMA, new FluidBuilder().state(FluidState.PLASMA).customStill())
                .color(0xb219d1)
                .buildAndRegister();

        RawHypogen = new Material.Builder(GregitasCore.id("raw_hypogen"))
                .fluid()
                .color(0xab6527)
                .buildAndRegister();

        DirtyHypogen = new Material.Builder(GregitasCore.id("dirty_hypogen"))
                .fluid()
                .color(0xc9893a)
                .buildAndRegister();

        DirtyHypogenSolution = new Material.Builder(GregitasCore.id("dirty_hypogen_solution"))
                .fluid()
                .color(0xc9b63a)
                .buildAndRegister();

        PurifiedHypogenSolution = new Material.Builder(GregitasCore.id("purified_hypogen_solution"))
                .fluid()
                .color(0xe39714)
                .buildAndRegister();

        ImpureHypogenSolution = new Material.Builder(GregitasCore.id("impure_hypogen_solution"))
                .fluid()
                .color(0xe69e10)
                .buildAndRegister();

        AcidicPurifiedHypogenSolution = new Material.Builder(GregitasCore.id("acidic_purified_hypogen_solution"))
                .fluid()
                .color(0xed7e1c)
                .buildAndRegister();

        AcidicImpureHypogenSolution = new Material.Builder(GregitasCore.id("acidic_impure_hypogen_solution"))
                .fluid()
                .color(0xeda71c)
                .buildAndRegister();

        WeaponsGradeHypogenSolution = new Material.Builder(GregitasCore.id("weapons_grade_hypogen_solution"))
                .fluid()
                .color(0xe33714)
                .buildAndRegister();

        PurifiedHypogenWaste = new Material.Builder(GregitasCore.id("purified_hypogen_waste"))
                .fluid()
                .color(0xede20c)
                .buildAndRegister();

        ImpureHypogenWaste = new Material.Builder(GregitasCore.id("impure_hypogen_waste"))
                .fluid()
                .color(0xd8ed1c)
                .buildAndRegister();


        InfinityMatterPrecursor = new Material.Builder(GregitasCore.id("infinity_matter_precursor"))
                .fluid()
                .color(0xe39e14)
                .buildAndRegister();

        ImpureInfinityMatter = new Material.Builder(GregitasCore.id("impure_infinity_matter"))
                .plasma()
                .color(0xdcebbe)
                .buildAndRegister();

        ReactiveInfinityMatter = new Material.Builder(GregitasCore.id("reactive_infinity_matter"))
                .fluid()
                .color(0xbeebe0)
                .buildAndRegister();

        SpacetimeJunk = new Material.Builder(GregitasCore.id("spacetime_junk"))
                .dust()
                .color(0x734b6c)
                .buildAndRegister();

        Igneous = new Material.Builder(GregitasCore.id("igneous"))
                .dust()
                .color(0xbebebe)
                .buildAndRegister();

        BioMedium = new Material.Builder(GregitasCore.id("bio_medium"))
                .fluid()
                .color(0xb5ba54)
                .buildAndRegister();

        Sculk = new Material.Builder(GregitasCore.id("sculk"))
                .fluid().dust()
                .color(0x111b21).secondaryColor(0x009295)
                .iconSet(MaterialIconSet.SHINY)
                .buildAndRegister();

    }
}
