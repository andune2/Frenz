package com.live.macsephi.Blade;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class DivineBladeCommand implements CommandExecutor {
    private final Frenz me;

    public DivineBladeCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.divineblade")) {
                if (this.me.bDivine.contains(player)) {
                    this.me.bDivine.remove(player);
                    player.sendMessage(ChatColor.YELLOW
                            + "You have returned your blade to normal.");
                    return true;
                }
                this.me.bDivine.add(player);
                player.sendMessage(ChatColor.YELLOW
                        + "You raise your sword high in the air and wish to empower it. The gods adhere your wish, upgrading your sword to be unmatched by any other.");
                player.sendMessage(ChatColor.YELLOW + "[STR Lvl-6]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}