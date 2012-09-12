package com.live.macsephi.Arm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.live.macsephi.Frenz;

public class DivineArmCommand implements CommandExecutor {
    private final Frenz me;

    public DivineArmCommand(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.divinearm")) {
                if (this.me.aDivine.contains(player)) {
                    this.me.aDivine.remove(player);
                    player.removePotionEffect(PotionEffectType.FAST_DIGGING);
                    player.sendMessage(ChatColor.YELLOW
                            + "Every drop of the divine energy in your arms has been drained.");
                }
                this.me.setMobEffect(player, 3, 12000, 6);
                this.me.aDivine.add(player);
                player.sendMessage(ChatColor.YELLOW
                        + "You raise your arms up high and pray to be physically empowered. The gods adhere your wish, buffing your biceps and forearms to replicate even tree trunks.");
                player.sendMessage(ChatColor.YELLOW + "[DEX Lvl-6]");
                return true;
            }
            player.sendMessage(ChatColor.DARK_RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}