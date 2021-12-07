package com.altoya.cosmeticcrafts.createItem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Item{
  private void setMeta(ItemStack item, String id, String name, List<String> loreList, List<Material> materials){
    //Creates lore list, adds materials to said lore.
    List<String> lore = new ArrayList<>();
    
    for(String current : loreList){
      lore.add(ChatColor.translateAlternateColorCodes('&', current));
    }

    //Updates lore, model data, name to item
    System.out.println("HERE");
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
    meta.setCustomModelData(0);
    meta.setLore(lore);
    meta.setUnbreakable(true);

    //Adds information about what model to change to, plus materials used, saves it to PersistentDataContainer
    Information info = new Information(Integer.parseInt(id), materials);
    NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts"), "model_changer");
    meta.getPersistentDataContainer().set(key, new InformationDataType(), info);

    //Updates item with meta
    item.setItemMeta(meta);
  }

  public ItemStack getModelChanger(FileConfiguration config, String itemID){
      ItemStack item = new ItemStack(Material.BLAZE_POWDER);

      //Gets all information from config to be used in creating item
      String id = config.getString("items." + itemID + ".modelID");
      String name = config.getString("items." + itemID + ".name");
      List<String> lore = config.getStringList("items." + itemID + ".lore");
      List<String> materialString = config.getStringList("items." + itemID + ".materials");

      //Converts string-version of materials to Material type
      List<Material> materials = new ArrayList<>();
      for(int i = 0; i < materialString.size(); i++){
        materials.add(Material.getMaterial(materialString.get(i)));
      }

      setMeta(item, id, name, lore, materials);//Sets item meta

      return item;
  }
}
