package com.live.macsephi.Utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class CanIDoCommand implements CommandExecutor {
    private final Frenz plugin;

    public CanIDoCommand(Frenz plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPermission(player, "MobEffects.canido")) {
                if (args.length == 1) {
                    PluginCommand cmd = Bukkit.getPluginCommand(args[0]);
                    if (cmd != null) {
                        if (cmd.testPermissionSilent(sender)) {
                            player.sendMessage(ChatColor.GREEN
                                    + "You have permission.");
                            return true;
                        }
                        player.sendMessage(ChatColor.RED
                                + "You don't have permission.");
                        return true;
                    }
                    player.sendMessage(ChatColor.RED + args[0]
                            + " is not a valid command.");
                } else {
                    player.sendMessage("Usage: /canido <command>");
                }
            } else
                player.sendMessage(ChatColor.RED
                        + "You don't have permission to use this command.");
        }

        return false;
    }
}