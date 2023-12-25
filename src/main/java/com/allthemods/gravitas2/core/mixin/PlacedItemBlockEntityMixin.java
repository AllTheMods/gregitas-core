package com.allthemods.gravitas2.core.mixin;

import dev.ftb.mods.ftbchunks.api.FTBChunksAPI;
import dev.ftb.mods.ftbchunks.api.FTBChunksProperties;
import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import net.dries007.tfc.common.blockentities.PlacedItemBlockEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = PlacedItemBlockEntity.class, remap = false)
public class PlacedItemBlockEntityMixin {

    @Inject(method = "onRightClick(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/world/item/ItemStack;ZZ)Z", at = @At("HEAD"), cancellable = true)
    public void gregitas$blockUseIfClaimed(Player player, ItemStack stack, boolean x, boolean z, CallbackInfoReturnable<Boolean> cir) {
        if (!FTBChunksAPI.api().isManagerLoaded()) return;
        if (!(player instanceof ServerPlayer serverPlayer)) return;
        var chunkManager = FTBChunksAPI.api().getManager();
        var chunkDimPos = new ChunkDimPos(player.level().dimension(), player.chunkPosition());
        var claimedChunk = chunkManager.getChunk(chunkDimPos);
        var teamData = claimedChunk != null ? claimedChunk.getTeamData() : null;

        if (teamData != null) {
            if (!teamData.canPlayerUse(serverPlayer, FTBChunksProperties.BLOCK_EDIT_MODE)) {
                cir.setReturnValue(false);
            }
        }
    }
}
