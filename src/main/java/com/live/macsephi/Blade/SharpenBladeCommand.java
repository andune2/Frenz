package com.live.macsephi.Blade;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SharpenBladeCommand implements CommandExecutor {
    private final Frenz me;

    public SharpenBladeCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.sharpenblade")) {
                if (this.me.sharpen.contains(player)) {
                    this.me.sharpen.remove(player);
                    player.sendMessage(ChatColor.BLUE
                            + "You have returned your blade to normal.");
                    return true;
                }
                this.me.sharpen.add(player);
                player.sendMessage(ChatColor.BLUE
                        + "You sharpened both edges of your blade, making it double-edged.");
                player.sendMessage(ChatColor.BLUE + "[STR Lvl-2]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}