package com.allthemods.gravitas2.enchants;

import com.allthemods.gravitas2.GregitasCore;
import com.lumintorious.tfcambiental.capability.TemperatureCapability;
import net.minecraft.world.effect.MobEffect;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class WarmingEnchant extends MobEffect {


    protected WarmingEnchant(MobEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public void applyEffectTick(@SuppressWarnings("null") net.minecraft.world.entity.@NotNull LivingEntity entity, int amplifier) {
        entity.getCapability(TemperatureCapability.CAPABILITY).ifPresent(temperatureCapability -> {
            float currentTemp = temperatureCapability.getTemperature();
            temperatureCapability.setTemperature(19.0f);
            temperatureCapability.update();
            temperatureCapability.setPlayer((Player) entity);

        });
    }
}
