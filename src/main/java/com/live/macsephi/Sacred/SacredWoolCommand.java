package com.live.macsephi.Sacred;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SacredWoolCommand
  implements CommandExecutor
{
  private final FileConfiguration config;
  private final Frenz me;

  public SacredWoolCommand(Frenz me, FileConfiguration config)
  {
    this.me = me;
    this.config = config;
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;
      if (this.me.hasPermission(player, "MobEffects.sacredwool")) {
        if (args.length == 1) {
          if (args[0].equalsIgnoreCase("1")) {
            Location loc = player.getLocation();
            String location = loc.getBlockX() + "_" + loc.getBlockY() + "_" + loc.getBlockZ();
            this.config.set("SacredWool.FirstLocation", location);
            this.me.saveConfig();
            player.sendMessage(ChatColor.GREEN + "First Location has been set.");
            return true;
          }
          if (args[0].equalsIgnoreCase("2")) {
            Location loc = player.getLocation();
            String location = loc.getBlockX() + "_" + loc.getBlockY() + "_" + loc.getBlockZ();
            this.config.set("SacredWool.SecondLocation", location);
            this.me.saveConfig();
            player.sendMessage(ChatColor.GREEN + "Second Location has been set.");
            return true;
          }
          if (args[0].equalsIgnoreCase("setworld")) {
            this.config.set("SacredWool.World", player.getWorld().getName());
            this.me.saveConfig();
            player.sendMessage(ChatColor.GREEN + "World has been set.");
            return true;
          }
        } else {
          player.sendMessage("Usage: /sacredwool <1|2|setworld>");
        }
      }
      else player.sendMessage(ChatColor.DARK_RED + "You don't have permission to use this command.");
    }

    return false;
  }
}