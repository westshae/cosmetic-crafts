package com.altoya.cosmeticcrafts.createItem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

public class GiveItem implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("giveskin")) {
      if (sender.hasPermission("cosmeticcrafts.giveskin")) {
        if(args.length != 1 && args.length != 2) return true;
          // Loads config.yml
          FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts").getConfig();

          // If the custom item hasn't been found. return;
          if (config.getString("items." + args[0].toString()) == null) {
            sender.sendMessage("This custom model doesn't exist!");
            return true;
          }

          // Creates modelChanger item, gives to player
          ItemStack item = new Item().getModelChanger(config, args[0]);
          if(args.length == 2){
            if(Bukkit.getPlayerExact(args[1]) == null) return true;
            Bukkit.getPlayerExact(args[1]).getInventory().addItem(item);
          }else{
            Bukkit.getPlayerExact(sender.getName()).getInventory().addItem(item);
          }
      
      }
    }
    return true;
  }
}
