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
        Bukkit.addRecipe(getRecipe());
    }
    @Override
    public void onDisable() {
    }

    private void setModelID(ItemStack item, int ID){
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(ID);
        item.setItemMeta(meta);
    }

    private ShapedRecipe getRecipe(){
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setCustomModelData(1234567);

        item.setItemMeta(meta);

        NamespacedKey key = new NamespacedKey(this, "custom_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, item);

        recipe.shape(" B ", " B ", " R ");
        recipe.setIngredient('B', Material.GOLD_BLOCK);
        recipe.setIngredient('R', Material.BLAZE_ROD);

        return recipe;
    }
}