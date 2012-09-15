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

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.live.macsephi.Frenz;

public class Mages implements CommandExecutor {
	private Player player;
	private Frenz me;
	//ItemStack curaAmmo = new ItemStack(Material.DIAMOND, 3);
	//ItemStack curaOtherAmmo = new ItemStack(Material.DIAMOND, 4);
	//ItemStack fullCureAmmo = new ItemStack(Material.DIAMOND, 5);
	//ItemStack fullCureOtherAmmo = new ItemStack(Material.DIAMOND, 6);
	//ItemStack regenAmmo = new ItemStack(Material.EMERALD, 2);
	//ItemStack regenOtherAmmo = new ItemStack(Material.EMERALD, 3);

	public Mages(Frenz me) {
		this.me = me;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if ((command.getName().equalsIgnoreCase("cure"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				PlayerInventory inv = player.getInventory();
				ItemStack cureAmmo = new ItemStack(Material.DIAMOND, 1);
				ItemStack cureOtherAmmo = new ItemStack(Material.DIAMOND, 2);
				if (this.me.hasPluginPermission(player, "cure")) {
					if ((this.me.hasPluginPermission(player, "cure.other"))
							&& (args.length == 1)) {
						Player target = this.me.getServer().getPlayer(args[0]);
						if (target != player) {
							if (target == null) {
								player.sendMessage(ChatColor.RED
										+ "Specified Player is invalid! (offline, non-existent," +
										" or improperly typed)");
								return false;
							}
							if (inv.contains(cureOtherAmmo)) {
								if (target.getHealth() > 15)
									target.setHealth(20);
								else {
									target.setHealth(target.getHealth() + 5);
								}
								inv.removeItem(cureOtherAmmo);
								target.sendMessage(ChatColor.GREEN
										+"P"+ChatColor.DARK_GREEN + "layer " + player.getName() +" has cast Cure on you!");
								target.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"RES"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
										"1"+ChatColor.DARK_BLUE+"]");
								this.player.sendMessage(ChatColor.GREEN
										+"Y"+ChatColor.DARK_GREEN + "ou have cast Cure on " + target.getName() +"!");
								this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"RES"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
										"1"+ChatColor.DARK_BLUE+"]");
								return true;
							}
							this.player.sendMessage(ChatColor.DARK_RED
									+"Y"+ChatColor.RED+"ou must have at least 2 Diamonds in your " +
									"inventory in order to cast Cure on someone else.");
							return false;
						}
					}
					if (inv.contains(cureAmmo)) {
						if (player.getHealth() > 15)
							player.setHealth(20);
						else {
							player.setHealth(player.getHealth() + 5);
						}
						inv.removeItem(cureAmmo);
						this.player.sendMessage(ChatColor.GREEN
								+"Y"+ChatColor.DARK_GREEN + "ou have cast Cure on yourself!");
						this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"RES"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
								"1"+ChatColor.DARK_BLUE+"]");
						return true;
					}
					this.player.sendMessage(ChatColor.DARK_RED
							+"Y"+ChatColor.RED+"ou must have at least 1 Diamond in your " +
							"inventory in order to cast Cure on yourself.");
					return false;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Mage's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		return false;
	}
}