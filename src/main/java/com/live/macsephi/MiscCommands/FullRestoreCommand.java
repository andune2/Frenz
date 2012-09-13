package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class FullRestoreCommand implements CommandExecutor {
    private final Frenz me;

    public FullRestoreCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "fullrestore")) {
                if ((args.length > 0)
                        && (this.me.hasPluginPermission(player,
                                "fullrestore.other"))) {
                    Player targetPlayer = this.me.getServer()
                            .getPlayer(args[0]);

                    if (targetPlayer == null) {
                        player.sendMessage(ChatColor.RED
                                + "Player does not exist!");
                        return false;
                    }

                    if (targetPlayer != player) {
                        targetPlayer.setHealth(20);
                        targetPlayer.sendMessage(ChatColor.GREEN
                                + player.getName() + " cast Full-Cure on you!");
                        targetPlayer.sendMessage(ChatColor.GREEN
                                + "[RES Lvl-3]");
                        player.sendMessage(ChatColor.GREEN
                                + "You cast Full-Cure on "
                                + targetPlayer.getName() + "!");
                        player.sendMessage(ChatColor.GREEN + "[RES Lvl-3]");
                        return true;
                    }
                }
                player.setHealth(20);
                player.sendMessage(ChatColor.GREEN
                        + "You cast Full-Cure on yourself!");
                player.sendMessage(ChatColor.GREEN + "[RES Lvl-3]");
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}