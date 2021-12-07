package com.altoya.cosmeticcrafts;

import java.io.File;
import java.util.Arrays;

import com.altoya.cosmeticcrafts.createItem.GiveItem;

import org.bukkit.plugin.java.JavaPlugin;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        loadConfig();//Loads .yml

        //Sets server commands/listener events
        this.getCommand("giveskin").setExecutor(new GiveItem());
        this.getServer().getPluginManager().registerEvents(new ChangeModel(), this);
    }

    public void loadConfig() {
        File file = new File(getDataFolder(), "item.yml");//Gets config
        if(!file.exists()){//If config file doesn't exist, create new file
            getConfig().addDefault("items.0.modelID", "1234567");
            getConfig().addDefault("items.0.name", "&6&lSkinChanger: &b&lCosmeticChanger");
            getConfig().addDefault("items.0.lore", Arrays.asList("&bChanges your item models", "", "&7Use on swords"));
            getConfig().addDefault("items.0.materials", Arrays.asList("GOLDEN_SWORD", "DIAMOND_SWORD", "WOODEN_SWORD", "IRON_SWORD", "STONE_SWORD", "NETHERITE_SWORD"));
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        else{//Else, load config data
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    
}