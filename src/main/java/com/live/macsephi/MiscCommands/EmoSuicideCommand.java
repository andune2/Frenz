package com.live.macsephi.MiscCommands;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import com.live.macsephi.Frenz;

public class EmoSuicideCommand
  implements CommandExecutor
{
  private final Frenz me;

  public EmoSuicideCommand(Frenz instance)
  {
    this.me = instance;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.me.hasPermission(player, "MobEffects.emosuicide")) {
        this.me.isEmo.add(player);
        this.me.setMobEffect(player, 7, 20, 1);
        this.me.getServer().getScheduler().scheduleSyncDelayedTask(this.me, new Runnable(player)
        {
          public void run()
          {
            EmoSuicideCommand.this.me.setMobEffect(this.val$player, 7, 20, 1);
          }
        }
        , 20L);
        return true;
      }
      player.sendMessage(ChatColor.RED + "You don't have permission to commit emosuicide.");
    }

    return false;
  }
}