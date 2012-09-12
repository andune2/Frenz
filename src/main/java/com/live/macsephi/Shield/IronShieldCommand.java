package com.live.macsephi.Shield;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class IronShieldCommand
  implements CommandExecutor
{
  private final Frenz plugin;

  public IronShieldCommand(Frenz plugin)
  {
    this.plugin = plugin;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.plugin.hasPermission(player, "MobEffects.ironshield")) {
        if (this.plugin.iron.contains(player)) {
          this.plugin.iron.remove(player);
          player.sendMessage(ChatColor.BLUE + "You have returned to being mortal.");
          return true;
        }
        player.sendMessage(ChatColor.BLUE + "You feel a sudden sense of external metallic fusion, and feel as tough as a tank.");
        player.sendMessage(ChatColor.BLUE + "[DEF Lvl-4]");
        this.plugin.iron.add(player);
        return true;
      }
      player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
    }

    return false;
  }
}