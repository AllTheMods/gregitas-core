package com.allthemods.gravitas2.core.mixin;

import com.jozufozu.flywheel.core.StitchedSprite;
import com.simibubi.create.content.kinetics.waterwheel.WaterWheelRenderer;
import com.simibubi.create.foundation.model.BakedModelHelper;
import com.simibubi.create.foundation.utility.RegisteredObjects;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Mixin(WaterWheelRenderer.class)
public class MixinWaterWheelRenderer {
    @Final
    @Shadow
    private static final String[] LOG_SUFFIXES = new String[]{"_log", "_stem", "_block"};
    @Final
    @Shadow
    public static final StitchedSprite OAK_PLANKS_TEMPLATE = new StitchedSprite(new ResourceLocation("block/oak_planks"));
    @Final
    @Shadow
    public static final StitchedSprite OAK_LOG_TEMPLATE = new StitchedSprite(new ResourceLocation("block/oak_log"));
    @Final
    @Shadow
    public static final StitchedSprite OAK_LOG_TOP_TEMPLATE = new StitchedSprite(new ResourceLocation("block/oak_log_top"));

    /**
     * @author
     * @reason
     */
    @Overwrite(remap = false)
    public static BakedModel generateModel(BakedModel template, BlockState planksBlockState) {
        Block planksBlock = planksBlockState.getBlock();
        ResourceLocation id = RegisteredObjects.getKeyOrThrow(planksBlock);
        String path = id.getPath();

        if (path.endsWith("_planks") || path.contains("wood/planks/")) {
            String namespace = id.getNamespace();
            String wood = (Objects.equals(namespace, "tfc"))
                    ? path.substring(12)
                    : path.substring(0, path.length() - 7);
            BlockState logBlockState = getLogBlockState(namespace, wood);

            Map<TextureAtlasSprite, TextureAtlasSprite> map = new Reference2ReferenceOpenHashMap<>();
            map.put(OAK_PLANKS_TEMPLATE.get(), getSpriteOnSide(planksBlockState, Direction.UP));
            map.put(OAK_LOG_TEMPLATE.get(), getSpriteOnSide(logBlockState, Direction.SOUTH));
            map.put(OAK_LOG_TOP_TEMPLATE.get(), getSpriteOnSide(logBlockState, Direction.UP));

            return BakedModelHelper.generateModel(template, map::get);
        }

        return BakedModelHelper.generateModel(template, sprite -> null);
    }
    /**
     * @author thevortex
     * @reason
     */
    @Overwrite(remap = false)
    private static BlockState getLogBlockState(String namespace, String wood) {
        for (String suffix : LOG_SUFFIXES) {
            Optional<BlockState> state = (Objects.equals(namespace, "tfc"))
                    ? ForgeRegistries.BLOCKS.getHolder(new ResourceLocation(namespace, "wood/log/" + wood))
                    .map(Holder::value)
                    .map(Block::defaultBlockState)
                    : ForgeRegistries.BLOCKS.getHolder(new ResourceLocation(namespace, wood + suffix))
                    .map(Holder::value)
                    .map(Block::defaultBlockState);
            if (state.isPresent())
                return state.get();
        }
        return Blocks.OAK_LOG.defaultBlockState();
    }
    private static TextureAtlasSprite getSpriteOnSide(BlockState state, Direction side) {
        BakedModel model = Minecraft.getInstance()
                .getBlockRenderer()
                .getBlockModel(state);
        if (model == null)
            return null;
        RandomSource random = RandomSource.create();
        random.setSeed(42L);
        List<BakedQuad> quads = model.getQuads(state, side, random, ModelData.EMPTY, null);
        if (!quads.isEmpty()) {
            return quads.get(0)
                    .getSprite();
        }
        random.setSeed(42L);
        quads = model.getQuads(state, null, random, ModelData.EMPTY, null);
        if (!quads.isEmpty()) {
            for (BakedQuad quad : quads) {
                if (quad.getDirection() == side) {
                    return quad.getSprite();
                }
            }
        }
        return model.getParticleIcon(ModelData.EMPTY);
    }
}

