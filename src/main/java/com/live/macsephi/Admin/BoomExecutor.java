package com.live.macsephi.Admin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;

import com.live.macsephi.Frenz;

public class BoomExecutor implements CommandExecutor {
    private static final Logger log = Bukkit.getLogger();
    private final Frenz me;

    public BoomExecutor(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if (command.getName().equalsIgnoreCase("boom")) {
            if ((sender instanceof Player)) {
                Player player = (Player) sender;
                if (this.me.hasPermission(player, "MobEffects.boom")) {
                    if (args.length == 1) {
                        Player target = this.me.getServer().getPlayer(args[0]);
                        if (target != null) {
                            TNTPrimed tnt = (TNTPrimed) target.getWorld()
                                    .spawn(target.getLocation(),
                                            TNTPrimed.class);
                            this.me.tntPrimed.add(tnt);
                            tnt.setFuseTicks(0);
                            this.me.getServer().broadcastMessage(
                                    ChatColor.GRAY + target.getName()
                                            + " went boom!");
                        } else {
                            player.sendMessage(ChatColor.RED
                                    + "Player does not exist or is offline.");
                        }
                        return true;
                    }
                    player.sendMessage("Usage: /boom <player>");
                } else {
                    player.sendMessage(ChatColor.RED
                            + "You don't have permission to use that command.");
                }
            } else {
                if (args.length == 1) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    if (target != null) {
                        TNTPrimed tnt = (TNTPrimed) target.getWorld().spawn(
                                target.getLocation(), TNTPrimed.class);
                        this.me.tntPrimed.add(tnt);
                        tnt.setFuseTicks(0);
                        this.me.getServer().broadcastMessage(
                                ChatColor.GRAY + target.getName()
                                        + " went boom!");
                    } else {
                        log.info("[MobEffects] Player does not exist or is offline.");
                    }
                    return true;
                }
                log.info("Usage: /boom <player>");
            }

        }

        if ((command.getName().equalsIgnoreCase("implode"))
                && ((sender instanceof Player))) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.implode")) {
                TNTPrimed tnt = (TNTPrimed) player.getWorld().spawn(
                        player.getLocation(), TNTPrimed.class);
                this.me.tntPrimed.add(tnt);
                tnt.setFuseTicks(0);
                return true;
            }
            player.sendMessage(ChatColor.RED
                    + "You don't have permission to use this command.");
        }

        if ((command.getName().equalsIgnoreCase("napalm"))
                && ((sender instanceof Player))) {
            Player player = (Player) sender;
            if (this.me.hasPermission(player, "MobEffects.napalm")) {
                if (args.length == 1) {
                    Player target = this.me.getServer().getPlayer(args[0]);
                    if (target != null) {
                        TNTPrimed napalm = (TNTPrimed) target.getWorld().spawn(
                                target.getLocation(), TNTPrimed.class);
                        this.me.napalm.add(napalm);
                        napalm.setFuseTicks(0);
                        napalm.setIsIncendiary(true);
                        napalm.setYield(10.0F);
                        this.me.getServer().broadcastMessage(
                                ChatColor.DARK_RED + target.getName()
                                        + " has been struck by napalm!");
                    } else {
                        player.sendMessage(ChatColor.RED
                                + "Player does not exist or is offline.");
                    }
                    return true;
                }
                player.sendMessage("Usage: /napalm <player>");
            } else {
                player.sendMessage(ChatColor.RED
                        + "You don't have permission to use this command.");
            }
        }

        return false;
    }
}