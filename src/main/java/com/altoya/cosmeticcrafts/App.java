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
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ChangeModel(), this);
    }

    public void loadConfig() {
        File file = new File(getDataFolder(), "item.yml");//Gets config
        if(!file.exists()){//If config file doesn't exist, create new file
            getConfig().addDefault("texturepack.link", "https://www.dropbox.com/sh/f3ie51vsn6pi1wj/AAAsq6jQvAp3e-yF6DHmFF5Ja?dl=1");
            getConfig().addDefault("items.0.modelID", "1234567");
            getConfig().addDefault("items.0.name", "CosmeticChanger");
            getConfig().addDefault("items.0.lore", "Changes your item models");
            getConfig().addDefault("items.0.materials", Arrays.asList("GOLDEN_SWORD", "DIAMOND_SWORD"));
            getConfig().options().copyDefaults(true);
            saveConfig();
        }

        else{//Else, load config data
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    
}