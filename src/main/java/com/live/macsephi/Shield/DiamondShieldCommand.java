package com.live.macsephi.Shield;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class DiamondShieldCommand implements CommandExecutor {
    private final Frenz plugin;

    public DiamondShieldCommand(Frenz plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPermission(player, "MobEffects.diamondshield")) {
                if (this.plugin.diamond.contains(player)) {
                    this.plugin.diamond.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "Your defense enhancement has subsided.");
                    return true;
                }
                player.sendMessage(ChatColor.BLUE
                        + "Your exterior hardens to that of pure diamond, vastly excelling even the best of armors.");
                player.sendMessage(ChatColor.BLUE + "[DEF Lvl-5]");
                this.plugin.diamond.add(player);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}