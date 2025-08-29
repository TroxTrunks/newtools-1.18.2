package com.newtools.utils;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.Items;

public class EmeraldToolMaterial implements ToolMaterial {

    public static final EmeraldToolMaterial INSTANCE = new EmeraldToolMaterial();

    @Override
    public int getDurability() {
        return 1561; // Durability similar to diamond
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0F; // Mining speed similar to diamond
    }

    @Override
    public float getAttackDamage() {
        return 4.0F; // Attack damage similar to diamond
    }

    @Override
    public int getMiningLevel() {
        return 3; // Mining level similar to diamond
    }

    @Override
    public int getEnchantability() {
        return 10; // Enchantability similar to diamond
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.EMERALD);
    }
}
