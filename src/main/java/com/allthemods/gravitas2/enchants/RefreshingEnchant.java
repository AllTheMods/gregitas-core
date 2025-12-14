package com.allthemods.gravitas2.enchants;


import com.allthemods.gravitas2.GregitasCore;
import com.lumintorious.tfcambiental.capability.TemperatureCapability;
import com.lumintorious.tfcambiental.modifier.TempModifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class RefreshingEnchant extends MobEffect {


    protected RefreshingEnchant(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void applyEffectTick(@SuppressWarnings("null") net.minecraft.world.entity.@NotNull LivingEntity entity, int amplifier) {
          entity.getCapability(TemperatureCapability.CAPABILITY).ifPresent(temperatureCapability -> {
              float currentTemp = temperatureCapability.getTemperature();
              temperatureCapability.setTemperature(10.0f);
              temperatureCapability.update();
              temperatureCapability.setPlayer((Player) entity);

          });

    }

   @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {
           this.applyEffectTick(livingEntity, amplifier);
    }
}
