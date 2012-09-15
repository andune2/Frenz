//Mackenzie - Removed no longer used array variables with the implementation of MiningCommands class.

package com.live.macsephi.MiscCommands;

import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MobEffect;
import net.minecraft.server.Packet42RemoveMobEffect;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class OffCommand implements CommandExecutor {
    private final Frenz me;

    public OffCommand(Frenz instance) {
        this.me = instance;
    }
    public void setMobEffect(LivingEntity entity, int type, int duration, int amplifier) {
        ((CraftLivingEntity) entity).getHandle().addEffect(new MobEffect(type, duration, amplifier));
    }
    public void removeMobEffect(LivingEntity entity, int type) {
            if ((entity instanceof Player)) {
                EntityPlayer player = ((CraftPlayer) entity).getHandle();
                player.netServerHandler.sendPacket(new Packet42RemoveMobEffect(player.id, new MobEffect(type, 0, 0)));
            }
            }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            Player targetPlayer = null;

            if (args.length == 1) {
                targetPlayer = this.me.getServer().getPlayer(args[0]);
            }

            if (this.me.hasPluginPermission(player, "off")) {
                if ((this.me.hasPluginPermission(player, "off.other"))
                        && (args.length == 1) && (targetPlayer != null)
                        && (targetPlayer != player)) {
                    if (this.me.sDivine.contains(targetPlayer)) {
                        this.me.sDivine.remove(targetPlayer);
                    }
                    this.removeMobEffect(targetPlayer, 1);
                    this.removeMobEffect(targetPlayer, 3);
                    targetPlayer.sendMessage(ChatColor.BLUE + player.getName()
                            + " has drained your supernatural senses.");
                    player.sendMessage(ChatColor.BLUE + "You have drained "
                            + targetPlayer.getName()
                            + "'s supernatural senses.");
                    return true;
                }

                if (args.length == 0) {
                    if (this.me.sDivine.contains(player)) {
                        this.me.sDivine.remove(player);
                    }
                    this.removeMobEffect(player, 1);
                    this.removeMobEffect(player, 3);
                    player.sendMessage(ChatColor.BLUE
                            + "You feel your supernatural senses subside.");
                    return true;
                }
            } else {
                player.sendMessage(ChatColor.RED
                        + "You don't have permission to use this command.");
            }
        }
        return false;
    }
}