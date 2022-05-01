package com.github.ayaan.shrunk.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;

public class JesusBugEnchantment extends Enchantment {
    public JesusBugEnchantment(Enchantment.Rarity pRarity, EquipmentSlot... pApplicableSlots) {
        super(pRarity, EnchantmentCategory.ARMOR_FEET, pApplicableSlots);
    }

    public int getMinCost(int pEnchantmentLevel) {
        return pEnchantmentLevel * 10;
    }

    public int getMaxCost(int pEnchantmentLevel) {
        return this.getMinCost(pEnchantmentLevel) + 15;
    }

    /**
     * Checks if the enchantment should be considered a treasure enchantment. These enchantments can not be obtained
     * using the enchantment table. The mending enchantment is an example of a treasure enchantment.
     * @return Whether or not the enchantment is a treasure enchantment.
     */
    public boolean isTreasureOnly() {
        return true;
    }


    public static void onEntityMoved(LivingEntity pLiving, Level pLevel, BlockPos pPos, int pLevelConflicting) {
        Player player = null;
        Level level = null;
        if (!player.isCreative() && level.getBlockState(player.blockPosition().below()).is(Blocks.WATER)) {
            player.setDeltaMovement(player.getDeltaMovement().multiply(1, 0, 1));
        }
    }

}
