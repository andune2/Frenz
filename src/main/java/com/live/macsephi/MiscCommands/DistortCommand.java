package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class DistortCommand implements CommandExecutor {
    private Player player;
    private Player targetPlayer;
    private final Frenz me;

    public DistortCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            this.player = ((Player) sender);
            if (args.length == 0) {
                if (this.me.hasPluginPermission(this.player, "distort")) {
                    this.me.setMobEffect(this.player, 9, 1800, 5);
                    this.player.sendMessage(ChatColor.BLUE
                            + "You have distorted your own vision!");
                    return true;
                }
            } else if ((args.length > 0) && (args[0].equalsIgnoreCase("off"))) {
                if ((args.length == 2)
                        && (this.me.hasPluginPermission(this.player,
                                "distort.off"))) {
                    if (this.me.getServer().getPlayer(args[1]) == null) {
                        this.player.sendMessage(ChatColor.RED
                                + "Player does not exist!");
                        return false;
                    }
                    this.targetPlayer = this.me.getServer().getPlayer(args[1]);
                    this.me.removeMobEffect(this.targetPlayer, 9);
                    this.player.sendMessage(ChatColor.BLUE
                            + "You have cleared " + this.targetPlayer.getName()
                            + "'s distortion!");
                    this.targetPlayer.sendMessage(ChatColor.BLUE
                            + this.player.getName()
                            + " has cured your distortion!");
                    return true;
                }
                if (this.me.hasPluginPermission(this.player, "distort")) {
                    this.me.removeMobEffect(this.player, 9);
                    this.player.sendMessage(ChatColor.BLUE
                            + "You have cured your distortion!");
                    return true;
                }
            }
            if ((args.length > 0)
                    && (this.me
                            .hasPluginPermission(this.player, "distort"))) {
                if (this.me.getServer().getPlayer(args[0]) == null) {
                    this.player.sendMessage(ChatColor.RED
                            + "Player does not exist!");
                    return false;
                }
                this.targetPlayer = this.me.getServer().getPlayer(args[0]);
                if (this.me.hasPluginPermission(this.targetPlayer,
                        "distort.override")) {
                    this.player.sendMessage(ChatColor.BLUE
                            + this.targetPlayer.getName()
                            + "'s vision is immune to distortion!");
                    this.targetPlayer.sendMessage(ChatColor.BLUE
                            + this.player.getName()
                            + " tried to distort your vision!");
                    return true;
                }
                this.me.setMobEffect(this.targetPlayer, 9, 1800, 5);
                this.player.sendMessage(ChatColor.BLUE + "You have distorted "
                        + this.targetPlayer.getName() + "'s vision!");
                this.targetPlayer
                        .sendMessage(ChatColor.BLUE + this.player.getName()
                                + " has distorted your vision!");
                return true;
            }

            this.player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }
        return false;
    }
}