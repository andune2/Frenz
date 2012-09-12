package com.live.macsephi.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class CustomEventCaller
  implements Listener
{
  @EventHandler(ignoreCancelled=true)
  public void onEntityDamage(EntityDamageEvent event)
  {
    if (!(event.getEntity() instanceof Player)) return;
    Player player = (Player)event.getEntity();
    if (event.getDamage() < player.getHealth()) return;
    EntityDamageEvent.DamageCause cause = event.getCause();
    switch (cause)
    {
    case ENTITY_EXPLOSION:
    case FALL:
    }
  }
}