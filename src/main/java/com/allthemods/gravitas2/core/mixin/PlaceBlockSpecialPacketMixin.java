package com.allthemods.gravitas2.core.mixin;

import dev.ftb.mods.ftbchunks.api.FTBChunksAPI;
import dev.ftb.mods.ftbchunks.api.FTBChunksProperties;
import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import net.dries007.tfc.network.PlaceBlockSpecialPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlaceBlockSpecialPacket.class, remap = false)
public class PlaceBlockSpecialPacketMixin {

    @Inject(method = "lambda$handle$2", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerPlayer;pick(DFZ)Lnet/minecraft/world/phys/HitResult;", remap = true), cancellable = true)
    private static void gregitas$cancelItemPlace(NetworkEvent.Context context, CallbackInfo ci) {
        ServerPlayer player = context.getSender();

        if (!FTBChunksAPI.api().isManagerLoaded()) return;
        var chunkManager = FTBChunksAPI.api().getManager();
        var chunkDimPos = new ChunkDimPos(player.level().dimension(), player.chunkPosition());
        var claimedChunk = chunkManager.getChunk(chunkDimPos);
        var teamData = claimedChunk != null ? claimedChunk.getTeamData() : null;

        if (teamData != null) {
            if (!teamData.canPlayerUse(player, FTBChunksProperties.BLOCK_EDIT_MODE)) {
                ci.cancel();
            }
        }
    }
}
