package com.live.macsephi.Blade;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class CarveBladeCommand
  implements CommandExecutor
{
  private final Frenz me;

  public CarveBladeCommand(Frenz me)
  {
    this.me = me;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.me.hasPermission(player, "MobEffects.carveblade")) {
        if (this.me.carve.contains(player)) {
          this.me.carve.remove(player);
          player.sendMessage(ChatColor.BLUE + "You have returned your blade to normal.");
          return true;
        }
        this.me.carve.add(player);
        player.sendMessage(ChatColor.BLUE + "You carved the edge of your blade to enhance damage.");
        player.sendMessage(ChatColor.BLUE + "[STR Lvl-1]");
        return true;
      }

      player.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command.");
    }

    return false;
  }
}