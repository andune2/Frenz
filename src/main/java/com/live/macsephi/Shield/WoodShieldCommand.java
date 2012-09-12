package com.live.macsephi.Shield;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class WoodShieldCommand implements CommandExecutor {
    private final Frenz plugin;

    public WoodShieldCommand(Frenz plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPermission(player, "MobEffects.woodshield")) {
                if (this.plugin.wood.contains(player)) {
                    this.plugin.wood.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "Your defense enhancement has subsided.");
                    return true;
                }
                player.sendMessage(ChatColor.BLUE
                        + "You feel as though your skin has tightened to replicate the toughness of treebark.");
                player.sendMessage(ChatColor.BLUE + "[DEF Lvl-1]");
                this.plugin.wood.add(player);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}