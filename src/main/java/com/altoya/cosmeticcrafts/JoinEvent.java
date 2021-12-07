package com.altoya.cosmeticcrafts;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
  @EventHandler
  public void onJoin(PlayerJoinEvent event){
    //Directly downloads resource pack from config.yml
    String url = Bukkit.getServer().getPluginManager().getPlugin("cosmeticcrafts").getConfig().getString("texturepack.link");
    event.getPlayer().setResourcePack(url);
  }
}
