package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class FoodCommand implements CommandExecutor {
    Frenz me;

    public FoodCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("fitforaking")) {
                    if (this.me.hasPermission(player, "MobEffects.food.king")) {
                        player.setFoodLevel(20);
                        player.sendMessage(ChatColor.GREEN
                                + "Your food bar has been filled!");
                        return true;
                    }
                    player.sendMessage(ChatColor.DARK_RED
                            + "You don't have permission to use this command.");
                }

                if (args[0].equalsIgnoreCase("snack")) {
                    if (this.me.hasPermission(player, "MobEffects.food.snack")) {
                        if (player.getFoodLevel() > 14) {
                            player.setFoodLevel(20);
                        }
                        player.setFoodLevel(player.getFoodLevel() + 6);
                        player.sendMessage(ChatColor.GREEN
                                + "You've eaten a snack!");
                        return true;
                    }
                    player.sendMessage(ChatColor.DARK_RED
                            + "You don't have permission to use this command.");
                }

                if (args[0].equalsIgnoreCase("meal")) {
                    if (this.me.hasPermission(player, "MobEffects.food.meal")) {
                        if (player.getFoodLevel() > 10) {
                            player.setFoodLevel(20);
                        }
                        player.setFoodLevel(player.getFoodLevel() + 10);
                        player.sendMessage(ChatColor.GREEN
                                + "You've eaten a meal!");
                        return true;
                    }
                    player.sendMessage(ChatColor.DARK_RED
                            + "You don't have permission to use this command.");
                }
            }
        }

        return false;
    }
}