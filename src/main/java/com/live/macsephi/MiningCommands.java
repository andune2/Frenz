package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class MiningCommands implements CommandExecutor {
	private Player player;
	private final Frenz me;

	public MiningCommands(Frenz me) {
		this.me = me;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if ((command.getName().equalsIgnoreCase("miner"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "miner")) {
					this.me.setMobEffect(this.player, 3, 1800, 1);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our arms feel refreshed and rejuvenated!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"1"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Miner's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("betterminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "betterminer")) {
					this.me.setMobEffect(this.player, 3, 3000, 2);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our arms suddenly feel more buff and tough!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"2"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Miner's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("superminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "superminer")) {
					this.me.setMobEffect(this.player, 3, 4200, 3);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "ou feel as though you can do bicep curls for hours!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"3"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Miner's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("hyperminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "hyperminer")) {
					this.me.setMobEffect(this.player, 3, 6000, 4);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our biceps bulge, veins exposed with the strength to " +
							"crush stone with your bare hands!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"4"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Miner's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("godminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "godminer")) {
					this.me.setMobEffect(this.player, 3, 9000, 5);
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
						+"Y"+ChatColor.RED+"ou either need to join the Miner's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("divineminer"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(this.player, "divineminer")) {
					this.me.setMobEffect(this.player, 3, 12000, 5);
					this.player.sendMessage(ChatColor.AQUA
							+"Y"+ChatColor.BLUE + "our arms begin to tremble as the divine energy of " +
							"the Minecraft Gods course through your veins!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEX"
							+ChatColor.GRAY+" Lvl "+ChatColor.RED+
							"6"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Miner's Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		return false;
	}
}