package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.api.pattern.BlockPattern;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.dries007.tfc.common.capabilities.heat.Heat;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(value = GTMultiMachines.class, remap = false)
public abstract class GTMachinesMixin {

    @Inject(method = "lambda$static$6", at = @At("TAIL"))
    private static void gregitas$addEbfText(MultiblockMachineDefinition definition, CallbackInfoReturnable<BlockPattern> cir) {
        var controller = definition.get();

        if (controller instanceof IHeatBlock heatBlock) {
            Heat heat = Heat.getHeat(heatBlock.getTemperature());
            definition.setAdditionalDisplay((machine, textList ) -> {
                textList.add(Component.translatable("gregitas_core.multiblock.blast_furnace.temperature", Component.literal(FormattingUtil.formatNumbers((int) (heatBlock.getTemperature() + 273))).withStyle(heat != null ? heat.getColor() : ChatFormatting.DARK_GRAY)));
            });
        }
    }
}
