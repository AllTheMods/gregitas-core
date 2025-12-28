package com.allthemods.gravitas2.recipe.type;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.registry.GregitasRegistry;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.ForgeRegistries;

public class GregitasRecipeTypes {

    public static final String GREGITAS = "gregitas";

//    public static GTRecipeType BURNER_REACTOR_RECIPES = register("burner_reactor", GREGITAS)
//            .setMaxIOSize(0, 3, 0, 2)
//            .setEUIO(IO.IN)
//            .setProgressBar(GuiTextures.PROGRESS_BAR_ARC_FURNACE, LEFT_TO_RIGHT)
//            .setSound(GTSoundEntries.ARC);

    public static final GTRecipeType FOOD_OVEN_RECIPES = GTRecipeTypes
            .register("food_oven", GTRecipeTypes.ELECTRIC)
            .setEUIO(IO.IN)
            .setMaxIOSize(1, 2, 1, 0)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.FURNACE);

    public static final GTRecipeType FOOD_PROCESSOR_RECIPES = GTRecipeTypes
            .register("food_processor", GTRecipeTypes.ELECTRIC)
            .setEUIO(IO.IN)
            .setMaxIOSize(9, 2, 3, 1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, ProgressTexture.FillDirection.LEFT_TO_RIGHT)
            .setSound(GTSoundEntries.MIXER)
            .setUiBuilder((recipe, widgetGroup) -> {
                var text = recipe.data.getString("action");
                if (!text.isEmpty()) {
                    widgetGroup.addWidget(new LabelWidget(widgetGroup.getSize().width - 50,
                            widgetGroup.getSize().height - 30, Component.translatable(text))
                            .setTextColor(-1)
                            .setDropShadow(true));
                }
            });


    public static void init() {

    }
}
