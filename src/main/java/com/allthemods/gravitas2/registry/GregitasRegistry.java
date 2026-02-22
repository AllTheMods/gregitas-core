package com.allthemods.gravitas2.registry;

import com.allthemods.gravitas2.GregitasCore;
import com.allthemods.gravitas2.enchants.RefreshingEnchant;
import com.allthemods.gravitas2.enchants.WarmingEnchant;
import com.allthemods.gravitas2.recipe.type.GregitasRecipeTypes;
import com.allthemods.gravitas2.util.GWoodType;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.valkyrienskies.eureka.block.ShipHelmBlock;
import org.valkyrienskies.eureka.block.IWoodType;

import java.util.List;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerTieredMachines;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class GregitasRegistry {
    public static GTRegistrate GREGITAS_REGISTRATE = GTRegistrate.create(GregitasCore.MOD_ID);

    public static final FoodTrait FreezeDried = FoodTrait.register(new ResourceLocation(GregitasCore.MOD_ID,"freeze_dried"),new FoodTrait(0.02F,"gregitas_core.freeze_dried"));

    public static final FoodTrait IceChilled = FoodTrait.register(new ResourceLocation(GregitasCore.MOD_ID,"ice_chilled"),new FoodTrait(2.0F,"gregitas_core.ice_chilled"));
    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registries.POTION, GregitasCore.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, GregitasCore.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, GregitasCore.MOD_ID);
    public static final DeferredRegister<MobEffect> MOBEFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, GregitasCore.MOD_ID);

    public static final RegistryObject<MobEffect> REFRESHING = MOBEFFECTS.register("refreshing", () -> new RefreshingEnchant(MobEffectCategory.BENEFICIAL,0x98D8D8){} );
    public static final RegistryObject<MobEffect> WARMING = MOBEFFECTS.register("warming", () -> new WarmingEnchant(MobEffectCategory.BENEFICIAL,0xFF5733){} );

    public static final RegistryObject<Potion> REFRESHING_POTION = POTIONS.register("refreshing", () -> new Potion(new MobEffectInstance(REFRESHING.get(), 600)));

    public static final RegistryObject<Potion> WARMING_POTION = POTIONS.register("warming", () -> new Potion(new MobEffectInstance(WARMING.get(), 600)));

    public static List<Holder<RegistryObject<Block>>> Gregistries = List.of();

    public static Holder<RegistryObject<Block>> OAK_HELM = registerBlockandItem("oak_helm", BlockBehaviour.Properties.copy(GWoodType.OAK.getLogs()), GWoodType.OAK);
    public static Holder<RegistryObject<Block>> ACACIA_HELM = registerBlockandItem("acacia_helm", BlockBehaviour.Properties.copy(GWoodType.ACACIA.getLogs()), GWoodType.ACACIA);
    public static Holder<RegistryObject<Block>> BIRCH_HELM = registerBlockandItem("birch_helm", BlockBehaviour.Properties.copy(GWoodType.BIRCH.getLogs()), GWoodType.BIRCH);
    public static Holder<RegistryObject<Block>> SPRUCE_HELM = registerBlockandItem("spruce_helm", BlockBehaviour.Properties.copy(GWoodType.SPRUCE.getLogs()), GWoodType.SPRUCE);
    public static Holder<RegistryObject<Block>> BLACKWOOD_HELM = registerBlockandItem("blackwood_helm", BlockBehaviour.Properties.copy(GWoodType.BLACKWOOD.getLogs()), GWoodType.BLACKWOOD);
    public static Holder<RegistryObject<Block>> ROSEWOOD_HELM = registerBlockandItem("rosewood_helm", BlockBehaviour.Properties.copy(GWoodType.ROSEWOOD.getLogs()), GWoodType.ROSEWOOD);
    public static Holder<RegistryObject<Block>> WILLOW_HELM = registerBlockandItem("willow_helm", BlockBehaviour.Properties.copy(GWoodType.WILLOW.getLogs()), GWoodType.WILLOW);
    public static Holder<RegistryObject<Block>> DOUGLASFIR_HELM = registerBlockandItem("douglasfir_helm", BlockBehaviour.Properties.copy(GWoodType.DOUGLASFIR.getLogs()), GWoodType.DOUGLASFIR);
    public static Holder<RegistryObject<Block>> KAPOK_HELM = registerBlockandItem("kapok_helm", BlockBehaviour.Properties.copy(GWoodType.KAPOK.getLogs()), GWoodType.KAPOK);
    public static Holder<RegistryObject<Block>> SYCAMORE_HELM = registerBlockandItem("sycamore_helm", BlockBehaviour.Properties.copy(GWoodType.SYCAMORE.getLogs()), GWoodType.SYCAMORE);
    public static Holder<RegistryObject<Block>> CHESTNUT_HELM = registerBlockandItem("chestnut_helm", BlockBehaviour.Properties.copy(GWoodType.CHESTNUT.getLogs()), GWoodType.CHESTNUT);
    public static Holder<RegistryObject<Block>> PALM_HELM = registerBlockandItem("palm_helm", BlockBehaviour.Properties.copy(GWoodType.PALM.getLogs()), GWoodType.PALM);
    public static Holder<RegistryObject<Block>> WHITECEDAR_HELM = registerBlockandItem("whitecedar_helm", BlockBehaviour.Properties.copy(GWoodType.WHITECEDAR.getLogs()), GWoodType.WHITECEDAR);
    public static Holder<RegistryObject<Block>> HICKORY_HELM = registerBlockandItem("hickory_helm", BlockBehaviour.Properties.copy(GWoodType.HICKORY.getLogs()), GWoodType.HICKORY);
    public static Holder<RegistryObject<Block>> MAPLE_HELM = registerBlockandItem("maple_helm", BlockBehaviour.Properties.copy(GWoodType.MAPLE.getLogs()), GWoodType.MAPLE);
    public static Holder<RegistryObject<Block>> ASPEN_HELM = registerBlockandItem("aspen_helm", BlockBehaviour.Properties.copy(GWoodType.ASPEN.getLogs()), GWoodType.ASPEN);
    public static Holder<RegistryObject<Block>> ASH_HELM = registerBlockandItem("ash_helm", BlockBehaviour.Properties.copy(GWoodType.ASH.getLogs()), GWoodType.ASH);
    public static Holder<RegistryObject<Block>> SEQUOIA_HELM = registerBlockandItem("sequoia_helm", BlockBehaviour.Properties.copy(GWoodType.SEQUOIA.getLogs()), GWoodType.SEQUOIA);
    public static Holder<RegistryObject<Block>> MANGROVE_HELM = registerBlockandItem("mangrove_helm", BlockBehaviour.Properties.copy(GWoodType.MANGROVE.getLogs()), GWoodType.MANGROVE);


    private static Holder<RegistryObject<Block>> registerBlockandItem(String name, BlockBehaviour.Properties properties, IWoodType woodType) {
        Block block = new ShipHelmBlock(properties, woodType);
        Holder<RegistryObject<Block>> blockHolder = Holder.direct(BLOCKS.register(name, () -> block));
        Gregistries.add(blockHolder);
        ITEMS.register(name, () -> block.asItem());
        return blockHolder;
    }

}
