package com.allthemods.gravitas2.core.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import ru.magistu.siegemachines.client.renderer.MachineGeoRenderer;
import ru.magistu.siegemachines.client.renderer.TrebuchetGeoRenderer;
import ru.magistu.siegemachines.entity.machine.Trebuchet;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.GeoModel;

import java.util.Optional;

@Mixin(value = TrebuchetGeoRenderer.class, remap = false)
public abstract class TrebuchetVisualFix extends MachineGeoRenderer<Trebuchet> {


    protected TrebuchetVisualFix(EntityRendererProvider.Context rendermanager, GeoModel<Trebuchet> model) {
        super(rendermanager, model);
    }

    /**
     * @author
     * @reason
     */
    @Overwrite
    public void preRender(PoseStack poseStack, Trebuchet animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        Optional<GeoBone> projectile = model.getBone("Cobblestone");
        int projectilesize = (animatable.state == Trebuchet.State.IDLE_RELOADED || animatable.shootingticks > 0) && animatable.hasAmmo() ? 1 : 0;
        projectile.ifPresent((bone) -> {
            
            bone.setScaleX((float)projectilesize);
        });
        projectile.ifPresent((bone) -> {
            bone.setScaleY((float)projectilesize);
        });
        projectile.ifPresent((bone) -> {
            bone.setScaleZ((float)projectilesize);
        });

        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }

}
