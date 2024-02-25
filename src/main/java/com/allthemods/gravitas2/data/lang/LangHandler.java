package com.allthemods.gravitas2.data.lang;

import com.allthemods.gravitas2.data.tag.GregitasTagPrefixes;
import com.allthemods.gravitas2.material.GregitasMaterials;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler {

    public static void init(RegistrateLangProvider provider) {

        // GUI text
        provider.add("gregitas_core.multiblock.blast_furnace.temperature", "Current Temperature: %sK");
        provider.add("gregitas_core.recipe.cleanerroom.display_name", "Ultra-sterile Cleanroom");

        // messages
        provider.add("gregitas_core.message.enter_ally_area", "You entered an allied area owned by ");
        provider.add("gregitas_core.message.enter_area", "You entered an area owned by ");
        provider.add("gregitas_core.message.leave_area", "You left an area owned by ");
        provider.add("gregitas_core.coil_machine.warming_up", "Warming up machine...");

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
        provider.add(GregitasTagPrefixes.oreBasalt.getUnlocalizedName(), GregitasTagPrefixes.oreBasalt.langValue());
        provider.add(GregitasTagPrefixes.oreAndesite.getUnlocalizedName(), GregitasTagPrefixes.oreAndesite.langValue());
        provider.add(GregitasTagPrefixes.oreGranite.getUnlocalizedName(), GregitasTagPrefixes.oreGranite.langValue());
        provider.add(GregitasTagPrefixes.oreDiorite.getUnlocalizedName(), GregitasTagPrefixes.oreDiorite.langValue());
        // Materials
        //replace(provider, GregitasMaterials.AllTheModium.getUnlocalizedName(), "AllTheModium");
        //replace(provider, GregitasMaterials.AllthemodiumNaquadahMixture.getUnlocalizedName(), "AllTheModium-Naquadah Mixture");
    }
}
