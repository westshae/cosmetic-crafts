package com.altoya.cosmeticcrafts.createItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item{
  private void setMeta(ItemStack item, String id, String name, List<String> loreList, List<Material> materials){
    List<String> lore = new ArrayList<String>();
    lore.add(materials.toString());

    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName("SkinChanger: " + name);
    meta.setCustomModelData(0);
    meta.setLore(lore);
    Information info = new Information(Integer.parseInt(id), materials);
    NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts"), "model_changer");

    meta.getPersistentDataContainer().set(key, new InformationDataType(), info);
    item.setItemMeta(meta);
  }

  public ItemStack getModelChanger(FileConfiguration config, String itemID){
      ItemStack item = new ItemStack(Material.BLAZE_POWDER);

      String id = config.getString("items." + itemID + ".modelID");
      String name = config.getString("items." + itemID + ".name");
      String lore = config.getString("items." + itemID + ".lore");
      List<String> materialString = config.getStringList("items." + itemID + ".materials");

      List<Material> materials = new ArrayList<>();
      for(int i = 0; i < materialString.size(); i++){
        materials.add(Material.getMaterial(materialString.get(i)));
      }

      setMeta(item, id, name, Arrays.asList(lore), materials);

      return item;
  }
}
