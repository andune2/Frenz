package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SuperDistortCommand implements CommandExecutor {
    private final Frenz me;

    public SuperDistortCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (this.me.hasPermission(player, "MobEffects.superdistort")) {
                    if (this.me.getServer().getPlayer(args[0]) == null) {
                        player.sendMessage(ChatColor.RED
                                + "Player does not exist");
                        return false;
                    }
                    Player targetPlayer = this.me.getServer()
                            .getPlayer(args[0]);
                    this.me.setMobEffect(targetPlayer, 9, 1800, 5);
                    player.sendMessage(ChatColor.BLUE
                            + "You have somehow distorted "
                            + targetPlayer.getName() + "'s vision!");
                    targetPlayer.sendMessage(ChatColor.BLUE + sender.getName()
                            + " has somehow distorted your vision!");
                } else {
                    sender.sendMessage(ChatColor.RED
                            + "You don't have permission to use this command.");
                }
            } else
                sender.sendMessage(ChatColor.BLUE
                        + "Usage: /superdistort <player>");
        }
        return false;
    }
}