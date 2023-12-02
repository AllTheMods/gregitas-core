package com.allthemods.gravitas2.material;


import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

@SuppressWarnings("unused")
public class GregitasMaterials {

    // random stuff
    public static final Material KaolinClay = new Material.Builder("kaolin_clay")
            .dust()
            .color(0xba997b).secondaryColor(0x876a50).iconSet(MaterialIconSet.FINE)
            .components(Aluminium, 2, Silicon, 2, Oxygen, 9, Hydrogen, 4)
            .buildAndRegister()
            .setFormula("Al2Si2O5(OH)4", true);

    // ore stone dusts
    public static final Material Gabbro = new Material.Builder("gabbro")
            .dust()
            .color(0x4C4C4C).secondaryColor(0x707159).iconSet(MaterialIconSet.ROUGH)
            .components(Calcium, 2, Manganese, 1, Silicon, 4, Aluminium, 6, Oxygen, 14)
            .buildAndRegister()
            .setFormula("(CaMn(SiAl2)2O6)(CaAl2Si2O8)", true);

    public static final Material Shale = new Material.Builder("shale")
            .dust()
            .color(0x383838).secondaryColor(0x4C4C4C).iconSet(MaterialIconSet.ROUGH)
            .components(KaolinClay, 3, NetherQuartz, 1, Calcite, 1)
            .buildAndRegister();

    public static final Material Claystone = new Material.Builder("claystone")
            .dust()
            .color(0xBA8524).secondaryColor(0x707159).iconSet(MaterialIconSet.FINE)
            .components(Clay, 2, KaolinClay, 2, Iron, 1, Potassium, 1)
            .buildAndRegister();

    public static final Material Limestone = new Material.Builder("limestone")
            .dust()
            .color(0xcacac9).secondaryColor(0xD1B1A1).iconSet(MaterialIconSet.FINE)
            .components(Calcium, 1, Carbon, 1, Oxygen, 3)
            .buildAndRegister();

    public static final Material Conglomerate = new Material.Builder("conglomerate")
            .dust()
            .color(0x876B62).secondaryColor(0x6a7451)
            .components(Limestone, 1, Silicon, 1, Oxygen, 4, Iron, 1)
            .buildAndRegister()
            .setFormula("(CaCO3)(SiO2)(FeO2)", true);

    public static final Material Dolomite = new Material.Builder("dolomite")
            .dust()
            .color(0x4C4C4C).secondaryColor(0x383838)
            .components(Calcium, 1, Magnesium, 1, Carbon, 2, Oxygen, 6)
            .buildAndRegister()
            .setFormula("CaMg(CO3)2", true);

    public static final Material Chert = new Material.Builder("chert")
            .dust()
            .color(0x9F5224).secondaryColor(0xd7c48c)
            .components(NetherQuartz, 1, Quartzite, 1)
            .buildAndRegister();

    public static final Material Chalk = new Material.Builder("chalk")
            .dust()
            .color(0xFFFCF5).secondaryColor(0xcacac9)
            .components(Limestone, 1)
            .buildAndRegister();

    public static final Material Rhyolite = new Material.Builder("rhyolite")
            .dust()
            .color(0x876B62).secondaryColor(0x7d6354)
            .components(NetherQuartz, 2, Calcium, 1, Aluminium, 2, Silicon, 2, Oxygen, 8)
            .buildAndRegister()
            .setFormula("(SiO2)(CaAl2SiO8)", true);

    public static final Material Dacite = new Material.Builder("dacite")
            .dust()
            .color(0x707070).secondaryColor(0x7d6354)
            .components(NetherQuartz, 2, Calcium, 1, Aluminium, 2, Silicon, 2, Oxygen, 8)
            .buildAndRegister();

    public static final Material Slate = new Material.Builder("slate")
            .dust()
            .color(0x8F7748).secondaryColor(0x707159)
            .components(Shale, 1)
            .buildAndRegister();

    public static final Material Phyllite = new Material.Builder("phyllite")
            .dust()
            .color(0x706C8A).secondaryColor(0x707159)
            .components(Graphite, 2, Mica, 1)
            .buildAndRegister();

    public static final Material Schist = new Material.Builder("schist")
            .dust()
            .color(0x677535).secondaryColor(0x6a7451)
            .components(Mica, 1, Talc, 1, Graphite, 1)
            .buildAndRegister();

    public static final Material Gneiss = new Material.Builder("gneiss")
            .dust()
            .color(0x876B62).secondaryColor(0x6a7451)
            .components(NetherQuartz, 2, Calcium, 1, Aluminium, 2, Silicon, 2, Oxygen, 8)
            .buildAndRegister()
            .setFormula("(SiO2)(CaAl2SiO8)", true);

    public static void init() {

    }
}
