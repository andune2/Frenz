package com.live.macsephi.Admin;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.PluginManager;

import com.live.macsephi.Frenz;

public class AdminListener implements Listener {
    private final Frenz me;

    public AdminListener(Frenz me, FileConfiguration config) {
        this.me = me;
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerChat(PlayerChatEvent event) {
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