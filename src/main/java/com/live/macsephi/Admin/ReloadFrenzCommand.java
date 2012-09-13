package com.live.macsephi.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class ReloadFrenzCommand implements CommandExecutor {
    private final Frenz me;

    public ReloadFrenzCommand(Frenz me) {
        this.me = me;
    }
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "reload")) {
                this.me.reloadConfig();
                player.sendMessage(ChatColor.BLUE
                        + "[MobEffects] Config has been reloaded.");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        } else {
            this.me.reloadConfig();
            me.getLogger().info("[MobEffects] Config has been reloaded.");
            return true;
        }
        return false;
    }
}