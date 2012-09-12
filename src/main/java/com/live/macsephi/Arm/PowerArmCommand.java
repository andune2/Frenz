package com.live.macsephi.Arm;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class PowerArmCommand
  implements CommandExecutor
{
  private final Frenz me;

  public PowerArmCommand(Frenz me)
  {
    this.me = me;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.me.hasPermission(player, "MobEffects.powerarm")) {
        this.me.setMobEffect(player, 3, 4800, 3);
        player.sendMessage(ChatColor.BLUE + "Your arms power-up, making tools feel almost weightless to you.");
        player.sendMessage(ChatColor.BLUE + "[DEX Lvl-3]");
        return true;
      }
      player.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command.");
    }

    return false;
  }
}