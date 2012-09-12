package com.live.macsephi;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AztecListener
  implements Listener
{
  private static final int CHANCE_OF_GIANT = 8;
  private static final int GIANT_XP_MULTIPLIER = 10;
  private static final List<Material> NONPHYSICAL_BLOCKS = Arrays.asList(new Material[] { Material.AIR, Material.WATER, Material.ARROW, 
    Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.CROPS, Material.DEAD_BUSH, Material.DETECTOR_RAIL, 
    Material.DIODE_BLOCK_OFF, Material.DIODE_BLOCK_ON, Material.ENDER_PORTAL, Material.FIRE, Material.FIREBALL, 
    Material.LEVER, Material.LONG_GRASS, Material.MELON_STEM, Material.NETHER_WARTS, 
    Material.PAINTING, Material.PORTAL, Material.POWERED_RAIL, Material.PUMPKIN_STEM, Material.RAILS, Material.RED_ROSE, 
    Material.REDSTONE, Material.REDSTONE_TORCH_OFF, Material.REDSTONE_TORCH_ON, Material.REDSTONE_WIRE, Material.SAPLING, 
    Material.SIGN_POST, Material.SNOW, Material.STATIONARY_WATER, Material.STONE_BUTTON, 
    Material.STONE_PLATE, Material.SUGAR_CANE_BLOCK, Material.TORCH, Material.WALL_SIGN, Material.WEB, 
    Material.WOOD_PLATE, Material.YELLOW_FLOWER });

  @EventHandler
  public void onEntityDeath(EntityDeathEvent event) { Random r = new Random();
    if ((event.getEntity().getWorld().getName().equalsIgnoreCase("aztec")) && 
      (event.getEntityType() == EntityType.GIANT)) {
      event.setDroppedExp(event.getDroppedExp() * 10);
      event.getDrops().clear();

      int fleshNum = (int)(42.0D * r.nextDouble());
      if (fleshNum < 7) {
        fleshNum = 7;
      }

      event.getDrops().add(new ItemStack(Material.ROTTEN_FLESH, fleshNum));
    }
  }

  @EventHandler(ignoreCancelled=true)
  public void onCreatureSpawn(CreatureSpawnEvent event)
  {
    Random r = new Random();
    World w = event.getLocation().getWorld();

    if ((w.getName().equalsIgnoreCase("aztec")) && 
      (event.getEntityType() == EntityType.ZOMBIE) && 
      (r.nextInt(100) < 8)) {
      event.setCancelled(true);
      w.spawnCreature(event.getLocation(), EntityType.GIANT);
    }

    if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG)
      event.setCancelled(true);
  }

  @EventHandler(ignoreCancelled=true)
  public void onBlockBreak(BlockBreakEvent event)
  {
    if (event.getBlock().getType() == Material.LADDER) return;
    if (event.getBlock().getWorld().getName().equalsIgnoreCase("aztec")) {
      String name = event.getPlayer().getName();
      if ((name.equalsIgnoreCase("FyreLord")) || (name.equalsIgnoreCase("Sunnywulf")) || (name.equalsIgnoreCase("zang"))) return;
      event.setCancelled(true);
    }
  }

  @EventHandler(priority=EventPriority.HIGHEST, ignoreCancelled=true)
  public void onPlayerInteract(PlayerInteractEvent event) {
    if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
      if ((event.getItem() != null) && (event.getItem().getTypeId() == 323) && 
        (event.getClickedBlock().getType() == Material.CHEST)) {
        event.setUseInteractedBlock(Event.Result.DENY);
        event.setUseItemInHand(Event.Result.DENY);
        event.setCancelled(true);
        event.getPlayer().sendMessage(BetterChatWrapper.wrapText(ChatColor.BLUE + "I'm afraid that due to a security bug I can't allow players to open chests while holding signs at this time. Please switch to a different item. -Fyre"));
      }

      if ((event.isBlockInHand()) && 
        (event.getPlayer().getWorld().getName().equalsIgnoreCase("aztec"))) {
        if ((event.getMaterial() == Material.LADDER) || (event.getItem().getType() == Material.LADDER)) return;
        String name = event.getPlayer().getName();
        if ((name.equalsIgnoreCase("FyreLord")) || (name.equalsIgnoreCase("Sunnywulf")) || (name.equalsIgnoreCase("zang"))) return;
        event.setCancelled(true);
        return;
      }

      if (event.hasItem()) {
        if ((event.getPlayer().getWorld().getName().equalsIgnoreCase("aztec")) && (
          (event.getMaterial() == Material.LAVA_BUCKET) || (event.getItem().getType() == Material.LAVA_BUCKET))) {
          event.setUseItemInHand(Event.Result.DENY);
          event.setCancelled(true);
        }

        if ((event.getMaterial() == Material.MONSTER_EGG) || (event.getItem().getType() == Material.MONSTER_EGG)) {
          event.setUseItemInHand(Event.Result.DENY);
          event.setCancelled(true);
          event.getPlayer().sendMessage(BetterChatWrapper.wrapText(ChatColor.RED + "The use of all mob spawners and spawner eggs has been temporarily disabled. -Fyre"));
        }
      }
    }
  }
}