package com.live.macsephi.Shield;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class GoldShieldCommand implements CommandExecutor {
    private final Frenz plugin;

    public GoldShieldCommand(Frenz plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPluginPermission(player, "goldshield")) {
                if (this.plugin.gold.contains(player)) {
                    this.plugin.gold.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "Your defense enhancement has subsided.");
                    return true;
                }
                player.sendMessage(ChatColor.BLUE
                        + "You feel a sudden metallic sensation coursing through your veins.");
                player.sendMessage(ChatColor.BLUE + "[DEF Lvl-3]");
                this.plugin.gold.add(player);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}