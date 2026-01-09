package com.allthemods.gravitas2.material;

import com.allthemods.gravitas2.compat.G2PropertyKey;
import com.allthemods.gravitas2.compat.TFCProperty;
import com.allthemods.gravitas2.material.materials.GregitasElementMaterials;
import com.allthemods.gravitas2.material.materials.GregitasFirstDegreeMaterials;
import com.allthemods.gravitas2.material.materials.GregitasHigherDegreeMaterials;
import com.allthemods.gravitas2.material.materials.GregitasUnknownCompositionMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.DustProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IMaterialProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.MaterialProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialStack;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.world.level.block.Blocks;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public class GregitasMaterials {

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
    public static Material WroughtIronMagnetic;
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
    public static Material Sculk;
    //endregion

    //region higher degree
    public static Material UltraHighGradeHypogenSeparationAgent;
    public static Material HypogenSolderCatalyst;
    public static Material SpacetimeReactionCatalyst;
    //endregion

    public static void init() {
        GregitasElementMaterials.init();
        GregitasFirstDegreeMaterials.init();
        GregitasUnknownCompositionMaterials.init();
        GregitasHigherDegreeMaterials.init();
    }

    public static void modify() {
        GTMaterials.Bismuth.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD);
        GTMaterials.Nickel.addFlags(MaterialFlags.GENERATE_PLATE, MaterialFlags.GENERATE_ROD);
        GTMaterials.Astatine.setProperty(PropertyKey.DUST, new DustProperty());
        GTMaterials.WroughtIron.addFlags(MaterialFlags.GENERATE_ROTOR, MaterialFlags.GENERATE_RING);
        GTMaterials.BlackBronze.addFlags(MaterialFlags.GENERATE_RING);
        GTMaterials.BismuthBronze.addFlags(MaterialFlags.GENERATE_RING);
        GTMaterials.RedSteel.addFlags(MaterialFlags.GENERATE_RING);
        GTMaterials.BlueSteel.addFlags(MaterialFlags.GENERATE_RING);
        GTMaterials.BlackSteel.addFlags(MaterialFlags.GENERATE_RING);

        GTMaterials.CertusQuartz.setComponents(new MaterialStack(Certus, 1), new MaterialStack(GTMaterials.Oxygen, 2));

        GTMaterials.HastelloyC276.addFlags(MaterialFlags.GENERATE_BOLT_SCREW);

        TagPrefix.rock.setIgnored(Gabbro);
        TagPrefix.rock.setIgnored(Shale);
        TagPrefix.rock.setIgnored(Claystone);
        TagPrefix.rock.setIgnored(Limestone);
        TagPrefix.rock.setIgnored(Conglomerate);
        TagPrefix.rock.setIgnored(Dolomite);
        TagPrefix.rock.setIgnored(Chert);
        TagPrefix.rock.setIgnored(Chalk);
        TagPrefix.rock.setIgnored(Rhyolite);
        TagPrefix.rock.setIgnored(Dacite);
        TagPrefix.rock.setIgnored(Slate);
        TagPrefix.rock.setIgnored(Phyllite);
        TagPrefix.rock.setIgnored(Schist);
        TagPrefix.rock.setIgnored(Gneiss);

        TagPrefix.block.setIgnored(Sculk, Blocks.SCULK);
        TagPrefix.plate.setIgnored(Sculk, Blocks.SCULK_VEIN);

        TagPrefix.block.modifyMaterialAmount(Sculk, 1);
        TagPrefix.plate.modifyMaterialAmount(Sculk, 1 / 4f);

        GTMaterials.WroughtIron.getProperty(PropertyKey.INGOT).setMagneticMaterial(WroughtIronMagnetic);

        GTMaterials.NeodymiumMagnetic.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(1083, 1444, 1805, GTMaterials.Neodymium, 3));
        GTMaterials.Neodymium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(1083, 1444, 1805, GTMaterials.Neodymium,1));
        GTMaterials.IronMagnetic.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3));
        GTMaterials.Copper.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(648, 864, 1080, 1));
        GTMaterials.BismuthBronze.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(591, 788, 985, 2));
        GTMaterials.Bronze.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(570, 760, 950, 2));
        GTMaterials.BlackBronze.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(642, 856, 1070, 2));
        GTMaterials.WroughtIron.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3));
        GTMaterials.Steel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(924, 1232, 1540, 4));
        GTMaterials.BlackSteel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(891, 1188, 1485, 5));
        GTMaterials.BlueSteel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(924, 1232, 1540, 6));
        GTMaterials.RedSteel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(924, 1232, 1540, 6));

        GTMaterials.Gold.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(636, 848, 1060, 1));
        GTMaterials.Bismuth.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(162, 216, 270, 1));
        GTMaterials.Brass.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(558, 744, 930, 2));
        GTMaterials.Nickel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(872, 1162, 1453, 1));
        GTMaterials.RoseGold.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(576, 768, 960, 1));
        GTMaterials.Silver.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(577, 769, 961, 1));
        GTMaterials.Tin.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 230, 1));
        GTMaterials.Zinc.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(252, 336, 420, 1));
        GTMaterials.SterlingSilver.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(570, 760, 950, 1));
        GTMaterials.Iron.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3));

        GTMaterials.Hematite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));
        GTMaterials.YellowLimonite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));
        GTMaterials.Magnetite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));
        GTMaterials.Pyrite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));
        GTMaterials.Goethite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));
        GTMaterials.BasalticMineralSand.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));
        GTMaterials.GraniticMineralSand.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(921, 1228, 1535, GTMaterials.Iron, 3, 90));

        GTMaterials.Malachite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1080, GTMaterials.Copper, 1, 90));
        GTMaterials.Tetrahedrite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1080, GTMaterials.Copper, 1, 90));
        GTMaterials.Chalcopyrite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1080, GTMaterials.Copper, 1, 85));
        GTMaterials.Chalcocite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1080, GTMaterials.Copper, 1, 95));
        GTMaterials.Bornite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1080, GTMaterials.Copper, 1, 90));

        GTMaterials.Cassiterite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(648, 864, 230, GTMaterials.Tin, 1, 100));
        GTMaterials.CassiteriteSand.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 230, GTMaterials.Tin, 1, 85));
        GTMaterials.Sphalerite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 420, GTMaterials.Zinc, 1, 90));
        GTMaterials.Garnierite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1453, GTMaterials.Nickel, 1, 100));
        GTMaterials.Pentlandite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(138, 184, 1453, GTMaterials.Nickel, 1, 85));

        GTMaterials.Redstone.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(240, 320, 460, 1));
        GTMaterials.RedAlloy.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(570, 650, 740, 2));
        GTMaterials.TinAlloy.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(1000, 1100, 1250, 3));
        GTMaterials.Lead.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(330 * 0.6), (int)(330 * 0.8), 330, 2));
        GTMaterials.Galena.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(330 * 0.6), (int)(330 * 0.8), 330, GTMaterials.Lead, 2, 85));
        GTMaterials.Invar.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(1494 * 0.6), (int)(1494 * 0.8), 1494, 3));
        GTMaterials.Potin.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(807 * 0.6), (int)(807 * 0.8), 807, 2));
        GTMaterials.Cobalt.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(1495 * 0.6), (int)(1495 * 0.8), 1495, 3));
        GTMaterials.Cobaltite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(1495 * 0.6), (int)(1495 * 0.8), 1495, GTMaterials.Cobalt, 3, 85));
        GTMaterials.CobaltOxide.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(1495 * 0.6), (int)(1495 * 0.8), 1495, GTMaterials.Cobalt, 3));
        GTMaterials.CobaltBrass.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty((int)(1060 * 0.6), (int)(1060 * 0.8), 1060, 3));

        GTMaterials.Electrum.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(600,800,1000,1));
        GTMaterials.VanadiumSteel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.AnnealedCopper.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(600,800,1000,1));
        GTMaterials.VanadiumGallium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(600,800,1000,1));
        GTMaterials.NickelZincFerrite.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(600,800,1000,1));
        GTMaterials.Aluminium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.StainlessSteel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Kanthal.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Nichrome.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.ManganesePhosphide.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.MagnesiumDiboride.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.MercuryBariumCalciumCuprate.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Tungsten.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.TungstenSteel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.UraniumTriplatinum.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Cupronickel.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));

        GTMaterials.Tantalum.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Gallium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Palladium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Ruthenium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Rhodium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Iridium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Osmium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Ultimet.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.BlueAlloy.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.SamariumIronArsenicOxide.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.HSSG.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.HSSE.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.HSSS.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Titanium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.RhodiumPlatedPalladium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.NiobiumTitanium.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));

        GTMaterials.Platinum.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Manganese.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Antimony.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GTMaterials.Molybdenum.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));
        GregitasMaterials.IgneousAlloy.setProperty(G2PropertyKey.TFC_PROPERTY, new TFCProperty(800,1000,1200,1));

    }
}
