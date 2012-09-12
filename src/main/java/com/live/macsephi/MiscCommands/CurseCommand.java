package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class CurseCommand implements CommandExecutor {
    private final Frenz me;

    public CurseCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if ((this.me.hasPermission(player, "MobEffects.curse"))
                    && ((args.length == 0) || (this.me.getServer().getPlayer(
                            args[0]) == player))) {
                this.me.setMobEffect(player, 19, 6000, 3);
                player.sendMessage(ChatColor.BLUE
                        + "You have cursed yourself with a poisonous spell!");
                return true;
            }
            if ((this.me.hasPermission(player, "MobEffects.curse.other"))
                    && (this.me.getServer().getPlayer(args[0]) != player)
                    && (args.length == 1) && (!args[0].equalsIgnoreCase("off"))) {
                if (this.me.getServer().getPlayer(args[0]) == null) {
                    player.sendMessage(ChatColor.RED + "Player does not exist!");
                    return false;
                }
                Player target = this.me.getServer().getPlayer(args[0]);
                this.me.setMobEffect(target, 19, 6000, 3);
                for (Player p : this.me.getServer().getOnlinePlayers()) {
                    if (p == player) {
                        player.sendMessage(ChatColor.BLUE + "You have cursed "
                                + target.getName() + " with a poisonous spell!");
                    } else if (p == target) {
                        target.sendMessage(ChatColor.BLUE + player.getName()
                                + " has cursed you with a poisonous spell!");
                    } else
                        p.sendMessage(ChatColor.BLUE + player.getName()
                                + " has cursed " + target.getName()
                                + " with a poisonous spell!");
                }
                return true;
            }
            if ((args[0].equalsIgnoreCase("off"))
                    && (this.me.hasPermission(player, "MobEffects.uncurse"))
                    && ((args.length == 1) || (this.me.getServer().getPlayer(
                            args[1]) == player))) {
                this.me.removeMobEffect(player, 19);
                player.sendMessage(ChatColor.BLUE
                        + "You have lifted your own curse.");
                return true;
            }
            if ((args[0].equalsIgnoreCase("off"))
                    && (this.me.hasPermission(player,
                            "MobEffects.uncurse.other")) && (args.length == 2)) {
                if (this.me.getServer().getPlayer(args[1]) == null) {
                    player.sendMessage(ChatColor.RED + "Player does not exist!");
                    return false;
                }
                Player target = this.me.getServer().getPlayer(args[1]);
                this.me.removeMobEffect(target, 19);
                target.sendMessage(ChatColor.BLUE + player.getName()
                        + " has lifted your curse!");
                player.sendMessage(ChatColor.BLUE + "You have lifted "
                        + target.getName() + "'s curse!");
                return true;
            }
        }
        return false;
    }
}