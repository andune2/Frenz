package com.live.macsephi;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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

    // Mackenzie - May I inquire on this being necessary for the /shutup command? Appears to be so
    // but I have trouble trusting myself on this one.
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (this.me.isMuted.contains(event.getPlayer()))
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if ((event.getMessage().startsWith("/me "))
                && (this.me.isMuted.contains(event.getPlayer())))
            event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityExplode(EntityExplodeEvent event) {
        if ((event.getEntity() instanceof TNTPrimed)) {
            TNTPrimed thingy = (TNTPrimed) event.getEntity();
            if (this.me.tntPrimed.contains(thingy)) {
                event.setCancelled(false);
                event.setYield(4.0F);
                event.blockList().clear();
                this.me.tntPrimed.remove(thingy);
            }
            if (this.me.napalm.contains(thingy)) {
                event.setCancelled(false);
                event.setYield(10.0F);
                for (Block block : event.blockList()) {
                    block.setType(Material.FIRE);
                    this.me.getServer().getPluginManager()
                            .callEvent(new BlockBurnEvent(block));
                }
                event.blockList().clear();
                this.me.napalm.remove(thingy);
            }
        }
    }
}