package com.allthemods.gravitas2.material;


import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

@SuppressWarnings("unused")
public class GregitasMaterials {

    public static final Material Gabbro = new Material.Builder("gabbro")
            .dust()
            .color(0x4C4C4C).secondaryColor(0x707159).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister();

    public static final Material Shale = new Material.Builder("shale")
            .dust()
            .color(0x383838).secondaryColor(0x4C4C4C).iconSet(MaterialIconSet.ROUGH)
            .buildAndRegister();

    public static final Material Claystone = new Material.Builder("claystone")
            .dust()
            .color(0xBA8524).secondaryColor(0x707159).iconSet(MaterialIconSet.FINE)
            .buildAndRegister();

    public static final Material Limestone = new Material.Builder("limestone")
            .dust()
            .color(0xcacac9).secondaryColor(0xD1B1A1).iconSet(MaterialIconSet.FINE)
            .buildAndRegister();

    public static final Material Conglomerate = new Material.Builder("conglomerate")
            .dust()
            .color(0x876B62).secondaryColor(0x6a7451)
            .buildAndRegister();

    public static final Material Dolomite = new Material.Builder("dolomite")
            .dust()
            .color(0x4C4C4C).secondaryColor(0x383838)
            .buildAndRegister();

    public static final Material Chert = new Material.Builder("chert")
            .dust()
            .color(0x9F5224).secondaryColor(0xd7c48c)
            .buildAndRegister();

    public static final Material Chalk = new Material.Builder("chalk")
            .dust()
            .color(0xFFFCF5).secondaryColor(0xcacac9)
            .buildAndRegister();

    public static final Material Rhyolite = new Material.Builder("rhyolite")
            .dust()
            .color(0x876B62).secondaryColor(0x7d6354)
            .buildAndRegister();

    public static final Material Dacite = new Material.Builder("dacite")
            .dust()
            .color(0x707070).secondaryColor(0x7d6354)
            .buildAndRegister();

    public static final Material Slate = new Material.Builder("slate")
            .dust()
            .color(0x8F7748).secondaryColor(0x707159)
            .buildAndRegister();

    public static final Material Phyllite = new Material.Builder("phyllite")
            .dust()
            .color(0x706C8A).secondaryColor(0x707159)
            .buildAndRegister();

    public static final Material Schist = new Material.Builder("schist")
            .dust()
            .color(0x677535).secondaryColor(0x6a7451)
            .buildAndRegister();

    public static final Material Gneiss = new Material.Builder("gneiss")
            .dust()
            .color(0x876B62).secondaryColor(0x6a7451)
            .buildAndRegister();

    public static void init() {

    }
}
