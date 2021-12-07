package com.altoya.cosmeticcrafts.createItem;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

public class GiveItem implements CommandExecutor {
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (command.getName().equalsIgnoreCase("giveskin")) {
      if(args.length != 1) return true;
      if (sender.hasPermission("cosmeticcrafts.giveskin")) {
        try{
        FileConfiguration config = Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts").getConfig();
        String itemExist = config.getString("items." + args[0].toString());
        if(itemExist == null){
          sender.sendMessage("REEEEEE");
          return true;
        }

        ItemStack item = new Item().getModelChanger(config, args[0]);

        HumanEntity player = Bukkit.getPlayerExact(sender.getName());
        player.getInventory().addItem(item);
        }catch(Exception e){
          System.out.println(e);
        }
      }
    }
    return true;
  }
}
