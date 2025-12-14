package com.allthemods.gravitas2.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class GregitasTags {
public static final TagKey<Block> gravels= TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("tfc","rock/gravel"));
public static final TagKey<Block> rawstone = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("tfc","rock/raw"));
public static final TagKey<Block> dirts = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("tfc","dirt"));
public static final TagKey<Block> grasses = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("tfc","grass"));
public static final TagKey<Block> paths = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("tfc","paths"));

public static final TagKey<Block> cobbles = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("forge","cobblestone"));
}
