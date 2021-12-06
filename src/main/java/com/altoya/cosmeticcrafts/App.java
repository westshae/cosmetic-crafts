package com.altoya.cosmeticcrafts;

import java.util.Arrays;

import com.altoya.cosmeticcrafts.createItem.Item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ChangeModel(), this);
        Bukkit.addRecipe(Item.getModelChanger(Arrays.asList(Material.IRON_SWORD, Material.STONE_SWORD, Material.GOLDEN_SWORD, Material.WOODEN_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD)));
    }
    @Override
    public void onDisable() {
    }

    
}