package com.altoya.cosmeticcrafts.createItem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class GiveItem implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("giveskin")) {
      if(args.length != 1) return false;
      if (sender.hasPermission("cosmeticcrafts.giveskin")) {
        try{
        FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts").getConfig();
        String id = config.getString("items." + args[0].toString() + ".modelID");
        String name = config.getString("items." + args[0].toString() + ".name");
        String lore = config.getString("items." + args[0].toString() + ".lore");
        sender.sendMessage(id);
        sender.sendMessage(name);
        sender.sendMessage(lore);
        }catch(Exception e){
          System.out.println(e);
        }
      }
    }
    return true;
  }
}
