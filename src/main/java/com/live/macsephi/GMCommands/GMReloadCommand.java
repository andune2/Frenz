package com.live.macsephi.GMCommands;

import java.util.logging.Logger;
import org.anjocaido.groupmanager.GroupManager;
import org.anjocaido.groupmanager.dataholder.worlds.WorldsHolder;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.live.macsephi.Frenz;

public class GMReloadCommand
  implements CommandExecutor
{
  private GroupManager gm;
  private WorldsHolder holder;
  private Frenz me;

  public GMReloadCommand(Frenz me)
  {
    this.me = me;
    if (this.gm == null) this.gm = ((GroupManager)me.getServer().getPluginManager().getPlugin("GroupManager"));
    this.holder = this.gm.getWorldsHolder();
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.me.hasPermission(player, "MobEffects.reloadgm")) {
        this.holder.reloadAll();
        player.sendMessage(ChatColor.GREEN + "GroupManager has been reloaded.");
        return true;
      }
      player.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command!");
    }
    else {
      this.holder.reloadAll();
      Frenz.log.info("[MobEffects] GroupManager has been reloaded.");
      return true;
    }
    return false;
  }
}