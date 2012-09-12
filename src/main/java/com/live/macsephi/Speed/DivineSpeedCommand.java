package com.live.macsephi.Speed;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class DivineSpeedCommand
  implements CommandExecutor
{
  private Player player;
  private final Frenz me;

  public DivineSpeedCommand(Frenz instance)
  {
    this.me = instance;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      this.player = ((Player)sender);
      if (Frenz.hasPermissions(this.player, "MobEffects.divinespeed"))
      {
        if (this.me.sDivine.contains(this.player))
        {
          this.me.removeMobEffect(this.player, 1);
          this.me.sDivine.remove(this.player);
          this.player.sendMessage(ChatColor.YELLOW + "Your divine speed has subsided.");
          return true;
        }

        this.me.sDivine.add(this.player);

        this.me.setMobEffect(this.player, 1, 12000, 6);
        this.player.sendMessage(ChatColor.YELLOW + "You stare into the distant clouds, praying for an enhancement to your speed. The gods adhere your wish, converting your bloodstream and cells into a super-highway, faster than a live circuit.");
        this.player.sendMessage(ChatColor.YELLOW + "[SPD Lvl-6]");
        return true;
      }

      this.player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
    }

    return false;
  }
}