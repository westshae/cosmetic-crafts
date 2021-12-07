package com.altoya.cosmeticcrafts;

import java.io.File;
import java.util.Arrays;

import com.altoya.cosmeticcrafts.createItem.GiveItem;
import com.altoya.cosmeticcrafts.createItem.Item;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();
        this.getCommand("giveskin").setExecutor(new GiveItem());
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ChangeModel(), this);
        Bukkit.addRecipe(Item.getModelChanger(Arrays.asList(Material.IRON_SWORD, Material.STONE_SWORD, Material.GOLDEN_SWORD, Material.WOODEN_SWORD, Material.DIAMOND_SWORD, Material.NETHERITE_SWORD)));
    }
    @Override
    public void onDisable() {
    }

    public void loadConfig() {
        File file = new File(getDataFolder(), "config.yml");
        if(!file.exists()){
            getConfig().addDefault("items.0.modelID", "0");
            getConfig().addDefault("items.0.name", "CosmeticChanger");
            getConfig().addDefault("items.0.lore", "Changes your item models");
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        else{
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    
}