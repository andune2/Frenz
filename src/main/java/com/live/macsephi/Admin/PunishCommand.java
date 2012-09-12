package com.live.macsephi.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class PunishCommand implements CommandExecutor {
    private final Frenz me;

    public PunishCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.punish")) {
                if ((args.length == 1)
                        && (this.me.getServer().getPlayer(args[0]) != null)) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    if (player != target) {
                        this.me.setMobEffect(target, 9, 12000, 5);
                        this.me.setMobEffect(target, 2, 12000, 5);
                        this.me.setMobEffect(target, 4, 12000, 5);
                        this.me.setMobEffect(target, 18, 12000, 5);
                        this.me.setMobEffect(target, 15, 12000, 5);
                        for (Player p : this.me.getServer().getOnlinePlayers()) {
                            if (p == player) {
                                player.sendMessage(ChatColor.DARK_RED
                                        + "You have inflicted punishment upon "
                                        + target.getName() + "!");
                            } else if (p == target) {
                                target.sendMessage(ChatColor.DARK_RED
                                        + player.getName()
                                        + " has inflicted punishment upon you!");
                            } else
                                p.sendMessage(ChatColor.DARK_RED
                                        + player.getName()
                                        + " has inflicted punishment upon "
                                        + target.getName() + "!");
                        }
                        return true;
                    }
                    player.sendMessage(ChatColor.DARK_RED
                            + "You can't punish yourself!");
                } else {
                    player.sendMessage("Usage: /punish <player>");
                }
            } else
                player.sendMessage(ChatColor.DARK_RED
                        + "You don't have permission to use this command.");
        }

        return false;
    }
}