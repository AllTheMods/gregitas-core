package com.allthemods.gravitas2.material.materials;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GregitasIGMaterials {

    public static void init() {
        GregitasMaterials.Zircon = new Material.Builder(GregitasCore.id("zircon"))
                .dust().ore()
                .color(0xa0c1e2).secondaryColor(0x749bc1).iconSet(MaterialIconSet.DULL)
                .components(Zirconium, 1, Silicon, 1, Oxygen, 4)
                .buildAndRegister()
                .setFormula("ZrSiO4", true);

        GregitasMaterials.Wolframite = new Material.Builder(GregitasCore.id("wolframite"))
                .dust().ore()
                .color(0x3B2A2A).secondaryColor(0x1A1212).iconSet(MaterialIconSet.DULL)
                .components(Iron, 1, Manganese, 1, Tungsten, 1, Oxygen, 4)
                .buildAndRegister()
                .setFormula("(Fe,Mn)WO4", true);

        GregitasMaterials.Smithsonite = new Material.Builder(GregitasCore.id("smithsonite"))
                .dust().ore()
                .color(0xC8C8A0).secondaryColor(0x8C8C6E).iconSet(MaterialIconSet.DULL)
                .components(Zinc, 1, Carbon, 1, Oxygen, 3)
                .buildAndRegister()
                .setFormula("ZnCO3", true);

        GregitasMaterials.Vanadinite = new Material.Builder(GregitasCore.id("vanadinite"))
                .dust().ore()
                .color(0xDB4100).secondaryColor(0x8B2900).iconSet(MaterialIconSet.DULL)
                .components(Lead, 5, Vanadium, 3, Oxygen, 12, Chlorine, 1)
                .buildAndRegister()
                .setFormula("Pb5(VO4)3Cl", true);

        GregitasMaterials.Millerite = new Material.Builder(GregitasCore.id("millerite"))
                .dust().ore()
                .color(0xB8B400).secondaryColor(0x7A7800).iconSet(MaterialIconSet.DULL)
                .components(Nickel, 1, Sulfur, 1)
                .buildAndRegister()
                .setFormula("NiS", true);

        GregitasMaterials.Acanthite = new Material.Builder(GregitasCore.id("acanthite"))
                .dust().ore()
                .color(0x6c9593).secondaryColor(0x577a78).iconSet(MaterialIconSet.DULL)
                .components(Silver, 2, Sulfur, 1)
                .buildAndRegister()
                .setFormula("Ag2S", true);

        GregitasMaterials.Cuprite = new Material.Builder(GregitasCore.id("cuprite"))
                .dust().ore()
                .color(0x8B0000).secondaryColor(0x4A0000).iconSet(MaterialIconSet.DULL)
                .components(Copper, 2, Oxygen, 1)
                .buildAndRegister()
                .setFormula("Cu2O", true);

        GregitasMaterials.Thorianite = new Material.Builder(GregitasCore.id("thorianite"))
                .dust().ore()
                .color(0x3D3D3D).secondaryColor(0x1E1E1E).iconSet(MaterialIconSet.DULL)
                .components(Thorium, 1, Oxygen, 2)
                .buildAndRegister()
                .setFormula("ThO2", true);

        GregitasMaterials.Thorite = new Material.Builder(GregitasCore.id("thorite"))
                .dust().ore()
                .color(0x4A3B2A).secondaryColor(0x261E15).iconSet(MaterialIconSet.DULL)
                .components(Thorium, 1, Silicon, 1, Oxygen, 4)
                .buildAndRegister()
                .setFormula("ThSiO4", true);

        GregitasMaterials.Anatase = new Material.Builder(GregitasCore.id("anatase"))
                .dust().ore()
                .color(0x8B7355).secondaryColor(0x4A3D2C).iconSet(MaterialIconSet.DULL)
                .components(Titanium, 1, Oxygen, 2)
                .buildAndRegister()
                .setFormula("TiO2", true);
    }
}
