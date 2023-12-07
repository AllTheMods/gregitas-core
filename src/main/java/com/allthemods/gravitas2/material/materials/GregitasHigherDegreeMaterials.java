package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GregitasHigherDegreeMaterials {

    public static void init() {
        Spacetime = GregitasMaterials.registerMaterial(
                new Material.Builder("spacetime")
                        .dust().fluid()
                        .color(0x5be3de).iconSet(MaterialIconSet.ROUGH)
                        .components(Space, 1, Time, 1)
        );


        UltraHighGradeHypogenSeparationAgent = GregitasMaterials.registerMaterial(
                new Material.Builder("ultra_high_grade_hypogen_separation_agent")
                        .fluid()
                        .colorAverage()
                        .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                        .components(Redstone, 8, StarMatter, 1, FluoroantimonicAcid, 2)
        );

        HypogenSolderCatalyst = GregitasMaterials.registerMaterial(
                new Material.Builder("hypogen_solder_catalyst")
                        .dust().fluid()
                        .colorAverage()
                        .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                        .components(SolderingAlloy, 4, Unobtainium, 4, Neutronium, 1)
        );

        SpacetimeReactionCatalyst = GregitasMaterials.registerMaterial(
                new Material.Builder("spacetime_reaction_catalyst")
                        .dust()
                        .color(0xf2b988)
                        .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                        .components(Spacetime, 2, StarMatter, 1, WeaponsGradeNaquadah, 1)
        );

        InfinityHypogenAlloy = GregitasMaterials.registerMaterial(
                new Material.Builder("infinity_hypogen_alloy")
                        .fluid().plasma()
                        .color(0xf2b988)
                        .flags(MaterialFlags.DISABLE_DECOMPOSITION)
                        .components(InfinityMatterPrecursor, 1, WeaponsGradeNaquadah, 1)
        );


        IgneousAlloy = GregitasMaterials.registerMaterial(
                new Material.Builder("igneous_alloy")
                        .fluid().dust()
                        .iconSet(MaterialIconSet.ROUGH)
                        .color(0x839689)
                        .components(Igneous, 1, Zinc, 1)
        );

    }
}
