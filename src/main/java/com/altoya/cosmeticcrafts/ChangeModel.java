package com.altoya.cosmeticcrafts;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ChangeModel implements Listener{

  
  @EventHandler // Detects when a player places a modelChanger item onto a changable item
  public void inventoryInteract(InventoryClickEvent event){
    HumanEntity player = event.getWhoClicked();
    ItemStack clickedItem = event.getCurrentItem();
    ItemStack heldItem = event.getCursor();

    if(clickedItem == null || heldItem == null) return;
    if(clickedItem.getType() == Material.AIR) return;
    if(!heldItem.hasItemMeta()) return;
    if(!heldItem.getItemMeta().hasCustomModelData()) return;
    if(heldItem.getItemMeta().getCustomModelData() != 0) return;

    player.sendMessage("HeldItem: " + heldItem.toString());
    player.sendMessage("clickedItem: " + clickedItem.toString());

  }
    
}

