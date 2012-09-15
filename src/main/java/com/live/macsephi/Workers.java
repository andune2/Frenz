package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class Workers implements CommandExecutor {
	private Player player;
	private final Frenz me;

	public Workers(Frenz me) {
		this.me = me;
	}
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if ((command.getName().equalsIgnoreCase("miner"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "miner")) {
					if (this.me.Miner.contains(this.player)) {
						this.me.unsetPotion(this.player, 3);
						this.me.Miner.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
						return true;
					}
					this.me.Miner.add(this.player);
					this.me.setPotion(this.player, 3, 1800, 1);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our arms feel refreshed and rejuvenated!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"1"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("betterminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "betterminer")) {
					if (this.me.mBetter.contains(this.player)) {
						this.me.unsetPotion(this.player, 3);
						this.me.mBetter.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
						return true;
					}
					this.me.mBetter.add(this.player);
					this.me.setPotion(this.player, 3, 3000, 2);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our arms suddenly feel more buff and tough!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"2"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("superminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "superminer")) {
					if (this.me.mSuper.contains(this.player)) {
						this.me.unsetPotion(this.player, 3);
						this.me.mSuper.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
						return true;
					}
					this.me.mSuper.add(this.player);
					this.me.setPotion(this.player, 3, 4200, 3);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "ou feel as though you can do bicep curls for hours!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"3"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("hyperminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "hyperminer")) {
					if (this.me.mHyper.contains(this.player)) {
						this.me.unsetPotion(this.player, 3);
						this.me.mHyper.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
						return true;
					}
					this.me.mHyper.add(this.player);
					this.me.setPotion(this.player, 3, 6000, 4);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our biceps bulge, veins exposed with the strength to " +
							"crush stone with your bare hands!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"4"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("godminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "godminer")) {
					if (this.me.mGod.contains(this.player)) {
						this.me.unsetPotion(this.player, 3);
						this.me.mGod.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
						return true;
					}
					this.me.mGod.add(this.player);
					this.me.setPotion(this.player, 3, 9000, 5);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "ou feel in your arms, the power to mine so swiftly, " +
							"that swinging your pickaxe is like waving your hand in " +
							"the air!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"5"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("divineminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "divineminer")) {
					if (this.me.mDivine.contains(this.player)) {
						this.me.unsetPotion(this.player, 3);
						this.me.mDivine.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own mining enhancement at will.");
						return true;
					}
					this.me.mDivine.add(this.player);
					this.me.setPotion(this.player, 3, 12000, 5);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our arms begin to tremble as the divine energy of " +
							"the Minecraft Gods course through your veins!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.RED+
							"6"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Worker's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		return false;
	}
}