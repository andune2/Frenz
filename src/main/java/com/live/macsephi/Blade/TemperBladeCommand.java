package com.live.macsephi.Blade;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class TemperBladeCommand implements CommandExecutor {
    private final Frenz me;

    public TemperBladeCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "temperblade")) {
                if (this.me.temper.contains(player)) {
                    this.me.temper.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "You have returned your blade to normal.");
                    return true;
                }
                this.me.temper.add(player);
                player.sendMessage(ChatColor.BLUE
                        + "You carefully compress the metal of your blade with even hammer strokes, professionally tempering the blade.");
                player.sendMessage(ChatColor.BLUE + "[STR Lvl-5]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}