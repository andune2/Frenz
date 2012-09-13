package com.live.macsephi.MiscCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class EmoSuicideCommand implements CommandExecutor {
    private final Frenz me;

    public EmoSuicideCommand(Frenz instance) {
        this.me = instance;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            final Player player = (Player) sender;
            if (this.me.hasPluginPermission(player, "emosuicide")) {
                this.me.isEmo.add(player);
                this.me.setMobEffect(player, 7, 20, 1);
                this.me.getServer().getScheduler()
                        .scheduleSyncDelayedTask(this.me, new Runnable() {
                            public void run() {
                                EmoSuicideCommand.this.me.setMobEffect(
                                        player, 7, 20, 1);
                            }
                        }, 20L);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to commit emosuicide.");
        }

        return false;
    }
}