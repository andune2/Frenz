package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

/** Andune 9/15/12 refactor/cleanup:
 * 
 *  - Eliminate private member variable "player", it's never saved between calls of onCommand(), so should be local to that method
 *  - call command.getName() once and store it
 *  - short-circuit Player check, instead of checking in each command
 *  - rename "me" variable to "plugin" to be more descriptive
 *  - change "this.plugin" to just "plugin" (reads better, same thing) 
 *  - change logic to if/else ladders with a single return at the end
 *
 */
public class Workers implements CommandExecutor {
	private final Frenz plugin;

	public Workers(Frenz plugin) {
		this.plugin = plugin;
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
	    
		if (cmdName.equalsIgnoreCase("miner")) {
		    if (plugin.hasPluginPermission(player, "miner")) {
		        if (plugin.Miner.contains(player)) {
		            plugin.unsetPotion(player, 3);
		            plugin.Miner.remove(player);
		            player.sendMessage(ChatColor.DARK_GRAY
		                    +"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
		        }
		        else {
		            plugin.Miner.add(player);
		            plugin.setPotion(player, 3, 1800, 1);
		            player.sendMessage(ChatColor.AQUA
		                    +"Y"+ChatColor.BLUE + "our arms feel refreshed and rejuvenated!");
		            player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
		                    +ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
		                    "1"+ChatColor.DARK_BLUE+"]");
		        }
		    }
		    else {
		        player.sendMessage(ChatColor.DARK_RED
		                +"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
		                " or earn a higher rank within it.");
		    }
		}
		else if (cmdName.equalsIgnoreCase("betterminer")) {
		    if (plugin.hasPluginPermission(player, "betterminer")) {
		        if (plugin.mBetter.contains(player)) {
		            plugin.unsetPotion(player, 3);
		            plugin.mBetter.remove(player);
		            player.sendMessage(ChatColor.DARK_GRAY
		                    +"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
		        }
		        else {
    		        plugin.mBetter.add(player);
    		        plugin.setPotion(player, 3, 3000, 2);
    		        player.sendMessage(ChatColor.AQUA
    		                +"Y"+ChatColor.BLUE + "our arms suddenly feel more buff and tough!");
    		        player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
    		                +ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
    		                "2"+ChatColor.DARK_BLUE+"]");
		        }
		    }
		    else {
		        player.sendMessage(ChatColor.DARK_RED
		                +"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
		                " or earn a higher rank within it.");
		    }
		}
		else if (cmdName.equalsIgnoreCase("superminer")) {
		    if (plugin.hasPluginPermission(player, "superminer")) {
		        if (plugin.mSuper.contains(player)) {
		            plugin.unsetPotion(player, 3);
		            plugin.mSuper.remove(player);
		            player.sendMessage(ChatColor.DARK_GRAY
		                    +"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
		        }
		        else {
		            plugin.mSuper.add(player);
		            plugin.setPotion(player, 3, 4200, 3);
		            player.sendMessage(ChatColor.AQUA
		                    +"Y"+ChatColor.BLUE + "ou feel as though you can do bicep curls for hours!");
		            player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
		                    +ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
		                    "3"+ChatColor.DARK_BLUE+"]");
		        }
		    }
		    else {
		        player.sendMessage(ChatColor.DARK_RED
		                +"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
		                " or earn a higher rank within it.");
		    }
		}
		else if (cmdName.equalsIgnoreCase("hyperminer")) {
		    if (plugin.hasPluginPermission(player, "hyperminer")) {
		        if (plugin.mHyper.contains(player)) {
		            plugin.unsetPotion(player, 3);
		            plugin.mHyper.remove(player);
		            player.sendMessage(ChatColor.DARK_GRAY
		                    +"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
		        }
		        else {
    		        plugin.mHyper.add(player);
    		        plugin.setPotion(player, 3, 6000, 4);
    		        player.sendMessage(ChatColor.AQUA
    		                +"Y"+ChatColor.BLUE + "our biceps bulge, veins exposed with the strength to " +
    		                "crush stone with your bare hands!");
    		        player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
    		                +ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
    		                "4"+ChatColor.DARK_BLUE+"]");
		        }
		    } 
		    else {
		        player.sendMessage(ChatColor.DARK_RED
		                +"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
		                " or earn a higher rank within it.");
		    }
		}
		else if (cmdName.equalsIgnoreCase("godminer")) {
		    if (plugin.hasPluginPermission(player, "godminer")) {
		        if (plugin.mGod.contains(player)) {
		            plugin.unsetPotion(player, 3);
		            plugin.mGod.remove(player);
		            player.sendMessage(ChatColor.DARK_GRAY
		                    +"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
		        }
		        else {
    		        plugin.mGod.add(player);
    		        plugin.setPotion(player, 3, 9000, 5);
    		        player.sendMessage(ChatColor.AQUA
    		                +"Y"+ChatColor.BLUE + "ou feel in your arms, the power to mine so swiftly, " +
    		                "that swinging your pickaxe is like waving your hand in " +
    		                "the air!");
    		        player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
    		                +ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
    		                "5"+ChatColor.DARK_BLUE+"]");
		        }
		    } 
		    else {
    		    player.sendMessage(ChatColor.DARK_RED
    		            +"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
    		            " or earn a higher rank within it.");
		    }
		}
		else if (cmdName.equalsIgnoreCase("divineminer")) {
		    if (plugin.hasPluginPermission(player, "divineminer")) {
		        if (plugin.mDivine.contains(player)) {
		            plugin.unsetPotion(player, 3);
		            plugin.mDivine.remove(player);
		            player.sendMessage(ChatColor.DARK_GRAY
		                    +"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
		        }
		        else {
    		        plugin.mDivine.add(player);
    		        plugin.setPotion(player, 3, 12000, 5);
    		        player.sendMessage(ChatColor.AQUA
    		                +"Y"+ChatColor.BLUE + "our arms begin to tremble as the divine energy of " +
    		                "the Minecraft Gods course through your veins!");
    		        player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
    		                +ChatColor.GRAY+" Lvl "+ChatColor.RED+
    		                "6"+ChatColor.DARK_BLUE+"]");
		        }
		    }
		    else {
		        player.sendMessage(ChatColor.DARK_RED
		                +"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
		                " or earn a higher rank within it.");
		    }
		}
		
		return true;
	}
}