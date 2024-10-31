package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.machine.feature.multiblock.IMultiController;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import net.dries007.tfc.common.capabilities.heat.Heat;
import net.dries007.tfc.common.capabilities.heat.IHeatBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = GTMachines.class, remap = false)
public abstract class GTMachinesMixin {

    @Inject(method = "lambda$static$127", at = @At("TAIL"))
    private static void gregitas$addEbfText(IMultiController controller, List<Component> textList, CallbackInfo ci) {
        if (controller instanceof IHeatBlock heatBlock && controller.isFormed()) {
            Heat heat = Heat.getHeat(heatBlock.getTemperature());
            textList.add(Component.translatable("gregitas_core.multiblock.blast_furnace.temperature", Component.literal(FormattingUtil.formatNumbers((int) (heatBlock.getTemperature() + 273))).withStyle(heat != null ? heat.getColor() : ChatFormatting.DARK_GRAY)));
        }
    }
}
