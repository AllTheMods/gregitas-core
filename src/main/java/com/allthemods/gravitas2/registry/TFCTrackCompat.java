package com.allthemods.gravitas2.registry;

import com.allthemods.gravitas2.util.GregitasUtil;
import com.railwayteam.railways.Railways;
import com.railwayteam.railways.compat.tracks.GenericTrackCompat;
import net.minecraft.resources.ResourceLocation;

public class TFCTrackCompat extends GenericTrackCompat {
    TFCTrackCompat() {
        super("tfc");
    }

    @Override
    protected boolean registerTracksAnyway() {
        return super.registerTracksAnyway() || GregitasUtil.RailwaysTFC.isLoaded;
    }

    @Override
    protected ResourceLocation getSlabLocation(String name) {
        return asResource("wood/planks/" + name + "_slab");
    }

    private static boolean registered = false;
    public static void register() {
        if (registered) {
            Railways.LOGGER.error("Duplicate registration of TerraFirmaCraft track compat");
            return;
        }
        registered = true;
        Railways.LOGGER.info("Registering tracks for TerraFirmaCraft");
        new TFCTrackCompat().register(
                "acacia", "ash", "aspen", "birch", "blackwood",
                "chestnut", "douglas_fir", "hickory", "kapok", "mangrove",
                "maple", "oak", "palm", "pine", "rosewood",
                "sequoia", "spruce", "sycamore", "white_cedar", "willow"
        );
    }
}