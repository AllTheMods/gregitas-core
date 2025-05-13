package com.allthemods.gravitas2.core.mixin;

import net.dries007.tfc.common.blocks.TFCBlocks;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import ru.magistu.siegemachines.client.renderer.TrebuchetGeoRenderer;
import ru.magistu.siegemachines.entity.EntityTypes;
import ru.magistu.siegemachines.entity.projectile.ProjectileBuilder;
import ru.magistu.siegemachines.entity.projectile.Stone;
import ru.magistu.siegemachines.item.ModItems;

@Mixin(value = ProjectileBuilder.class, remap = false)
public class CobbleFix {

    @Mutable
    @Final
    @Shadow
    public static final ProjectileBuilder<?>[] THROWING_AMMO;
    @Mutable
    @Final
    @Shadow
    public static final ProjectileBuilder<?>[] GIANT_THROWING_AMMO;

    static {
        THROWING_AMMO = new ProjectileBuilder[]{
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.STONE.get(), Stone::new)

        };
        GIANT_THROWING_AMMO = new ProjectileBuilder[]{
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.BASALT).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.GIANT_STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.GRANITE).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.GIANT_STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.DIORITE).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.GIANT_STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.ANDESITE).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.GIANT_STONE.get(), Stone::new),
                new ProjectileBuilder(TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.COBBLE).get().asItem(), TFCBlocks.ROCK_BLOCKS.get(Rock.GABBRO).get(Rock.BlockType.COBBLE).get().asItem(), (EntityType) EntityTypes.GIANT_STONE.get(), Stone::new)

        };
    }
}
