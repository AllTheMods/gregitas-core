package com.allthemods.gravitas2.events;

import com.allthemods.gravitas2.GregitasCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;

@Mod.EventBusSubscriber(modid = GregitasCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AnvilRecipes {

    private static final Set<String> REPAIRABLE_TOOL_TYPES = Set.of(
            "pickaxe", "axe", "shovel", "hoe", "hammer", "propick", "knife", "saw", "scythe", "mace", "chisel", "javelin", "sword"
    );
    private static final Set<String> SINGLE_INGOT_TAG_NAMESPACES = Set.of("c", "forge");

    @SubscribeEvent
    public static void onAnvilRepair(AnvilUpdateEvent event) {
        final ItemStack left = event.getLeft();
        final ItemStack right = event.getRight();

        if (left.isEmpty() || right.isEmpty() || !left.isDamaged()) {
            return;
        }

        final ParsedMetalItem tool = parseMetalItem(left);
        if (tool == null || !REPAIRABLE_TOOL_TYPES.contains(tool.form())) {
            return;
        }

        final RepairMaterial repairMaterial = resolveRepairMaterial(right, tool.metal());
        if (repairMaterial == null) {
            return;
        }

        final int perUnitRepair = repairMaterial == RepairMaterial.DOUBLE_INGOT
                ? Math.max(1, left.getMaxDamage() / 2)
                : Math.max(1, left.getMaxDamage() / 4);

        final int neededUnits = (int) Math.ceil((double) left.getDamageValue() / perUnitRepair);
        final int unitsUsed = Math.min(neededUnits, right.getCount());
        if (unitsUsed <= 0) {
            return;
        }

        final int repairedDamage = Math.max(0, left.getDamageValue() - (unitsUsed * perUnitRepair));
        if (repairedDamage >= left.getDamageValue()) {
            return;
        }

        // Copying the original stack preserves forging bonuses and other stack data.
        final ItemStack output = left.copy();
        output.setDamageValue(repairedDamage);

        event.setOutput(output);
        event.setMaterialCost(unitsUsed);
        event.setCost(unitsUsed);
    }

    private static RepairMaterial resolveRepairMaterial(ItemStack stack, String expectedMetal) {
        final ParsedMetalItem parsed = parseMetalItem(stack);
        if (parsed != null && expectedMetal.equals(parsed.metal())) {
            if ("double_ingot".equals(parsed.form())) {
                return RepairMaterial.DOUBLE_INGOT;
            }
            if ("ingot".equals(parsed.form())) {
                return RepairMaterial.INGOT;
            }
        }

        return matchesSingleIngotTag(stack, expectedMetal) ? RepairMaterial.INGOT : null;
    }

    private static boolean matchesSingleIngotTag(ItemStack stack, String metal) {
        for (String namespace : SINGLE_INGOT_TAG_NAMESPACES) {
            final TagKey<Item> ingotTag = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(namespace, "ingots/" + metal));
            if (stack.is(ingotTag)) {
                return true;
            }
        }
        return false;
    }

    private static ParsedMetalItem parseMetalItem(ItemStack stack) {
        final ResourceLocation key = ForgeRegistries.ITEMS.getKey(stack.getItem());
        if (key == null) {
            return null;
        }

        // TFC-style entries are usually: metal/<form>/<metal_name>
        final String[] parts = key.getPath().split("/");
        if (parts.length < 3 || !"metal".equals(parts[0])) {
            return null;
        }

        return new ParsedMetalItem(parts[1], parts[2]);
    }

    private enum RepairMaterial {
        INGOT,
        DOUBLE_INGOT
    }

    private record ParsedMetalItem(String form, String metal) {}
}
