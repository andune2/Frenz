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
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        String world = event.getEntity().getWorld().getName();
        
        // TODO: this should be converted to ENUM values and
        // not use the ordinal values. Just fixing compile
        // errors for now. - morganm 9/11/12
        switch (event.getEntityType().ordinal()) {
        case 37:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Ocelot"))
                break;
            event.setCancelled(true);
            break;
        case 38:
            if (this.me.config
                    .getBoolean("EnabledMobs." + world + ".IronGolem"))
                break;
            event.setCancelled(true);
            break;
        case 26:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Blaze"))
                break;
            event.setCancelled(true);
            break;
        case 24:
            if (this.me.config.getBoolean("EnabledMobs." + world
                    + ".Cave-Spider"))
                break;
            event.setCancelled(true);
            break;
        case 32:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Chicken"))
                break;
            event.setCancelled(true);
            break;
        case 31:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Cow"))
                break;
            event.setCancelled(true);
            break;
        case 15:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Creeper"))
                break;
            event.setCancelled(true);
            break;
        case 28:
            if (this.me.config.getBoolean("EnabledMobs." + world
                    + ".Ender Dragon"))
                break;
            event.setCancelled(true);
            break;
        case 23:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Enderman"))
                break;
            event.setCancelled(true);
            break;
        case 21:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Ghast"))
                break;
            event.setCancelled(true);
            break;
        case 27:
            if (this.me.config.getBoolean("EnabledMobs." + world
                    + ".Magma Cube"))
                break;
            event.setCancelled(true);
            break;
        case 35:
            if (this.me.config
                    .getBoolean("EnabledMobs." + world + ".Mooshroom"))
                break;
            event.setCancelled(true);
            break;
        case 29:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Pig"))
                break;
            event.setCancelled(true);
            break;
        case 22:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Pigman"))
                break;
            event.setCancelled(true);
            break;
        case 30:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Sheep"))
                break;
            event.setCancelled(true);
            break;
        case 25:
            if (this.me.config.getBoolean("EnabledMobs." + world
                    + ".Silverfish"))
                break;
            event.setCancelled(true);
            break;
        case 16:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Skeleton"))
                break;
            event.setCancelled(true);
            break;
        case 20:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Slime"))
                break;
            event.setCancelled(true);
            break;
        case 36:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Snowman"))
                break;
            event.setCancelled(true);
            break;
        case 17:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Spider"))
                break;
            event.setCancelled(true);
            break;
        case 33:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Squid"))
                break;
            event.setCancelled(true);
            break;
        case 39:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Villager"))
                break;
            event.setCancelled(true);
            break;
        case 34:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Wolf"))
                break;
            event.setCancelled(true);
            break;
        case 19:
            if (this.me.config.getBoolean("EnabledMobs." + world + ".Zombie"))
                break;
            event.setCancelled(true);
        case 18:
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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (this.me.isEmo.contains(player)) {
            event.setDeathMessage(player.getName()
                    + " has committed emosuicide! :'(");
            this.me.isEmo.remove(player);
            return;
        }

        if (this.me.isSlain.contains(player)) {
            event.setDeathMessage(ChatColor.BLACK + "Death has taken "
                    + player.getName() + "!");
            this.me.isSlain.remove(player);
            return;
        }

        // TODO: this should be converted to ENUM values and
        // not use the ordinal values. Just fixing compile
        // errors for now. - morganm 9/11/12
        switch (event.getEntityType().ordinal()) {
        case 11:
        case 12:
            if (!this.me.config.getBoolean("DeathMessages.Explosion.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY
                    + player.getName()
                    + " "
                    + this.me.config
                            .getString("DeathMessages.Explosion.Message"));
            break;
        case 15:
            if (!this.me.config.getBoolean("DeathMessages.Suicide.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY + player.getName() + " "
                    + this.me.config.getString("DeathMessages.Suicide.Message"));
            break;
        case 10:
            if (!this.me.config.getBoolean("DeathMessages.Drowning.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY
                    + player.getName()
                    + " "
                    + this.me.config
                            .getString("DeathMessages.Drowning.Message"));
            break;
        case 5:
            if (!this.me.config.getBoolean("DeathMessages.Fall.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY + player.getName() + " "
                    + this.me.config.getString("DeathMessages.Fall.Message"));
            break;
        case 6:
        case 7:
            if (!this.me.config.getBoolean("DeathMessages.Fire.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY + player.getName() + " "
                    + this.me.config.getString("DeathMessages.Fire.Message"));
            break;
        case 9:
            if (!this.me.config.getBoolean("DeathMessages.Lava.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY + player.getName() + " "
                    + this.me.config.getString("DeathMessages.Lava.Message"));
            break;
        case 14:
            if (!this.me.config.getBoolean("DeathMessages.Lightning.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY
                    + player.getName()
                    + " "
                    + this.me.config
                            .getString("DeathMessages.Lightning.Message"));
            break;
        case 18:
            if (!this.me.config.getBoolean("DeathMessages.Magic.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY + player.getName() + " "
                    + this.me.config.getString("DeathMessages.Magic.Message"));
            break;
        case 17:
            if (!this.me.config.getBoolean("DeathMessages.Poison.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY + player.getName() + " "
                    + this.me.config.getString("DeathMessages.Poison.Message"));
            break;
        case 16:
            if (!this.me.config.getBoolean("DeathMessages.Starvation.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY
                    + player.getName()
                    + " "
                    + this.me.config
                            .getString("DeathMessages.Starvation.Message"));
            break;
        case 4:
            if (!this.me.config.getBoolean("DeathMessages.Suffocation.Enabled"))
                break;
            event.setDeathMessage(ChatColor.GRAY
                    + player.getName()
                    + " "
                    + this.me.config
                            .getString("DeathMessages.Suffocation.Message"));
        case 8:
        case 13:
        }
    }

    /* Removing CitizensManager dependency for now. -morganm 9/11/12
    @EventHandler(ignoreCancelled = true)
    public void onGuardDamage(EntityDamageEvent event) {
        if ((this.me.getServer().getPluginManager().getPlugin("Citizens") != null)
                && (CitizensManager.isNPC(event.getEntity())))
            event.setCancelled(true);
    }
    */

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