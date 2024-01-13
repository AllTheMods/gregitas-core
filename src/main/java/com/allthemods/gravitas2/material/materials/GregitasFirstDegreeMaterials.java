package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;

import static com.allthemods.gravitas2.material.GregitasMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GregitasFirstDegreeMaterials {

    public static void init() {
        KaolinClay = GregitasMaterials.registerMaterial(
                new Material.Builder("kaolin_clay")
                        .dust()
                        .color(0xba997b).secondaryColor(0x876a50).iconSet(MaterialIconSet.FINE)
                        .components(Aluminium, 2, Silicon, 2, Oxygen, 9, Hydrogen, 4)
        ).setFormula("Al2Si2O5(OH)4", true);

        AllthemodiumNaquadahMixture = GregitasMaterials.registerMaterial(
                new Material.Builder("allthemodium_naquadah_mixture")
                        .dust()
                        .color(0x5be3de).iconSet(MaterialIconSet.ROUGH)
                        .components(AllTheModium, 1, Naquadah, 4)
        );

        InfinityMatterSulfate = GregitasMaterials.registerMaterial(
                new Material.Builder("infinity_matter_sulfate")
                        .fluid()
                        .color(0xf2b988)
                        .components(InfinityMatter, 1, Sulfur, 1, Oxygen, 4)
        );


        Nitinol = GregitasMaterials.registerMaterial(
                new Material.Builder("nitinol")
                        .ingot().fluid()
                        .iconSet(MaterialIconSet.METALLIC)
                        .colorAverage()
                        .flags(MaterialFlags.GENERATE_PLATE)
                        .components(Nickel, 4, Titanium, 6)
                        .blastTemp(1583, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.IV], 1200)
        );


        Trichlorocertane = GregitasMaterials.registerMaterial(
                new Material.Builder("trichlorocertane")
                        .fluid()
                        .color(0xb1d9f0)
                        .components(Certus, 1, Hydrogen, 1, Chlorine, 3)
        );

        Dichlorocertane = GregitasMaterials.registerMaterial(
                new Material.Builder("dichlorocertane")
                        .fluid()
                        .color(0x90cfd1)
                        .components(Hydrogen, 2, Certus, 1, Chlorine, 2)
        );

        Chlorocertane = GregitasMaterials.registerMaterial(
                new Material.Builder("chlorocertane")
                        .fluid()
                        .color(0xccede3)
                        .components(Hydrogen, 3, Certus, 1, Chlorine, 1)
        );

        CertusTetrachloride = GregitasMaterials.registerMaterial(
                new Material.Builder("certus_tetrachloride")
                        .fluid()
                        .color(0xccede3)
                        .components(Certus, 1, Chlorine, 4)
        );

        Certane = GregitasMaterials.registerMaterial(
                new Material.Builder("certane")
                        .fluid()
                        .color(0xccede3)
                        .components(Certus, 1, Hydrogen, 4)
        );

        WroughtIronMagnetic = GregitasMaterials.registerMaterial(
                new Material.Builder("magnetic_wrought_iron")
                        .ingot()
                        .color(0xbcbcbc)
                        .secondaryColor(0x521c0b)
                        .iconSet(MaterialIconSet.MAGNETIC)
                        .components(Iron, 1)
                        .flags(MaterialFlags.GENERATE_ROD)
        );
    }
}
