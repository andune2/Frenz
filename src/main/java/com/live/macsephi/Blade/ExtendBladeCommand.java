package com.live.macsephi.Blade;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class ExtendBladeCommand implements CommandExecutor {
    private final Frenz me;

    public ExtendBladeCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.extendblade")) {
                if (this.me.extend.contains(player)) {
                    this.me.extend.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "You have returned your blade to normal.");
                    return true;
                }
                this.me.extend.add(player);
                player.sendMessage(ChatColor.BLUE
                        + "You re-smelt your blade, hammering in two more feet of length.");
                player.sendMessage(ChatColor.BLUE + "[STR Lvl-4]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}