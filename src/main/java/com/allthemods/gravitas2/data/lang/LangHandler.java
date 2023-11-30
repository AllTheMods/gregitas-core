package com.allthemods.gravitas2.data.lang;

import com.allthemods.gravitas2.data.tag.GregitasTagPrefixes;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {

    public static void init(RegistrateLangProvider provider) {

        // GUI text
        provider.add("gregitas_core.multiblock.blast_furnace.temperature", "Current Temperature: %sK");


        // Tag Prefixes
        provider.add(GregitasTagPrefixes.oreGabbro.getUnlocalizedName(), GregitasTagPrefixes.oreGabbro.langValue());
        provider.add(GregitasTagPrefixes.oreShale.getUnlocalizedName(), GregitasTagPrefixes.oreShale.langValue());
        provider.add(GregitasTagPrefixes.oreClaystone.getUnlocalizedName(), GregitasTagPrefixes.oreClaystone.langValue());
        provider.add(GregitasTagPrefixes.oreLimestone.getUnlocalizedName(), GregitasTagPrefixes.oreLimestone.langValue());
        provider.add(GregitasTagPrefixes.oreConglomerate.getUnlocalizedName(), GregitasTagPrefixes.oreConglomerate.langValue());
        provider.add(GregitasTagPrefixes.oreDolomite.getUnlocalizedName(), GregitasTagPrefixes.oreDolomite.langValue());
        provider.add(GregitasTagPrefixes.oreChert.getUnlocalizedName(), GregitasTagPrefixes.oreChert.langValue());
        provider.add(GregitasTagPrefixes.oreChalk.getUnlocalizedName(), GregitasTagPrefixes.oreChalk.langValue());
        provider.add(GregitasTagPrefixes.oreRhyolite.getUnlocalizedName(), GregitasTagPrefixes.oreRhyolite.langValue());
        provider.add(GregitasTagPrefixes.oreDacite.getUnlocalizedName(), GregitasTagPrefixes.oreDacite.langValue());
        provider.add(GregitasTagPrefixes.oreQuartzite.getUnlocalizedName(), GregitasTagPrefixes.oreQuartzite.langValue());
        provider.add(GregitasTagPrefixes.oreSlate.getUnlocalizedName(), GregitasTagPrefixes.oreSlate.langValue());
        provider.add(GregitasTagPrefixes.orePhyllite.getUnlocalizedName(), GregitasTagPrefixes.orePhyllite.langValue());
        provider.add(GregitasTagPrefixes.oreSchist.getUnlocalizedName(), GregitasTagPrefixes.oreSchist.langValue());
        provider.add(GregitasTagPrefixes.oreGneiss.getUnlocalizedName(), GregitasTagPrefixes.oreGneiss.langValue());
        provider.add(GregitasTagPrefixes.oreMarble.getUnlocalizedName(), GregitasTagPrefixes.oreMarble.langValue());

        // Materials
        provider.add(GregitasMaterials.Gabbro.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Gabbro.getName()));
        provider.add(GregitasMaterials.Shale.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Shale.getName()));
        provider.add(GregitasMaterials.Claystone.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Claystone.getName()));
        provider.add(GregitasMaterials.Limestone.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Limestone.getName()));
        provider.add(GregitasMaterials.Conglomerate.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Conglomerate.getName()));
        provider.add(GregitasMaterials.Dolomite.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Dolomite.getName()));
        provider.add(GregitasMaterials.Chert.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Chert.getName()));
        provider.add(GregitasMaterials.Chalk.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Chalk.getName()));
        provider.add(GregitasMaterials.Rhyolite.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Rhyolite.getName()));
        provider.add(GregitasMaterials.Dacite.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Dacite.getName()));
        provider.add(GregitasMaterials.Slate.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Slate.getName()));
        provider.add(GregitasMaterials.Phyllite.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Phyllite.getName()));
        provider.add(GregitasMaterials.Schist.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Schist.getName()));
        provider.add(GregitasMaterials.Gneiss.getUnlocalizedName(), FormattingUtil.toEnglishName(GregitasMaterials.Gneiss.getName()));
    }
}
