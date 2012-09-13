package com.live.macsephi.Speed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.live.macsephi.Frenz;

public class HyperSpeedCommand implements CommandExecutor {
    private Player player;
    private final Frenz me;

    public HyperSpeedCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            this.player = ((Player) sender);
            if (me.hasPluginPermission(this.player, "hyperspeed")) {
                this.me.setMobEffect(this.player, 1, 7800, 4);
                this.me.getServer().getScheduler()
                        .scheduleSyncDelayedTask(this.me, new Runnable() {
                            public void run() {
                                if (HyperSpeedCommand.this.player
                                        .hasPotionEffect(PotionEffectType.SPEED))
                                    HyperSpeedCommand.this.player
                                            .sendMessage(ChatColor.BLUE
                                                    + "Your energy fades with time, and your speed has returned to normal.");
                            }
                        }, 7750L);
                this.player
                        .sendMessage(ChatColor.BLUE
                                + "A massive adrenaline overtakes your body, making everything around you seem to be moving very slowly.");
                this.player.sendMessage(ChatColor.BLUE + "[SPD Lvl-4]");
                return true;
            }

            this.player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}