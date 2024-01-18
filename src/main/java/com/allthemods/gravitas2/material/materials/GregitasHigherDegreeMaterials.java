package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.DECOMPOSITION_BY_CENTRIFUGING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags.NO_SMASHING;
import static com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet.ROUGH;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GregitasHigherDegreeMaterials {

    public static void init() {
        Spacetime = new Material.Builder(GregitasCore.id("spacetime"))
                .dust().fluid()
                .color(0x5be3de).iconSet(MaterialIconSet.ROUGH)
                .components(Space, 1, Time, 1)
                .buildAndRegister();


        UltraHighGradeHypogenSeparationAgent = new Material.Builder(GregitasCore.id("ultra_high_grade_hypogen_separation_agent"))
                .fluid()
                .colorAverage()
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(Redstone, 8, StarMatter, 1, FluoroantimonicAcid, 2)
                .buildAndRegister();

        HypogenSolderCatalyst = new Material.Builder(GregitasCore.id("hypogen_solder_catalyst"))
                .dust().fluid()
                .colorAverage()
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(SolderingAlloy, 4, Unobtainium, 4, Neutronium, 1)
                .buildAndRegister();

        SpacetimeReactionCatalyst = new Material.Builder(GregitasCore.id("spacetime_reaction_catalyst"))
                .dust()
                .color(0xf2b988)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(Spacetime, 2, StarMatter, 1, WeaponsGradeNaquadah, 1)
                .buildAndRegister();

        InfinityHypogenAlloy = new Material.Builder(GregitasCore.id("infinity_hypogen_alloy"))
                .fluid().plasma()
                .color(0xf2b988)
                .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                .components(InfinityMatterPrecursor, 1, WeaponsGradeNaquadah, 1)
                .buildAndRegister();


        IgneousAlloy = new Material.Builder(GregitasCore.id("igneous_alloy"))
                .fluid().dust()
                .iconSet(MaterialIconSet.ROUGH)
                .color(0x839689)
                .components(Igneous, 1, Zinc, 1)
                .buildAndRegister();

        Slate = new Material.Builder(GregitasCore.id("slate"))
                .dust()
                .color(0x8F7748).secondaryColor(0x707159).iconSet(ROUGH)
                .flags(NO_SMASHING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(SiliconDioxide, 4, Biotite, 1)
                .buildAndRegister();

    }
}
