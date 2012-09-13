package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowman;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.EntityBlockFormEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class MEListener implements Listener {
    private final Frenz me;

    public MEListener(Frenz me) {
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

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        String m = event.getMessage().toLowerCase();
        if ((m.startsWith("/pl ")) || (m.startsWith("/plugins "))
                || (m.equals("/plugins")) || (m.equals("/pl"))) {
            Plugin[] plugins = this.me.getServer().getPluginManager()
                    .getPlugins();

            StringBuilder sb = new StringBuilder("Plugins (" + plugins.length
                    + "): ");
            for (int i = 0; i < plugins.length; i++) {
                if (i == 0) {
                    sb.append(ChatColor.GREEN + plugins[i].getName());
                } else {
                    sb.append(ChatColor.WHITE + ", " + ChatColor.GREEN
                            + plugins[i].getName());
                }
            }

            event.getPlayer().sendMessage(
                    BetterChatWrapper.wrapText(sb.toString()));
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
            if (this.me.hasPermission(player, "MobEffects.food.freeze"))
                event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onEnchant(EnchantItemEvent event) {
        if (this.me.hasPermission(event.getEnchanter(),
                "MobEffects.discountenchant")) {
            double cost = event.getExpLevelCost();
            double discount = this.me.config
                    .getDouble("Enchantments.DiscountedCost(%)") / 100.0D;
            int finalCost = (int) (cost * discount);
            event.setExpLevelCost(finalCost);
        }
    }
}