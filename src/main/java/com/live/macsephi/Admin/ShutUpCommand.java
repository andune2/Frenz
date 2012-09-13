package com.live.macsephi.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class ShutUpCommand implements CommandExecutor {
    private final Frenz me;

    public ShutUpCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "shutup")) {
                if ((args.length == 1)
                        && (this.me.getServer().getPlayer(args[0]) != null)) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    if (this.me.hasPluginPermission(target, "shutup.immunity")) {
                        player.sendMessage(ChatColor.DARK_RED
                                + target.getName() + " cannot be silenced!");
                        return true;
                    }
                    if (this.me.isMuted.contains(target)) {
                        this.me.isMuted.remove(target);
                        this.me.getServer().broadcastMessage(
                                ChatColor.GRAY + target.getName()
                                        + " has been unmuted!");
                        return true;
                    }
                    this.me.isMuted.add(target);
                    this.me.getServer().broadcastMessage(
                            ChatColor.GRAY + target.getName()
                                    + " has been muted by " + player.getName()
                                    + "!");
                    return true;
                }
                player.sendMessage("Usage: /shutup <player>");
            } else {
                player.sendMessage(ChatColor.DARK_RED
                        + "You don't have permission to use this command.");
            }
        }
        return false;
    }
}