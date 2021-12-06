package com.altoya.cosmeticcrafts;
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
        Bukkit.addRecipe(getModelChanger());
    }
    @Override
    public void onDisable() {
    }

    private void setModelID(ItemStack item, int ID){
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(ID);
        item.setItemMeta(meta);
    }

    private ShapedRecipe getModelChanger(){
        ItemStack item = new ItemStack(Material.BLAZE_POWDER);
        NamespacedKey key = new NamespacedKey(this, "model_changer");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        setModelID(item, 0);

        recipe.shape("", " B ", "");
        recipe.setIngredient('B', Material.BLAZE_POWDER);

        return recipe;
    }
}