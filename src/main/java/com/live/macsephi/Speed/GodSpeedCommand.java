package com.live.macsephi.Speed;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import com.live.macsephi.Frenz;

public class GodSpeedCommand implements CommandExecutor {
    private Player player;
    private final Frenz me;

    public GodSpeedCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            this.player = ((Player) sender);
            if (me.hasPluginPermission(this.player, "godspeed")) {
                this.me.setMobEffect(this.player, 1, 9600, 5);
                this.me.getServer().getScheduler()
                        .scheduleSyncDelayedTask(this.me, new Runnable() {
                            public void run() {
                                if (GodSpeedCommand.this.player
                                        .hasPotionEffect(PotionEffectType.SPEED))
                                    GodSpeedCommand.this.player
                                            .sendMessage(ChatColor.BLUE
                                                    + "Your energy fades with time, and your speed has returned to normal.");
                            }
                        }, 9550L);
                this.player
                        .sendMessage(ChatColor.BLUE
                                + "Your legs begin to wobble as an electrified, radioactive current courses through your veins, causing a molecular reaction to amplify the speed at which your body can move.");
                this.player.sendMessage(ChatColor.BLUE + "[SPD Lvl-5]");
                return true;
            }

            this.player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        return false;
    }
}