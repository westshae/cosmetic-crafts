package com.altoya.cosmeticcrafts.createItem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Item{
  public static void setModelID(ItemStack item, int ID, List<Material> materials){
    ItemMeta meta = item.getItemMeta();
    meta.setCustomModelData(ID);

    List<String> lore = new ArrayList<String>();
    lore.add("ID: " + ID);
    lore.add(materials.toString());
    meta.setLore(lore);

    item.setItemMeta(meta);
  }

  public static void setItemsUsable(ItemStack item, NamespacedKey key,List<Material> materials){
    ItemMeta meta = item.getItemMeta();
    Information info = new Information(1234567, materials);
    
    meta.getPersistentDataContainer().set(key, new InformationDataType(), info);
    item.setItemMeta(meta);
  }

  public static ShapedRecipe getModelChanger(List<Material> materials){
      ItemStack item = new ItemStack(Material.BLAZE_POWDER);
      NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts"), "model_changer");

      setModelID(item, 0, materials);
      setItemsUsable(item, key, materials);
      ShapedRecipe recipe = new ShapedRecipe(key, item);

      recipe.shape("   ", " B ", "   ");
      recipe.setIngredient('B', Material.BLAZE_POWDER);

      return recipe;
  }
}
