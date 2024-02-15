package com.allthemods.gravitas2.core.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.simibubi.create.content.kinetics.waterwheel.WaterWheelRenderer;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.IForgeRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Optional;

@Mixin(WaterWheelRenderer.class)
public class MixinWaterWheelRenderer {
    @WrapOperation(
            method = "generateModel(Lnet/minecraft/client/resources/model/BakedModel;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/client/resources/model/BakedModel;",
            remap = false,
            at = @At(target = "Ljava/lang/String;endsWith(Ljava/lang/String;)Z", value = "INVOKE")
    )
    private static boolean gregitas$generateModelTFCCompatIfCheck(String instance, String suffix, Operation<Boolean> original) {
        return original.call(instance, suffix) || instance.contains("wood/planks/");
    }

    @WrapOperation(
            method = "generateModel(Lnet/minecraft/client/resources/model/BakedModel;Lnet/minecraft/world/level/block/state/BlockState;)Lnet/minecraft/client/resources/model/BakedModel;",
            remap = false,
            at = @At(target = "Ljava/lang/String;substring(II)Ljava/lang/String;", value = "INVOKE")
    )
    private static String gregitas$generateModelTFCCompatSubString(String instance, int beginIndex, int endIndex, Operation<String> original, @Local(name = "namespace") String namespace) {
        return namespace.equals("tfc") ? instance.substring(12) : original.call(instance, beginIndex, endIndex);
    }

    @WrapOperation(
            method = "getLogBlockState",
            remap = false,
            at = @At(target = "Lnet/minecraftforge/registries/IForgeRegistry;getHolder(Lnet/minecraft/resources/ResourceLocation;)Ljava/util/Optional;", value = "INVOKE")
    )
    private static Optional<Holder<Block>> gregitas$getLogBlockStateTFCCompat(IForgeRegistry instance, ResourceLocation resourceLocation, Operation<Optional<Holder<Block>>> original, @Local(name = "namespace", index = 0) String namespace, @Local(name = "wood", index = 1) String wood) {
        return namespace.equals("tfc") ? instance.getHolder(new ResourceLocation(namespace, "wood/log/" + wood)) : original.call(instance, resourceLocation);
    }
}

