package com.live.macsephi.Speed;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import com.live.macsephi.Frenz;

public class HiSpeedCommand
  implements CommandExecutor
{
  private Player player;
  private final Frenz me;

  public HiSpeedCommand(Frenz instance)
  {
    this.me = instance;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player))
    {
      this.player = ((Player)sender);
      if (Frenz.hasPermissions(this.player, "MobEffects.hispeed"))
      {
        this.me.setMobEffect(this.player, 1, 3000, 2);
        this.me.getServer().getScheduler().scheduleSyncDelayedTask(this.me, new Runnable()
        {
          public void run()
          {
            if (HiSpeedCommand.this.player.hasPotionEffect(PotionEffectType.SPEED))
              HiSpeedCommand.this.player.sendMessage(ChatColor.BLUE + "Your energy fades with time, and your speed has returned to normal.");
          }
        }
        , 2950L);
        this.player.sendMessage(ChatColor.BLUE + "You feel you can outrun any olympic expert.");
        this.player.sendMessage(ChatColor.BLUE + "[SPD Lvl-2]");
        return true;
      }

      this.player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
    }

    return false;
  }
}