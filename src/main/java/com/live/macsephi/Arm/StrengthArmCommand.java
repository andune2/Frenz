package com.live.macsephi.Arm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class StrengthArmCommand implements CommandExecutor {
    private final Frenz me;

    public StrengthArmCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "strengtharm")) {
                this.me.setMobEffect(player, 3, 1200, 1);
                player.sendMessage(ChatColor.BLUE
                        + "Your arms feel as though you worked out for several hours, improving your use of tools.");
                player.sendMessage(ChatColor.BLUE + "[DEX Lvl-1]");
            } else {
                player.sendMessage(ChatColor.DARK_RED
                        + "You don't have permission to use this command.");
            }
        }
        return false;
    }
}