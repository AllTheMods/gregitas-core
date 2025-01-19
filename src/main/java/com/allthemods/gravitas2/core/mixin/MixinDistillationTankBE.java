package com.allthemods.gravitas2.core.mixin;

import java.util.List;
import java.util.stream.Collectors;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.jesz.createdieselgenerators.blocks.entity.DistillationTankBlockEntity;
import com.jesz.createdieselgenerators.recipes.DistillationRecipe;
import com.jesz.createdieselgenerators.recipes.RecipeRegistry;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import com.simibubi.create.foundation.recipe.RecipeFinder;

import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.Shadow;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;

@Mixin(DistillationTankBlockEntity.class) 
public abstract class MixinDistillationTankBE extends BlockEntity {

    @Shadow
    public FluidTank tankInventory;
    @Shadow
    public int heat;

    public MixinDistillationTankBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
      super(type, pos, state);
   }

     
    private static final Object RECIPE_CACHE_KEY = new Object();
    @Overwrite(remap = false)
    protected List<Recipe<?>> getMatchingRecipes() {
        List<Recipe<?>> list = RecipeFinder.get(RECIPE_CACHE_KEY, level, recipe -> recipe.getType() == RecipeRegistry.DISTILLATION.getType());
        return list.stream()
                .filter(r -> !((DistillationRecipe) r).getFluidIngredients().isEmpty() && (((DistillationRecipe) r).getFluidIngredients().get(0).getMatchingFluidStacks().contains(tankInventory.getFluid()) && ((DistillationRecipe) r).getFluidIngredients().get(0).getRequiredAmount() <= tankInventory.getFluidAmount() && getHeat(((DistillationRecipe) r).getRequiredHeat()) <= heat))
                .collect(Collectors.toList());
    }

    int getHeat(HeatCondition heatCondition) {
        if (heatCondition == HeatCondition.SUPERHEATED) {
           return 2;
        } else {
           return heatCondition == HeatCondition.HEATED ? 1 : 0;
        }
     }


}
