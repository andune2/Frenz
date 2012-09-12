package com.live.macsephi.Sacred;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerMoveEvent;

import com.live.macsephi.Frenz;

public class SacredListener
  implements Listener
{
  private final Frenz me;
  private final FileConfiguration config;

  public SacredListener(Frenz me, FileConfiguration config)
  {
    this.me = me;
    this.config = config;
  }
  @EventHandler(ignoreCancelled=true)
  public void onPlayerMove(PlayerMoveEvent event) {
    Player player = event.getPlayer();

    if (this.me.hasPermission(player, "MobEffects.sacredwool")) return;

    if (this.config.getString("SacredWool.World") == null) return;
    World world = this.me.getServer().getWorld(this.config.getString("SacredWool.World"));
    if (world == null) return;

    if (player.getWorld().getName().equals(world.getName()))
    {
      if (this.config.getString("SacredWool.FirstLocation") == null) return;
      if (this.config.getString("SacredWool.SecondLocation") == null) return;

      int X1 = Integer.valueOf(this.config.getString("SacredWool.FirstLocation").split("_")[0]).intValue();
      int X2 = Integer.valueOf(this.config.getString("SacredWool.SecondLocation").split("_")[0]).intValue();
      int Y1 = Integer.valueOf(this.config.getString("SacredWool.FirstLocation").split("_")[1]).intValue();
      int Y2 = Integer.valueOf(this.config.getString("SacredWool.SecondLocation").split("_")[1]).intValue();
      int Z1 = Integer.valueOf(this.config.getString("SacredWool.FirstLocation").split("_")[2]).intValue();
      int Z2 = Integer.valueOf(this.config.getString("SacredWool.SecondLocation").split("_")[2]).intValue();

      int bigX = X1; int smallX = X2;
      if (X2 > X1) {
        bigX = X2;
        smallX = X1;
      }

      int bigY = Y1; int smallY = Y2;
      if (Y2 > Y1) {
        bigY = Y2;
        smallY = Y1;
      }

      int bigZ = Z1; int smallZ = Z2;
      if (Z2 > Z1) {
        bigZ = Z2;
        smallZ = Z1;
      }

      Location loc = event.getTo();
      if ((loc.getX() < smallX) || (loc.getX() > bigX)) return;
      if ((loc.getY() < smallY) || (loc.getY() > bigY)) return;
      if ((loc.getZ() < smallZ) || (loc.getZ() > bigZ)) return;

      Block block = world.getBlockAt(loc.subtract(0.0D, 1.0D, 0.0D));
      Block otherBlock = world.getBlockAt(loc.subtract(0.0D, 2.0D, 0.0D));
      if ((isPinkWool(block)) || (isPinkWool(otherBlock))) {
        if (player.getGameMode() == GameMode.CREATIVE) {
          player.setGameMode(GameMode.SURVIVAL);
        }
        player.setFireTicks(100);
        for (int i = 0; i < 5; i++) {
          world.strikeLightning(player.getLocation());
        }
        if (!player.isDead()) {
          player.setHealth(0);
          player.setLastDamageCause(new EntityDamageEvent(player, EntityDamageEvent.DamageCause.LIGHTNING, 5));
        }
      }
    }
  }

  private boolean isPinkWool(Block block) {
    return (block.getType() == Material.WOOL) && (block.getData() == 14);
  }
}