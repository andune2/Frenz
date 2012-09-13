package com.live.macsephi;

import org.bukkit.Material;
import org.bukkit.block.Block;
//Mackenzie - I LOVE how Maven is adding these automatically. Less work for me. ^.^;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;

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
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBladeEvent(EntityDamageByEntityEvent event) {
        if (((event.getDamager() instanceof Player))
                && (this.me.death.contains(event.getDamager()))) {
            event.setDamage(event.getDamage() * 5000);
            if ((event.getEntity() instanceof Player)) {
                this.me.isSlain.add((Player) event.getEntity());
            }
            return;
        }

        if ((event.getEntity() instanceof EnderDragonPart))
            return;
        int damage;
        if ((event.getDamager() instanceof Player)) {
            Player attacker = (Player) event.getDamager();
            damage = getNewDamage(event.getDamage(), attacker);
        } else {
            damage = event.getDamage();
        }

        if (!(event.getEntity() instanceof Player)) {
            event.setDamage(damage);
            return;
        }

        Player player = (Player) event.getEntity();
        if (this.me.obsidian.contains(player)) {
            int finalDamage = (int) (damage * 0.15D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.diamond.contains(player)) {
            int finalDamage = (int) (damage * 0.5D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.iron.contains(player)) {
            int finalDamage = (int) (damage * 0.6D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.gold.contains(player)) {
            int finalDamage = (int) (damage * 0.7D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.stone.contains(player)) {
            int finalDamage = (int) (damage * 0.8D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.wood.contains(player)) {
            int finalDamage = (int) (damage * 0.9D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        event.setDamage(damage);
    }
    public int getNewDamage(int damage, Player attacker) {
        if (this.me.bDivine.contains(attacker))
            return damage + 50;
        if (this.me.temper.contains(attacker))
            return damage + 20;
        if (this.me.extend.contains(attacker))
            return damage + 16;
        if (this.me.serrate.contains(attacker))
            return damage + 12;
        if (this.me.sharpen.contains(attacker))
            return damage + 8;
        if (this.me.carve.contains(attacker))
            return damage + 4;
        return damage;
    }
}