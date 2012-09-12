package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class CureCommand implements CommandExecutor {
    private final Frenz me;

    public CureCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.cure")) {
                if ((this.me.hasPermission(player, "MobEffects.cure.other"))
                        && (args.length == 1)) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    if (target != player) {
                        if (target == null) {
                            player.sendMessage(ChatColor.DARK_RED
                                    + "Player does not exist!");
                            return false;
                        }
                        if (target.getHealth() > 15)
                            target.setHealth(20);
                        else {
                            target.setHealth(20);
                        }
                        target.sendMessage(ChatColor.GREEN + player.getName()
                                + " cast Cure on you!");
                        target.sendMessage(ChatColor.GREEN + "[RES Lvl-1]");
                        player.sendMessage(ChatColor.GREEN
                                + "You cast Cure on " + target.getName() + "!");
                        player.sendMessage(ChatColor.GREEN + "[RES Lvl-1]");
                        return true;
                    }
                }

                if (player.getHealth() > 15)
                    player.setHealth(20);
                else {
                    player.setHealth(player.getHealth() + 5);
                }
                player.sendMessage(ChatColor.GREEN
                        + "You cast Cure on yourself!");
                player.sendMessage(ChatColor.GREEN + "[RES Lvl-1]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}