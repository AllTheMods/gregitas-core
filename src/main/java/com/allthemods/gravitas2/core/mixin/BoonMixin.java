package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import dev.shadowsoffire.apotheosis.Apoth.Tags;
import dev.shadowsoffire.apotheosis.ench.enchantments.masterwork.EarthsBoonEnchant;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.common.blocks.TFCBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mixin(EarthsBoonEnchant.class)
public class BoonMixin extends Enchantment {

    protected BoonMixin(Rarity rarity, EnchantmentCategory category, EquipmentSlot[] applicableSlots) {
        super(rarity, category, applicableSlots);
        //TODO Auto-generated constructor stub
    }

    @Overwrite(remap = false)
       public void provideBenefits(BlockEvent.BreakEvent e) {
      RandomSource random = e.getPlayer().getRandom();
      Level Plevel = e.getPlayer().level();
      Player player = e.getPlayer();
      if(player instanceof FakePlayer){ return; }
      ItemStack stack = player.getMainHandItem();
      int level = stack.getEnchantmentLevel(this);
      if (!Plevel.isClientSide) {
         if (e.getState().is(TFCTags.Blocks.BREAKS_WHEN_ISOLATED) && level > 0 && random.nextFloat() <= 0.01F * (float)level) {
            ItemStack newDrop = new ItemStack((ItemLike)ForgeRegistries.ITEMS.tags().getTag(Tags.BOON_DROPS).getRandomElement(random).orElse(Items.AIR));
            Block.popResource(player.level(), e.getPos(), newDrop);
         }

      }
   }
}
