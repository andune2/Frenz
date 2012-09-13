package com.live.macsephi.Arm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class PickaxeArmCommand implements CommandExecutor {
    private final Frenz me;

    public PickaxeArmCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "pickaxearm")) {
                this.me.setMobEffect(player, 3, 9600, 5);
                player.sendMessage(ChatColor.BLUE
                        + "You are bestowed upon with unimaginable power within your arms. You feel as though you could mine obsidian with your bare hands!");
                player.sendMessage(ChatColor.BLUE + "[DEX Lvl-5]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}