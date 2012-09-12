package com.live.macsephi.Blade;

import java.io.PrintStream;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class DeathBladeCommand implements CommandExecutor {
    private final Frenz me;

    public DeathBladeCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.deathblade")) {
                if (this.me.death.contains(player)) {
                    this.me.death.remove(player);
                    player.sendMessage(ChatColor.BLACK
                            + "Your deathly aura has returned to the void from whence it came!");
                    return true;
                }
                this.me.death.add(player);
                player.sendMessage(ChatColor.BLACK
                        + "A deathly shroud forms around you, an aura visible to all in your presence!");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command!");
        } else {
            System.out.println("Only players can use this command!");
        }
        return false;
    }
}