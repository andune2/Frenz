package com.live.macsephi.Utility;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class TPRandomCommand implements CommandExecutor {
    private final Frenz plugin;

    public TPRandomCommand(Frenz me) {
        this.plugin = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.plugin.hasPermission(player, "MobEffects.tprandom")) {
                int x = player.getLocation().getBlockX();
                int z = player.getLocation().getBlockZ();
                int rx = new Random().nextInt(1000) + 1;
                int rz = new Random().nextInt(1000) + 1;

                if (rx > 500)
                    x = rx - 500;
                else {
                    x = -rx;
                }

                if (rz > 500)
                    z = rz - 500;
                else {
                    z = -rz;
                }

                int y = player.getWorld().getHighestBlockYAt(x, z);

                player.teleport(new Location(player.getWorld(), x, y, z));
                player.sendMessage(ChatColor.GRAY
                        + "You have been teleported to (" + x + ", " + y + ", "
                        + z + ")");
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}