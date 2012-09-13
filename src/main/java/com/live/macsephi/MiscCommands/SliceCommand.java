package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SliceCommand implements CommandExecutor {
    private final Frenz me;

    public SliceCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        Player player = (Player) sender;
        if ((sender instanceof Player)) {
            if (this.me.hasPluginPermission(player, "slice")) {
                if (player.getHealth() <= 5) {
                    player.setHealth(0);
                    player.sendMessage(ChatColor.DARK_BLUE
                            + "Like an emo, you take a razor to your wrists.");
                    return true;
                }
                player.setHealth(player.getHealth() - 5);
                player.sendMessage(ChatColor.DARK_BLUE
                        + "Like an emo, you take a razor to your wrists.");
                return true;
            }

            sender.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}