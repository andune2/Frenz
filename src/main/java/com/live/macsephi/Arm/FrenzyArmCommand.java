package com.live.macsephi.Arm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class FrenzyArmCommand implements CommandExecutor {
    private final Frenz me;

    public FrenzyArmCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.frenzyarm")) {
                this.me.setMobEffect(player, 3, 7800, 4);
                player.sendMessage(ChatColor.BLUE
                        + "Your arms enter a state of ballistic anomally, granting you unfathomable dexterity with your tools.");
                player.sendMessage(ChatColor.BLUE + "[DEX Lvl-4]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}