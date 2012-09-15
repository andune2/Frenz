package com.live.macsephi.MiscCommands;

import net.minecraft.server.MobEffect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SuperDistortCommand implements CommandExecutor {
    private final Frenz me;

    public SuperDistortCommand(Frenz instance) {
        this.me = instance;
    }
    public void setMobEffect(LivingEntity entity, int type, int duration,
            int amplifier) {
        ((CraftLivingEntity) entity).getHandle().addEffect(
                new MobEffect(type, duration, amplifier));
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if (args.length == 1) {
                if (this.me.hasPluginPermission(player, "superdistort")) {
                    if (this.me.getServer().getPlayer(args[0]) == null) {
                        player.sendMessage(ChatColor.RED
                                + "Player does not exist");
                        return false;
                    }
                    Player targetPlayer = this.me.getServer()
                            .getPlayer(args[0]);
                    this.setMobEffect(targetPlayer, 9, 1800, 5);
                    player.sendMessage(ChatColor.BLUE
                            + "You have somehow distorted "
                            + targetPlayer.getName() + "'s vision!");
                    targetPlayer.sendMessage(ChatColor.BLUE + sender.getName()
                            + " has somehow distorted your vision!");
                } else {
                    sender.sendMessage(ChatColor.RED
                            + "You don't have permission to use this command.");
                }
            } else
                sender.sendMessage(ChatColor.BLUE
                        + "Usage: /superdistort <player>");
        }
        return false;
    }
}