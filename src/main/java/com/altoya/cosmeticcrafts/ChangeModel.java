package com.altoya.cosmeticcrafts;

import java.util.List;

import com.altoya.cosmeticcrafts.createItem.Information;
import com.altoya.cosmeticcrafts.createItem.InformationDataType;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChangeModel implements Listener{

  
  @EventHandler // Detects when a player places a modelChanger item onto a changable item
  public void inventoryInteract(InventoryClickEvent event){
    ItemStack clickedItem = event.getCurrentItem();
    ItemStack heldItem = event.getCursor();

    //Checks that clickedItem exists, that modelChanger is an actual modelChanger
    if(clickedItem == null || heldItem == null) return;
    if(clickedItem.getType() == Material.AIR) return;
    if(!heldItem.hasItemMeta()) return;
    if(!heldItem.getItemMeta().hasCustomModelData()) return;
    if(heldItem.getItemMeta().getCustomModelData() != 0) return;

    //Gets information from modelChanger
    NamespacedKey key = new NamespacedKey(Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts"), "model_changer");
    Information info = heldItem.getItemMeta().getPersistentDataContainer().get(key, new InformationDataType());
    List<Material> materials = info.getMaterials();
    int modelID = info.getModelID();

    //Checks if item is the correct material for modelChanger.
    if(!materials.contains(clickedItem.getType()))return;

    //Updates clickedItem's meta with new data.
    ItemMeta clickedMeta = clickedItem.getItemMeta();
    clickedMeta.setCustomModelData(modelID);
    clickedItem.setItemMeta(clickedMeta);

    heldItem.setAmount(0);//Deletes modelChanger

  }
    
}

