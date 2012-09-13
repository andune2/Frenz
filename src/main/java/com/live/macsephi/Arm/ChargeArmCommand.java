package com.live.macsephi.Arm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class ChargeArmCommand implements CommandExecutor {
    private final Frenz me;

    public ChargeArmCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "chargearm")) {
                this.me.setMobEffect(player, 3, 3000, 2);
                player.sendMessage(ChatColor.BLUE
                        + "Your arms feel charged, as if electrified with extra energy.");
                player.sendMessage(ChatColor.BLUE + "[DEX Lvl-2]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}