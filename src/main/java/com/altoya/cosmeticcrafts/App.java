package com.altoya.cosmeticcrafts;

import java.io.File;
import java.util.Arrays;

import com.altoya.cosmeticcrafts.createItem.GiveItem;

import org.bukkit.plugin.java.JavaPlugin;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();
        this.getCommand("giveskin").setExecutor(new GiveItem());
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ChangeModel(), this);
    }

    public void loadConfig() {
        File file = new File(getDataFolder(), "config.yml");
        if(!file.exists()){
            getConfig().addDefault("items.0.modelID", "1234567");
            getConfig().addDefault("items.0.name", "CosmeticChanger");
            getConfig().addDefault("items.0.lore", "Changes your item models");
            getConfig().addDefault("items.0.materials", Arrays.asList("GOLDEN_SWORD", "DIAMOND_SWORD"));
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        else{
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    
}