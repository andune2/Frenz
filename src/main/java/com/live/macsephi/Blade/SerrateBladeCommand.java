package com.live.macsephi.Blade;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SerrateBladeCommand
  implements CommandExecutor
{
  private final Frenz me;

  public SerrateBladeCommand(Frenz me)
  {
    this.me = me;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.me.hasPermission(player, "MobEffects.serrateblade")) {
        if (this.me.serrate.contains(player)) {
          this.me.serrate.remove(player);
          player.sendMessage(ChatColor.BLUE + "You have returned your blade to normal.");
          return true;
        }
        this.me.serrate.add(player);
        player.sendMessage(ChatColor.BLUE + "You serrated the tip and base of your blade to have sharp teeth.");
        player.sendMessage(ChatColor.BLUE + "[STR Lvl-3]");
        return true;
      }
      player.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command.");
    }

    return false;
  }
}