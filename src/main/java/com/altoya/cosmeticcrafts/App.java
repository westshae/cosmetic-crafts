package com.altoya.cosmeticcrafts;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.events.Namespace;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
public class App extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getServer().getPluginManager().registerEvents(new ChangeModel(), this);
        Bukkit.addRecipe(getModelChanger());
    }
    @Override
    public void onDisable() {
    }

    private void setModelID(ItemStack item, int ID){
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(ID);
        List<String> lore = new ArrayList<String>();
        lore.add("ID: " + ID);
        meta.setLore(lore);
        item.setItemMeta(meta);
    }

    private ShapedRecipe getModelChanger(){
        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
        NamespacedKey key = new NamespacedKey(this, "model_changer");
        setModelID(item, 0);        
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape("   ", " B ", "   ");
        recipe.setIngredient('B', Material.BLAZE_POWDER);

        return recipe;
    }
}