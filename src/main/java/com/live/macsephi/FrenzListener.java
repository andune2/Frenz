package com.live.macsephi;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

//Mackenzie - Warning cleanup, removed unused imports.

public class FrenzListener implements Listener {
    private final Frenz me;

    public FrenzListener(Frenz me) {
        this.me = me;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!this.me.disableFireCharges)
            return;
        if ((event.getMaterial() == null) || (event.getItem() == null))
            return;
        if ((event.getMaterial() == Material.FIREBALL)
                || (event.getItem().getTypeId() == 385)) {
            event.setUseItemInHand(PlayerInteractEvent.Result.DENY);
            event.setCancelled(true);
        }
    }
//Mackenzie - Scrapped this plugins command punching through back door. Definitely had to go.
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityBlockForm(EntityBlockFormEvent event) {
        if (((event.getEntity() instanceof Snowman))
                || (event.getEntity().getType() == EntityType.SNOWMAN)) {
            event.setCancelled(true);
        }
    }
    @EventHandler(ignoreCancelled = true)
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if ((event.getEntity() instanceof Player)) {
            Player player = (Player) event.getEntity();
            if (this.me.hasPluginPermission(player, "food.freeze"))
                event.setCancelled(true);
        }
    }
    //Mackenzie - Scrapped the discounted EXP/Enchanting function here.
}