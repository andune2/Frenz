package com.live.macsephi.MiscCommands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class OffCommand
  implements CommandExecutor
{
  private final Frenz me;

  public OffCommand(Frenz instance)
  {
    this.me = instance;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      Player targetPlayer = null;

      if (args.length == 1) {
        targetPlayer = this.me.getServer().getPlayer(args[0]);
      }

      if (this.me.hasPermission(player, "MobEffects.off")) {
        if ((this.me.hasPermission(player, "MobEffects.off.other")) && (args.length == 1) && (targetPlayer != null) && (targetPlayer != player)) {
          if (this.me.sDivine.contains(targetPlayer))
          {
            this.me.sDivine.remove(targetPlayer);
          }
          if (this.me.aDivine.contains(targetPlayer))
          {
            this.me.aDivine.remove(targetPlayer);
          }
          this.me.removeMobEffect(targetPlayer, 1);
          this.me.removeMobEffect(targetPlayer, 3);
          targetPlayer.sendMessage(ChatColor.BLUE + player.getName() + " has drained your supernatural senses.");
          player.sendMessage(ChatColor.BLUE + "You have drained " + targetPlayer.getName() + "'s supernatural senses.");
          return true;
        }

        if (args.length == 0) {
          if (this.me.sDivine.contains(player)) {
            this.me.sDivine.remove(player);
          }
          if (this.me.aDivine.contains(player)) {
            this.me.aDivine.remove(player);
          }
          this.me.removeMobEffect(player, 1);
          this.me.removeMobEffect(player, 3);
          player.sendMessage(ChatColor.BLUE + "You feel your supernatural senses subside.");
          return true;
        }
      }
      else {
        player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
      }
    }
    return false;
  }
}