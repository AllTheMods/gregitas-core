package com.allthemods.gravitas2.data.recipe.builder;

import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.dries007.tfc.common.recipes.TFCRecipeSerializers;
import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@MethodsReturnNonnullByDefault
@FieldsAreNonnullByDefault
@ParametersAreNonnullByDefault
@NoArgsConstructor
@Accessors(chain = true, fluent = true)
public class CollapseRecipeBuilder {

    @Setter
    private Block ingredient;
    @Setter
    private Block result;
    @Setter
    @Nullable
    protected ResourceLocation id;

    public CollapseRecipeBuilder(ResourceLocation id) {
        this.id = id;
    }

    @SuppressWarnings("DataFlowIssue")
    protected ResourceLocation defaultId() {
        return ForgeRegistries.BLOCKS.getKey(result);
    }

    public void toJson(JsonObject json) {
        json.addProperty("ingredient", ForgeRegistries.BLOCKS.getKey(ingredient).toString());
        json.addProperty("result", ForgeRegistries.BLOCKS.getKey(result).toString());
    }

    public void save(Consumer<FinishedRecipe> consumer) {
        consumer.accept(new FinishedRecipe() {
            @Override
            public void serializeRecipeData(JsonObject pJson) {
                toJson(pJson);
            }

            @Override
            public ResourceLocation getId() {
                var ID = id == null ? defaultId() : id;
                return new ResourceLocation(ID.getNamespace(), "collapse" + "/" + ID.getPath());
            }

            @Override
            public RecipeSerializer<?> getType() {
                return TFCRecipeSerializers.COLLAPSE.get();
            }

            @Nullable
            @Override
            public JsonObject serializeAdvancement() {
                return null;
            }

            @Nullable
            @Override
            public ResourceLocation getAdvancementId() {
                return null;
            }
        });
    }
}
