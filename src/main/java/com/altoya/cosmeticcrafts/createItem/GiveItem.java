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
      if(args.length != 1) return true;
      if (sender.hasPermission("cosmeticcrafts.giveskin")) {
        FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts").getConfig();

        if(config.getString("items." + args[0].toString()) == null){
          sender.sendMessage("This custom model doesn't exist!");
          return true;
        }

        ItemStack item = new Item().getModelChanger(config, args[0]);
        Bukkit.getPlayerExact(sender.getName()).getInventory().addItem(item);
      }
    }
    return true;
  }
}
