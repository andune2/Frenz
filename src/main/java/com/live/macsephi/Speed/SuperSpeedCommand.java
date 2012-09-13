package com.live.macsephi.Speed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.live.macsephi.Frenz;

public class SuperSpeedCommand implements CommandExecutor {
    private Player player;
    private final Frenz me;

    public SuperSpeedCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            this.player = ((Player) sender);
            if (me.hasPluginPermission(this.player, "superspeed")) {
                this.me.setMobEffect(this.player, 1, 4800, 3);
                this.me.getServer().getScheduler()
                        .scheduleSyncDelayedTask(this.me, new Runnable() {
                            public void run() {
                                if (SuperSpeedCommand.this.player
                                        .hasPotionEffect(PotionEffectType.SPEED))
                                    SuperSpeedCommand.this.player
                                            .sendMessage(ChatColor.BLUE
                                                    + "Your energy fades with time, and your speed has returned to normal.");
                            }
                        }, 4750L);
                this.player
                        .sendMessage(ChatColor.BLUE
                                + "Your legs tense up and buff to appear larger in circumfrence, enabling you to outrun even the fastest animals.");
                this.player.sendMessage(ChatColor.BLUE + "[SPD Lvl-3]");
            } else {
                this.player.sendMessage(ChatColor.RED
                        + "You don't have permission to use this command.");
            }
        }
        return false;
    }
}