package com.live.macsephi.Admin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class FreeCommand implements CommandExecutor {
    private final Frenz me;

    public FreeCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.free")) {
                if ((args.length == 1)
                        && (this.me.getServer().getPlayer(args[0]) != null)) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    this.me.removeMobEffect(target, 9);
                    this.me.removeMobEffect(target, 2);
                    this.me.removeMobEffect(target, 4);
                    this.me.removeMobEffect(target, 15);
                    this.me.removeMobEffect(target, 18);
                    for (Player p : this.me.getServer().getOnlinePlayers()) {
                        if ((p == target) && (p == player)) {
                            player.sendMessage(ChatColor.BLUE
                                    + "You have freed yourself from torment!");
                        } else if (p == player) {
                            player.sendMessage(ChatColor.BLUE
                                    + "You have freed " + target.getName()
                                    + " from torment!");
                        } else if (p == target) {
                            target.sendMessage(ChatColor.BLUE
                                    + player.getName()
                                    + " has freed you from your torment!");
                        } else
                            p.sendMessage(ChatColor.BLUE + player.getName()
                                    + " has freed " + target.getName()
                                    + " from torment!");
                    }
                    return true;
                }
                player.sendMessage("Usage: /free <player>");
            } else {
                player.sendMessage(ChatColor.DARK_RED
                        + "You don't have permission to use this command.");
            }
        }
        return false;
    }
}