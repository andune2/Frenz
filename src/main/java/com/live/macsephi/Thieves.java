package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class Thieves implements CommandExecutor {
	private Frenz plugin;

	public Thieves(Frenz instance) {
		this.plugin = instance;
	}
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = null;
        if( !(sender instanceof Player) ) {
            sender.sendMessage("Only players may use this command");   // tell console to buzz off
            return false;
        }
        else {
            player = (Player) sender;
        }
        
        final String cmdName = command.getName();
        
        if ((cmdName.equalsIgnoreCase("speed"))) {
            if (plugin.hasPluginPermission(player, "speed")) {
                if (plugin.sSpeed.contains(player)) {
                    plugin.unsetPotion(player, 1);
                    plugin.sSpeed.remove(player);
                    player.sendMessage(ChatColor.DARK_GRAY
                            +"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
                }
                else {
                    plugin.sSpeed.add(player);
                    plugin.setPotion(player, 1, 1800, 1);
                    player.sendMessage(ChatColor.GOLD
                            +"Y"+ChatColor.YELLOW + "ou feel a sudden sensation in your legs, as though you can" +
                            " run a marathon without breaking a sweat!");
                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
                            "1"+ChatColor.DARK_BLUE+"]");
                }

                //	player.sendMessage(ChatColor.DARK_RED
                //			+"Y"+ChatColor.RED+"ou require to possess at least 1 Diamond in your " +
                //					"inventory to use this ability.");
                //	return true;
            }
            else {
                player.sendMessage(ChatColor.DARK_RED
                        +"Y"+ChatColor.RED+"ou either need to join the Thieves' Guild," +
                        " or earn a higher rank within it.");
            }
        }
        else if ((cmdName.equalsIgnoreCase("hispeed"))) {
            if (plugin.hasPluginPermission(player, "hispeed")) {
                if (plugin.sHi.contains(player)) {
                    plugin.unsetPotion(player, 1);
                    plugin.sHi.remove(player);
                    player.sendMessage(ChatColor.DARK_GRAY
                            +"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
                }
                else {
                    plugin.sHi.add(player);
                    plugin.setPotion(player, 1, 3000, 2);
                    player.sendMessage(ChatColor.GOLD
                            +"Y"+ChatColor.YELLOW + "ou feel as though you can outrun olympic experts!");
                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
                            "2"+ChatColor.DARK_BLUE+"]");
                }
            }
            else {
                player.sendMessage(ChatColor.DARK_RED
                        +"Y"+ChatColor.RED+"ou either need to join the Thieves' Guild," +
                        " or earn a higher rank within it.");
            }
        }
        else if ((cmdName.equalsIgnoreCase("superspeed"))) {
            if (plugin.hasPluginPermission(player, "superspeed")) {
                if (plugin.sSuper.contains(player)) {
                    plugin.unsetPotion(player, 1);
                    plugin.sSuper.remove(player);
                    player.sendMessage(ChatColor.DARK_GRAY
                            +"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
                }
                else {
                    plugin.sSuper.add(player);
                    plugin.setPotion(player, 1, 4200, 3);
                    player.sendMessage(ChatColor.GOLD
                            +"Y"+ChatColor.YELLOW + "our leg muscles densify, amplifying your speed" +
                            " greater than that of even the fastest mobs!");
                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
                            "3"+ChatColor.DARK_BLUE+"]");
                }
            }
            else {
                player.sendMessage(ChatColor.DARK_RED
                        +"Y"+ChatColor.RED+"ou either need to join the Thieves' Guild," +
                        " or earn a higher rank within it.");
            }
        }
        else if ((cmdName.equalsIgnoreCase("hyperspeed"))) {
            if (plugin.hasPluginPermission(player, "hyperspeed")) {
                if (plugin.sHyper.contains(player)) {
                    plugin.unsetPotion(player, 1);
                    plugin.sHyper.remove(player);
                    player.sendMessage(ChatColor.DARK_GRAY
                            +"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
                }
                else {
                    plugin.sHyper.add(player);
                    plugin.setPotion(player, 1, 6000, 4);
                    player.sendMessage(ChatColor.GOLD
                            +"A"+ChatColor.YELLOW + " massive adrenaline overtakes your entity, making time " +
                            "itself, seem to slow down all around you!");
                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
                            "4"+ChatColor.DARK_BLUE+"]");
                }
            }
            else {
                player.sendMessage(ChatColor.DARK_RED
                        +"Y"+ChatColor.RED+"ou either need to join the Thieves' Guild," +
                        " or earn a higher rank within it.");
            }
        }
        else if ((cmdName.equalsIgnoreCase("godspeed"))) {
            if (plugin.hasPluginPermission(player, "godspeed")) {
                if (plugin.sGod.contains(player)) {
                    plugin.unsetPotion(player, 1);
                    plugin.sGod.remove(player);
                    player.sendMessage(ChatColor.DARK_GRAY
                            +"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
                }
                else {
                    plugin.sGod.add(player);
                    plugin.setPotion(player, 1, 9000, 5);
                    player.sendMessage(ChatColor.GOLD
                            +"Y"+ChatColor.YELLOW + "ou feel godly in your reaction time, speed, and jumping ability!");
                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
                            "5"+ChatColor.DARK_BLUE+"]");
                }
            }
            else {
                player.sendMessage(ChatColor.DARK_RED
                        +"Y"+ChatColor.RED+"ou either need to join the Thieves' Guild," +
                        " or earn a higher rank within it.");
            }
        }
        else if ((cmdName.equalsIgnoreCase("divinespeed"))) {
            if (plugin.hasPluginPermission(player, "divinespeed")) {
                if (plugin.sDivine.contains(player)) {
                    plugin.unsetPotion(player, 1);
                    plugin.sDivine.remove(player);
                    player.sendMessage(ChatColor.DARK_GRAY
                            +"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
                }
                else {
                    plugin.sDivine.add(player);
                    plugin.setPotion(player, 1, 12000, 6);
                    player.sendMessage(ChatColor.GOLD
                            +"Y"+ChatColor.YELLOW + "our legs begin to shake as the divine energy of the " +
                            "Minecraft Gods course through your veins!");
                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.RED+
                            "6"+ChatColor.DARK_BLUE+"]");
                }
            }
            else {
                player.sendMessage(ChatColor.DARK_RED
                        +"Y"+ChatColor.RED+"ou either need to join the Thieves' Guild," +
                        " or earn a higher rank within it.");
            }
        }
        else if ((cmdName.equalsIgnoreCase("onspeed"))) {
            if (plugin.hasPluginPermission(player, "own.state")) {
                if (plugin.sDivine.contains(player)) {
                    player.sendMessage(ChatColor.DARK_BLUE
                            +"["+ChatColor.GREEN+"The state of your Divine speed is" +
                            " [ON]"+ChatColor.DARK_BLUE+"]");

                }
                if (plugin.sGod.contains(player)) {
                    player.sendMessage(ChatColor.DARK_BLUE
                            +"["+ChatColor.GREEN+"The state of your God speed is" +
                            " [ON]"+ChatColor.DARK_BLUE+"]");

                }
                if (plugin.sHyper.contains(player)) {
                    player.sendMessage(ChatColor.DARK_BLUE
                            +"["+ChatColor.GREEN+"The state of your Hyper speed is" +
                            " [ON]"+ChatColor.DARK_BLUE+"]");

                }
                if (plugin.sSuper.contains(player)) {
                    player.sendMessage(ChatColor.DARK_BLUE
                            +"["+ChatColor.GREEN+"The state of your Super speed is" +
                            " [ON]"+ChatColor.DARK_BLUE+"]");

                }
                if (plugin.sHi.contains(player)) {
                    player.sendMessage(ChatColor.DARK_BLUE
                            +"["+ChatColor.GREEN+"The state of your Hi-speed is" +
                            " [ON]"+ChatColor.DARK_BLUE+"]");

                }
                if (plugin.sSpeed.contains(player)) {
                    player.sendMessage(ChatColor.DARK_BLUE
                            +"["+ChatColor.GREEN+"The state of your speed Lvl - 1 is" +
                            " [ON]"+ChatColor.DARK_BLUE+"]");
                }
            }		
        }

		return true;
	}
}