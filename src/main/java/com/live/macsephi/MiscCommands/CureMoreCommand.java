package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class CureMoreCommand implements CommandExecutor {
    private final Frenz me;

    public CureMoreCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.curemore")) {
                if ((this.me.hasPermission(player, "MobEffects.curemore.other"))
                        && (args.length == 1)) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    if (target == null) {
                        player.sendMessage(ChatColor.DARK_RED
                                + "Player does not exist!");
                        return false;
                    }
                    if (target.getHealth() <= 10)
                        target.setHealth(target.getHealth() + 10);
                    else {
                        target.setHealth(20);
                    }
                    target.sendMessage(ChatColor.GREEN + player.getName()
                            + " cast Cura on you!");
                    target.sendMessage(ChatColor.GREEN + "[RES Lvl-2]");
                    player.sendMessage(ChatColor.GREEN + "You cast Cura on "
                            + target.getName() + "!");
                    player.sendMessage(ChatColor.GREEN + "[RES Lvl-2]");
                    return true;
                }

                if (player.getHealth() <= 10)
                    player.setHealth(player.getHealth() + 10);
                else {
                    player.setHealth(20);
                }
                player.sendMessage(ChatColor.GREEN
                        + "You cast Cura on yourself!");
                player.sendMessage(ChatColor.GREEN + "[RES Lvl-2]");
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}