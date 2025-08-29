package com.newtools;

import com.newtools.items.EmeraldSword;
import com.newtools.items.ObsidianPickaxe;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Newtools implements ModInitializer {

    public static final String MOD_ID = "newtools";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Items
    public static final Item EMERALD_SWORD = new EmeraldSword(new Item.Settings().group(ItemGroup.MISC));
    public static final Item OBSIDIAN_PICKAXE = new ObsidianPickaxe(new Item.Settings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        // Register items
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "emerald_sword"), EMERALD_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "obsidian_pickaxe"), OBSIDIAN_PICKAXE);

        LOGGER.info("Newtools mod initialized!");
    }
}
