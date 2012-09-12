package com.live.macsephi.Shield;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class ObsidianShieldCommand implements CommandExecutor {
    private final Frenz plugin;

    public ObsidianShieldCommand(Frenz plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPermission(player, "MobEffects.obsidianshield")) {
                if (this.plugin.obsidian.contains(player)) {
                    this.plugin.obsidian.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "Your defense enhancement has subsided.");
                    return true;
                }
                player.sendMessage(ChatColor.BLUE
                        + "You have been blessed by the gods with a divine defensive infrastructure. Fatal wounds are mere tickling sensations.");
                player.sendMessage(ChatColor.BLUE + "[DEF Lvl-6]");
                this.plugin.obsidian.add(player);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}