package com.allthemods.gravitas2.core.mixin;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@Mixin(value = TagPrefix.OreType.class, remap = false)
public interface TagPrefixOreTypeAccessor {

    @Accessor @Mutable
    void setStoneType(Supplier<BlockState> state);

    @Accessor @Mutable
    void setIsNether(boolean isNether);

    @Accessor @Mutable
    void setIsSand(boolean isSand);
}
