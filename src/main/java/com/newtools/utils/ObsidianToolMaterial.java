package com.newtools.utils;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;

public class ObsidianToolMaterial implements ToolMaterial {

    public static final ObsidianToolMaterial INSTANCE = new ObsidianToolMaterial();

    @Override
    public int getDurability() {
        return 2031; // Higher durability than diamond
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0F; // Higher mining speed than diamond
    }

    @Override
    public float getAttackDamage() {
        return 5.0F; // Higher attack damage than diamond
    }

    @Override
    public int getMiningLevel() {
        return 4; // Higher mining level than diamond
    }

    @Override
    public int getEnchantability() {
        return 15; // Higher enchantability than diamond
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.OBSIDIAN);
    }
}
