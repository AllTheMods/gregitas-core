package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import com.eerussianguy.beneath.ForgeEvents;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

@Mixin(ForgeEvents.class)
public class BeneathForgeEventsMixin {

	@Inject(
			method = "onEntityJoinLevel",
			at = @At("HEAD"),
			cancellable = true,
			remap = false
	)
	private static void handsOffNetherMobs(EntityJoinLevelEvent event, CallbackInfo ci) {
		ci.cancel();
	}
}
