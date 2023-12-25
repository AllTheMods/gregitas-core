package com.allthemods.gravitas2.material;

import com.allthemods.gravitas2.material.materials.*;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class GregitasMaterials {

    public static final Set<Material> GREGITAS_MATERIALS = new HashSet<>();

    //region element
    public static Material WeaponsGradeNaquadah;
    public static Material LowGradeHypogen;
    public static Material HighGradeHypogen;
    public static Material WeaponsGradeHypogen;
    public static Material InfinityMatter;
    public static Material Time;
    public static Material AllTheModium;
    public static Material Unobtainium;
    public static Material Certus;
    //endregion

    //region first degree
    public static Material KaolinClay;
    public static Material IgneousAlloy;
    public static Material AllthemodiumNaquadahMixture;
    public static Material Spacetime;
    public static Material InfinityHypogenAlloy;
    public static Material InfinityMatterSulfate;
    public static Material Nitinol;
    public static Material Trichlorocertane;
    public static Material Dichlorocertane;
    public static Material Chlorocertane;
    public static Material CertusTetrachloride;
    public static Material Certane;
    //endregion

    //region unknown composition
    public static Material Gabbro;
    public static Material Shale;
    public static Material Claystone;
    public static Material Limestone;
    public static Material Conglomerate;
    public static Material Dolomite;
    public static Material Chert;
    public static Material Chalk;
    public static Material Rhyolite;
    public static Material Dacite;
    public static Material Slate;
    public static Material Phyllite;
    public static Material Schist;
    public static Material Gneiss;

    public static Material Space;
    public static Material TraceMinerals;
    public static Material ExtraterrestialMaterials;
    public static Material StarMatter;
    public static Material RawHypogen;
    public static Material DirtyHypogen;
    public static Material DirtyHypogenSolution;
    public static Material PurifiedHypogenSolution;
    public static Material ImpureHypogenSolution;
    public static Material AcidicPurifiedHypogenSolution;
    public static Material AcidicImpureHypogenSolution;
    public static Material WeaponsGradeHypogenSolution;
    public static Material PurifiedHypogenWaste;
    public static Material ImpureHypogenWaste;
    public static Material InfinityMatterPrecursor;
    public static Material ImpureInfinityMatter;
    public static Material ReactiveInfinityMatter;
    public static Material SpacetimeJunk;
    public static Material Igneous;
    public static Material BioMedium;
    //endregion

    //region higher degree
    public static Material UltraHighGradeHypogenSeparationAgent;
    public static Material HypogenSolderCatalyst;
    public static Material SpacetimeReactionCatalyst;
    //endregion

    public static void init() {
        GTMaterials.Bismuth.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD);
        GTMaterials.Nickel.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD);
        GTMaterials.Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.Iodine.setProperty(PropertyKey.DUST, new DustProperty());

        GTMaterials.CertusQuartz.setFormula("CtO2", true);

        GTMaterials.HastelloyC276.addFlags(MaterialFlags.GENERATE_BOLT_SCREW);

        GregitasElementMaterials.init();
        GregitasFirstDegreeMaterials.init();
        GregitasUnknownCompositionMaterials.init();
        GregitasHigherDegreeMaterials.init();
    }

    public static Material registerMaterial(Material.Builder builder) {
        Material material = builder.buildAndRegister();
        GREGITAS_MATERIALS.add(material);
        return material;
    }
}
