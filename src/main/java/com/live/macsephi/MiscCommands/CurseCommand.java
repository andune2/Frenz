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

public class CurseCommand implements CommandExecutor {
    private final Frenz me;

    public CurseCommand(Frenz me) {
        this.me = me;
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
            if ((this.me.hasPluginPermission(player, "curse"))
                    && ((args.length == 0) || (this.me.getServer().getPlayer(
                            args[0]) == player))) {
                this.setMobEffect(player, 19, 6000, 3);
                player.sendMessage(ChatColor.BLUE
                        + "You have cursed yourself with a poisonous spell!");
                return true;
            }
            if ((this.me.hasPluginPermission(player, "curse.other"))
                    && (this.me.getServer().getPlayer(args[0]) != player)
                    && (args.length == 1) && (!args[0].equalsIgnoreCase("off"))) {
                if (this.me.getServer().getPlayer(args[0]) == null) {
                    player.sendMessage(ChatColor.RED + "Player does not exist!");
                    return false;
                }
                Player target = this.me.getServer().getPlayer(args[0]);
                this.setMobEffect(target, 19, 6000, 3);
                for (Player p : this.me.getServer().getOnlinePlayers()) {
                    if (p == player) {
                        player.sendMessage(ChatColor.BLUE + "You have cursed "
                                + target.getName() + " with a poisonous spell!");
                    } else if (p == target) {
                        target.sendMessage(ChatColor.BLUE + player.getName()
                                + " has cursed you with a poisonous spell!");
                    } else
                        p.sendMessage(ChatColor.BLUE + player.getName()
                                + " has cursed " + target.getName()
                                + " with a poisonous spell!");
                }
                return true;
            }
            if ((args[0].equalsIgnoreCase("off"))
                    && (this.me.hasPluginPermission(player, "uncurse"))
                    && ((args.length == 1) || (this.me.getServer().getPlayer(
                            args[1]) == player))) {
                this.removeMobEffect(player, 19);
                player.sendMessage(ChatColor.BLUE
                        + "You have lifted your own curse.");
                return true;
            }
            if ((args[0].equalsIgnoreCase("off"))
                    && (this.me.hasPluginPermission(player,
                            "uncurse.other")) && (args.length == 2)) {
                if (this.me.getServer().getPlayer(args[1]) == null) {
                    player.sendMessage(ChatColor.RED + "Player does not exist!");
                    return false;
                }
                Player target = this.me.getServer().getPlayer(args[1]);
                this.removeMobEffect(target, 19);
                target.sendMessage(ChatColor.BLUE + player.getName()
                        + " has lifted your curse!");
                player.sendMessage(ChatColor.BLUE + "You have lifted "
                        + target.getName() + "'s curse!");
                return true;
            }
        }
        return false;
    }
}