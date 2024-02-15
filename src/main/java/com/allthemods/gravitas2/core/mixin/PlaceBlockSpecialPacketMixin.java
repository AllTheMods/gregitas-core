package com.allthemods.gravitas2.core.mixin;

import dev.ftb.mods.ftbchunks.api.FTBChunksAPI;
import dev.ftb.mods.ftbchunks.api.FTBChunksProperties;
import dev.ftb.mods.ftblibrary.math.ChunkDimPos;
import net.dries007.tfc.common.blockentities.PlacedItemBlockEntity;
import net.dries007.tfc.network.PlaceBlockSpecialPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PlaceBlockSpecialPacket.class, remap = false)
public class PlaceBlockSpecialPacketMixin {

    @Inject(method = "lambda$handle$0", at = @At(value = "HEAD", target = "Lnet/minecraft/server/level/ServerPlayer;pick(DFZ)Lnet/minecraft/world/phys/HitResult;", remap = true), cancellable = true)
    private static void gregitas$cancelItemPlace(ServerPlayer player, ItemStack stack, BlockHitResult blockResult, PlacedItemBlockEntity e, CallbackInfo ci) {


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
