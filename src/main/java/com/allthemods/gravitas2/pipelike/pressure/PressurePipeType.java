package com.allthemods.gravitas2.pipelike.pressure;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.util.GregitasConstants;
import com.gregtechceu.gtceu.api.pipenet.IPipeType;
import lombok.Getter;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public enum PressurePipeType implements IPipeType<PressurePipeData>, StringRepresentable {
    LOW_VACUUM("low_vacuum", 0.125f, GregitasConstants.P[GregitasConstants.LV], GregitasConstants.EARTH_PRESSURE, 1.0D),
    MEDIUM_VACUUM("medium_vacuum", 0.25f, GregitasConstants.P[GregitasConstants.MV], GregitasConstants.EARTH_PRESSURE, 1.25D),
    HIGH_VACUUM("high_vacuum", 0.5f, GregitasConstants.P[GregitasConstants.HV], GregitasConstants.EARTH_PRESSURE, 1.5D),
    ULTRA_HIGH_VACUUM("ultra_high_vacuum", 0.625f, GregitasConstants.P[GregitasConstants.UHV], GregitasConstants.EARTH_PRESSURE, 2.0D),
    EXTREMELY_HIGH_VACUUM("extremely_high_vacuum", 0.75f, GregitasConstants.P[GregitasConstants.EHV], GregitasConstants.EARTH_PRESSURE, 3.0D),
    CLOSE_SPACE_VACUUM("close_space_vacuum", 0.825f, GregitasConstants.P[GregitasConstants.CSV], GregitasConstants.EARTH_PRESSURE, 5.0D),
    INTERGALACTIC_VOID_VACUUM("intergalactic_void_vacuum", 0.9f, GregitasConstants.P[GregitasConstants.IVV], GregitasConstants.EARTH_PRESSURE, 10.0D),
    LOW_PRESSURE("low_pressure", 0.75f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.LP], 1.0D),
    MEDIUM_PRESSURE("medium_pressure", 0.625f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.MP], 0.75D),
    HIGH_PRESSURE("high_pressure", 0.5f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.HP], 0.625D),
    ULTRA_HIGH_PRESSURE("ultra_high_pressure", 0.375f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.UHP], 0.5D),
    ELECTRON_DEGENERACY_PRESSURE("electron_degeneracy_pressure", 0.25f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.EDP], 0.025D),
    WHITE_DWARF_PRESSURE("white_dwarf_pressure", 0.125f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.WDP], 0.0125D),
    NEUTRON_STAR_PRESSURE("neutron_star_pressure", 0.05f, GregitasConstants.EARTH_PRESSURE, GregitasConstants.P[GregitasConstants.NSP], 0.001D);

    @Getter
    public final float thickness;
    @Getter
    public final String name;
    @Getter
    public final double maxPressure;
    @Getter
    private final double minPressure;
    @Getter
    private final double volume;

    public static final ResourceLocation TYPE_ID = GregitasCore.id("pressure");


    PressurePipeType(String name, float thickness, double minPressure, double maxPressure, double volume) {
        this.thickness = thickness;
        this.name = name;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.volume = volume;
    }

    @Nonnull
    @Override
    public PressurePipeData modifyProperties(PressurePipeData pipeData) {
        return new PressurePipeData(minPressure, maxPressure, volume, pipeData.connections);
    }

    @Override
    public boolean isPaintable() {
        return true;
    }

    @Override
    public ResourceLocation type() {
        return TYPE_ID;
    }

    @Override
    public String getSerializedName() {
        return name;
    }
}