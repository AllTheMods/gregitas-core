package com.allthemods.gravitas2.registry;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.enchants.RefreshingEnchant;
import com.allthemods.gravitas2.enchants.WarmingEnchant;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.util.GWoodType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.SimpleTieredMachine;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import net.dries007.tfc.common.capabilities.food.FoodTrait;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.valkyrienskies.eureka.block.ShipHelmBlock;
import org.valkyrienskies.eureka.block.IWoodType;

import java.util.List;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerTieredMachines;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GregitasRegistry {
    public static GTRegistrate GREGITAS_REGISTRATE = GTRegistrate.create(GregitasCore.MOD_ID);

    public static final FoodTrait FreezeDried = FoodTrait.register(ResourceLocation.fromNamespaceAndPath(GregitasCore.MOD_ID, "freeze_dried"), new FoodTrait(0.02F, "gregitas_core.freeze_dried"));

    public static final FoodTrait IceChilled = FoodTrait.register(ResourceLocation.fromNamespaceAndPath(GregitasCore.MOD_ID, "ice_chilled"), new FoodTrait(2.0F, "gregitas_core.ice_chilled"));

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, GregitasCore.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, GregitasCore.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, GregitasCore.MOD_ID);
    public static final DeferredRegister<MobEffect> MOBEFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, GregitasCore.MOD_ID);

    public static final RegistryObject<MobEffect> REFRESHING = MOBEFFECTS.register("refreshing", () -> new RefreshingEnchant(MobEffectCategory.BENEFICIAL, 0x98D8D8) {});
    public static final RegistryObject<MobEffect> WARMING = MOBEFFECTS.register("warming", () -> new WarmingEnchant(MobEffectCategory.BENEFICIAL, 0xFF5733) {});

    public static final RegistryObject<Potion> REFRESHING_POTION = POTIONS.register("refreshing", () -> new Potion(new MobEffectInstance(REFRESHING.get(), 600)));
    public static final RegistryObject<Potion> WARMING_POTION = POTIONS.register("warming", () -> new Potion(new MobEffectInstance(WARMING.get(), 600)));

    public static final RegistryObject<Block> OAK_HELM = registerBlock("oak_ship_helm", BlockBehaviour.Properties.of(), GWoodType.OAK);
    public static final RegistryObject<Block> ACACIA_HELM = registerBlock("acacia_ship_helm", BlockBehaviour.Properties.of(), GWoodType.ACACIA);
    public static final RegistryObject<Block> BIRCH_HELM = registerBlock("birch_ship_helm", BlockBehaviour.Properties.of(), GWoodType.BIRCH);
    public static final RegistryObject<Block> SPRUCE_HELM = registerBlock("spruce_ship_helm", BlockBehaviour.Properties.of(), GWoodType.SPRUCE);
    public static final RegistryObject<Block> BLACKWOOD_HELM = registerBlock("blackwood_ship_helm", BlockBehaviour.Properties.of(), GWoodType.BLACKWOOD);
    public static final RegistryObject<Block> ROSEWOOD_HELM = registerBlock("rosewood_ship_helm", BlockBehaviour.Properties.of(), GWoodType.ROSEWOOD);
    public static final RegistryObject<Block> WILLOW_HELM = registerBlock("willow_ship_helm", BlockBehaviour.Properties.of(), GWoodType.WILLOW);
    public static final RegistryObject<Block> DOUGLASFIR_HELM = registerBlock("douglas_fir_ship_helm", BlockBehaviour.Properties.of(), GWoodType.DOUGLASFIR);
    public static final RegistryObject<Block> KAPOK_HELM = registerBlock("kapok_ship_helm", BlockBehaviour.Properties.of(), GWoodType.KAPOK);
    public static final RegistryObject<Block> SYCAMORE_HELM = registerBlock("sycamore_ship_helm", BlockBehaviour.Properties.of(), GWoodType.SYCAMORE);
    public static final RegistryObject<Block> CHESTNUT_HELM = registerBlock("chestnut_ship_helm", BlockBehaviour.Properties.of(), GWoodType.CHESTNUT);
    public static final RegistryObject<Block> PALM_HELM = registerBlock("palm_ship_helm", BlockBehaviour.Properties.of(), GWoodType.PALM);
    public static final RegistryObject<Block> WHITECEDAR_HELM = registerBlock("white_cedar_ship_helm", BlockBehaviour.Properties.of(), GWoodType.WHITECEDAR);
    public static final RegistryObject<Block> HICKORY_HELM = registerBlock("hickory_ship_helm", BlockBehaviour.Properties.of(), GWoodType.HICKORY);
    public static final RegistryObject<Block> MAPLE_HELM = registerBlock("maple_ship_helm", BlockBehaviour.Properties.of(), GWoodType.MAPLE);
    public static final RegistryObject<Block> ASPEN_HELM = registerBlock("aspen_ship_helm", BlockBehaviour.Properties.of(), GWoodType.ASPEN);
    public static final RegistryObject<Block> ASH_HELM = registerBlock("ash_ship_helm", BlockBehaviour.Properties.of(), GWoodType.ASH);
    public static final RegistryObject<Block> SEQUOIA_HELM = registerBlock("sequoia_ship_helm", BlockBehaviour.Properties.of(), GWoodType.SEQUOIA);
    public static final RegistryObject<Block> MANGROVE_HELM = registerBlock("mangrove_ship_helm", BlockBehaviour.Properties.of(), GWoodType.MANGROVE);



    public static final RegistryObject<Item> OAK_HELM_ITEM = ITEMS.register("oak_ship_helm", () -> new BlockItem(OAK_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> ACACIA_HELM_ITEM = ITEMS.register("acacia_ship_helm", () -> new BlockItem(ACACIA_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_HELM_ITEM = ITEMS.register("birch_ship_helm", () -> new BlockItem(BIRCH_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_HELM_ITEM = ITEMS.register("spruce_ship_helm", () -> new BlockItem(SPRUCE_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> BLACKWOOD_HELM_ITEM = ITEMS.register("blackwood_ship_helm", () -> new BlockItem(BLACKWOOD_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> ROSEWOOD_HELM_ITEM = ITEMS.register("rosewood_ship_helm", () -> new BlockItem(ROSEWOOD_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILLOW_HELM_ITEM = ITEMS.register("willow_ship_helm", () -> new BlockItem(WILLOW_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> DOUGLASFIR_HELM_ITEM = ITEMS.register("douglas_fir_ship_helm", () -> new BlockItem(DOUGLASFIR_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> KAPOK_HELM_ITEM = ITEMS.register("kapok_ship_helm", () -> new BlockItem(KAPOK_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> SYCAMORE_HELM_ITEM = ITEMS.register("sycamore_ship_helm", () -> new BlockItem(SYCAMORE_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHESTNUT_HELM_ITEM = ITEMS.register("chestnut_ship_helm", () -> new BlockItem(CHESTNUT_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> PALM_HELM_ITEM = ITEMS.register("palm_ship_helm", () -> new BlockItem(PALM_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> WHITECEDAR_HELM_ITEM = ITEMS.register("white_cedar_ship_helm", () -> new BlockItem(WHITECEDAR_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> HICKORY_HELM_ITEM = ITEMS.register("hickory_ship_helm", () -> new BlockItem(HICKORY_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> MAPLE_HELM_ITEM = ITEMS.register("maple_ship_helm", () -> new BlockItem(MAPLE_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASPEN_HELM_ITEM = ITEMS.register("aspen_ship_helm", () -> new BlockItem(ASPEN_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> ASH_HELM_ITEM = ITEMS.register("ash_ship_helm", () -> new BlockItem(ASH_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> SEQUOIA_HELM_ITEM = ITEMS.register("sequoia_ship_helm", () -> new BlockItem(SEQUOIA_HELM.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_HELM_ITEM = ITEMS.register("mangrove_ship_helm", () -> new BlockItem(MANGROVE_HELM.get(), new Item.Properties()));
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GregitasCore.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab_2", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.gregitas_core.all"))
            .icon(() -> ROSEWOOD_HELM_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> ITEMS.getEntries().stream()
                    .map(RegistryObject::get)
                    .map(Item::getDefaultInstance)
                    .forEach(output::accept))
            .build()
    );

    private static RegistryObject<Block> registerBlock(String name, BlockBehaviour.Properties properties, IWoodType woodType) {
        return BLOCKS.register(name, () -> new ShipHelmBlock(properties, woodType));

    }
}