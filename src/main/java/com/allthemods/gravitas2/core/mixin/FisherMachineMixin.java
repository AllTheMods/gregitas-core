package com.allthemods.gravitas2.core.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.TieredEnergyMachine;
import com.gregtechceu.gtceu.api.machine.feature.IAutoOutputItem;
import com.gregtechceu.gtceu.api.machine.feature.IFancyUIMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMachineModifyDrops;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.common.machine.electric.FisherMachine;

import net.dries007.tfc.common.fluids.TFCFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;

@Mixin(value = FisherMachine.class, remap = false)
public abstract class FisherMachineMixin extends TieredEnergyMachine implements IAutoOutputItem, IFancyUIMachine, IMachineModifyDrops{

    @Shadow
    @Final    
    private static final ItemStack fishingRod = ItemStack.EMPTY;
    @Shadow
    @Final
    public final int fishingTicks;
    @Shadow
    @Final
    public static final int WATER_CHECK_SIZE = 5;
    @Shadow
    @Final
    protected final NotifiableItemStackHandler baitHandler;

    public FisherMachineMixin(IMachineBlockEntity holder, int tier, Object[] args) {
        super(holder, tier, args);
        this.fishingTicks = 1000 - tier * 200;
    
        this.baitHandler = createBaitItemHandler(args);
    }
    @Overwrite
    public void fishingUpdate() {
        drainEnergy(false);
        if (this.getOffsetTimer() % this.fishingTicks == 0) {
            int waterCount = 0;
            int edgeSize = WATER_CHECK_SIZE;
            for (int x = 0; x < edgeSize; x++) {
                for (int z = 0; z < edgeSize; z++) {
                    BlockPos waterCheckPos = getPos().below().offset(x - edgeSize / 2, 0, z - edgeSize / 2);
                    if ((getLevel().getBlockState(waterCheckPos).getFluidState().is(Fluids.WATER)) || (getLevel().getBlockState(waterCheckPos).getFluidState().is(TFCFluids.RIVER_WATER.get()))) {
                        waterCount++;
                    }
                }
            }
            if (waterCount < WATER_CHECK_SIZE * WATER_CHECK_SIZE)
                return;

            LootTable lootTable = getLevel().getServer().getLootData().getLootTable(BuiltInLootTables.FISHING);

            FishingHook simulatedHook = new FishingHook(EntityType.FISHING_BOBBER, getLevel()) {
                public boolean isOpenWaterFishing() {
                    return true;
                }
            };

            LootParams lootContext = new LootParams.Builder((ServerLevel) getLevel())
                    .withOptionalParameter(LootContextParams.THIS_ENTITY, simulatedHook)
                    .withParameter(LootContextParams.TOOL, fishingRod)
                    .withParameter(LootContextParams.ORIGIN, new Vec3(getPos().getX(), getPos().getY(), getPos().getZ()))
                    .create(LootContextParamSets.FISHING);


            NonNullList<ItemStack> generatedLoot = NonNullList.create();
            generatedLoot.addAll(lootTable.getRandomItems(lootContext));

            boolean useBait = false;
            for (ItemStack itemStack : generatedLoot)
                useBait |= tryFillCache(itemStack);

            if (useBait)
                this.baitHandler.extractItem(0, 1, false);
            updateFishingUpdateSubscription();
        }
    }
    @Shadow
    public abstract boolean drainEnergy(boolean simulate);

    @Shadow
    public abstract boolean tryFillCache(ItemStack itemStack);

    @Shadow
    protected abstract NotifiableItemStackHandler createBaitItemHandler(Object... args);
    @Shadow
    public abstract void updateFishingUpdateSubscription();
}
