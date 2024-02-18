package com.allthemods.gravitas2.core.mixin;

import com.github.alexthe666.iceandfire.IceAndFire;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.chunk.ChunkStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.function.Supplier;

/** Avoid log spam for dragon caves (some blocks can exceed the writable worldgen area due to their size) */
@Mixin(WorldGenRegion.class)
public class WorldGenRegionMixin {
    @Shadow @Nullable private Supplier<String> currentlyGenerating;
    @Shadow @Final
    private ChunkStatus generatingStatus;

    @Inject(method = "ensureCanWrite", at = @At(value = "INVOKE", target = "Lnet/minecraft/Util;logAndPauseIfInIde(Ljava/lang/String;)V", shift = At.Shift.BY, by = -2), cancellable = true)
    private void gregitas$skipLog(final BlockPos position, final CallbackInfoReturnable<Boolean> callback) {
        if (this.currentlyGenerating != null && this.currentlyGenerating.get().contains(IceAndFire.MODID)) {
            callback.setReturnValue(false);
        } else {
            Util.logAndPauseIfInIde("Detected setBlock in a far chunk [" + SectionPos.blockToSectionCoord(position.getX()) + ", " + SectionPos.blockToSectionCoord(position.getZ()) + "], pos: " + position + ", status: " + this.generatingStatus + (this.currentlyGenerating == null ? "" : ", currently generating: " + (String)this.currentlyGenerating.get()));
            callback.setReturnValue(false);
        }
    }

}
