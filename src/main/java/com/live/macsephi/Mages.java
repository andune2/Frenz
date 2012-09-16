/* This is the file I'd like to ask you to please demonstrate the generic code solution to the item stack
 * problem I've encountered.
 * 
 * Also, if you're feeling like doing a bit extra more, I'm still struggling to figure out how to get a command's
 * effect to wear off after a certain amount of Ticks. If you'd be so kind as to demonstrate that on one of the
 * commands, I would certainly learn from it and put it to good use. ^.^
 * 
 * I held off on the commit as I wanted to surprise you with some of the things I learned on my own. :P
 * 
 * ~ Mackenzie ~
 */

package com.live.macsephi;

// watch the magic.. bye-bye warnings.

import java.util.ListIterator;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/** First I will do the same I did to the other class, so you can see how I work.
 * 
 *  Oh only one if/else here..  oh well will do the same anyway.
 * 
 * @author morganm
 *
 */
public class Mages implements CommandExecutor {
	private Frenz plugin;
	//ItemStack curaAmmo = new ItemStack(Material.DIAMOND, 3);
	//ItemStack curaOtherAmmo = new ItemStack(Material.DIAMOND, 4);
	//ItemStack fullCureAmmo = new ItemStack(Material.DIAMOND, 5);
	//ItemStack fullCureOtherAmmo = new ItemStack(Material.DIAMOND, 6);
	//ItemStack regenAmmo = new ItemStack(Material.EMERALD, 2);
	//ItemStack regenOtherAmmo = new ItemStack(Material.EMERALD, 3);

	// also, variable rename
	public Mages(Frenz me) {
		this.plugin = me;
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
	    
		if ((command.getName().equalsIgnoreCase("cure"))) {
		    
		    if (plugin.hasPluginPermission(player, "cure")) {
		        if ((plugin.hasPluginPermission(player, "cure.other"))
		                && (args.length == 1)) {
		            Player target = plugin.getServer().getPlayer(args[0]);
		            if (target != player) {
		                if (target == null) {
		                    player.sendMessage(ChatColor.RED
		                            + "Specified Player is invalid! (offline, non-existent," +
		                            " or improperly typed)");
		                    return true;
		                }
		                
		                // check for required material and apply cost if they have it
		                if( checkForItem(player, Material.DIAMOND, 2) ) {
		                    removeItem(player, Material.DIAMOND, 2);
		                    
		                    if (target.getHealth() > 15)
		                        target.setHealth(20);
		                    else {
		                        target.setHealth(target.getHealth() + 5);
		                    }
		                    target.sendMessage(ChatColor.GREEN
		                            +"P"+ChatColor.DARK_GREEN + "layer " + player.getName() +" has cast Cure on you!");
		                    target.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"RES"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
		                            "1"+ChatColor.DARK_BLUE+"]");
		                    player.sendMessage(ChatColor.GREEN
		                            +"Y"+ChatColor.DARK_GREEN + "ou have cast Cure on " + target.getName() +"!");
		                    player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"RES"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
		                            "1"+ChatColor.DARK_BLUE+"]");
		                }
		                else {
    		                player.sendMessage(ChatColor.DARK_RED
    		                        +"Y"+ChatColor.RED+"ou must have at least 2 Diamonds in your " +
    		                        "inventory in order to cast Cure on someone else.");
		                }
		            }
		        }

		        // check for required material and apply cost if they have it
	            if( checkForItem(player, Material.DIAMOND, 1) ) {
	                removeItem(player, Material.DIAMOND, 1);
	                
		            if (player.getHealth() > 15)
		                player.setHealth(20);
		            else {
		                player.setHealth(player.getHealth() + 5);
		            }
		            
		            player.sendMessage(ChatColor.GREEN
		                    +"Y"+ChatColor.DARK_GREEN + "ou have cast Cure on yourself!");
		            player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"RES"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
		                    "1"+ChatColor.DARK_BLUE+"]");
		        }
	            else {
    		        player.sendMessage(ChatColor.DARK_RED
    		                +"Y"+ChatColor.RED+"ou must have at least 1 Diamond in your " +
    		                "inventory in order to cast Cure on yourself.");
	            }
		    }
		    player.sendMessage(ChatColor.DARK_RED
		            +"Y"+ChatColor.RED+"ou either need to join the Mage's Guild," +
		            " or earn a higher rank within it.");
		}
		
		return true;
	}
	
	/** Check to see if a player has a certain amount of a given material.
	 * 
	 * @param player
	 * @param material
	 * @param amount
	 * @return true if the requested amount of material exists
	 */
	private boolean checkForItem(Player player, Material material, int amount) {
	    PlayerInventory inventory = player.getInventory();
	    ItemStack[] items = inventory.getContents();

	    int count=0;
	    // loop through inventory looking for the requested material, add to count
	    // as we find stacks of that material
	    for(int i=0; i < items.length; i++) {
	        ItemStack item = items[i];
	        Material mat = item.getType();
	        if( mat.equals(material) ) {
	            count += item.getAmount();
	        }
	    }
	    /* Running the test as-as, I get an internal error when trying to use the /cure command:
	     * Caused by: java.lang.NullPointerException
        at com.live.macsephi.Mages.checkForItem(Mages.java:142)
        at com.live.macsephi.Mages.onCommand(Mages.java:98)
        at org.bukkit.command.PluginCommand.execute(PluginCommand.java:40)
        ... 15 more
	     * */
	    return count >= amount; // does the player have the required amount
	}
	
	/** Remove a given item/amount from the players inventory.
	 * 
	 * @param player
	 * @param material
	 * @param amount
	 */
	private void removeItem(Player player, Material material, int amount) {
        PlayerInventory inventory = player.getInventory();
        ItemStack[] items = inventory.getContents();
        
        int count=amount;
        // loop through inventory looking for the requested material, remove up
        // to the requested amount until we are done.
        for(int i=0; i < items.length; i++) {
            ItemStack item = items[i];
            Material mat = item.getType();
            if( mat.equals(material) ) {
                if( count >= item.getAmount() ) {    // remove full stack
                    count -= item.getAmount();
                    inventory.setItem(i,  null);
                }
                else {                              // just remove what we need
                    item.setAmount(item.getAmount() - count);
                    count = 0;
                }
            }
            
            // did we remove all of the requested items? If so, we're done. 
            if( count == 0 )
                break;
        }
	}
}