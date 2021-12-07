package com.altoya.cosmeticcrafts;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener{
  @EventHandler
  public void onJoin(PlayerJoinEvent event){
    //Note, link is direct download link
    // event.getPlayer().setResourcePack("https://drive.google.com/uc?export=download&id=19retB0Wcr0Q_ldOze2N0rq7PjgtY5NnF");
    //Directly downloads resource pack;
    event.getPlayer().setResourcePack("https://www.dropbox.com/sh/f3ie51vsn6pi1wj/AAAsq6jQvAp3e-yF6DHmFF5Ja?dl=1");
  }
}
