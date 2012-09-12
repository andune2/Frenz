package com.live.macsephi.Shield;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class StoneShieldCommand implements CommandExecutor {
    private final Frenz plugin;

    public StoneShieldCommand(Frenz plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPermission(player, "MobEffects.stoneshield")) {
                if (this.plugin.stone.contains(player)) {
                    this.plugin.stone.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "Your defense enhancement has subsided.");
                    return true;
                }
                player.sendMessage(ChatColor.BLUE
                        + "You feel your physique becoming one with solid stone.");
                player.sendMessage(ChatColor.BLUE + "[DEF Lvl-2]");
                this.plugin.stone.add(player);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}