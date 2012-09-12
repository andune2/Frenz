package com.live.macsephi.Events;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class DeathByCauseEvent extends PlayerDeathEvent {
    private static final long serialVersionUID = 1331847507574355515L;

    public DeathByCauseEvent(Player player, List<ItemStack> drops,
            int droppedExp, String deathMessage,
            EntityDamageEvent.DamageCause cause) {
        super(player, drops, droppedExp, deathMessage);
    }
}