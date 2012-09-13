package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class SpeedCommands implements CommandExecutor {
	private Player player;
	private final Frenz me;

	public SpeedCommands(Frenz instance) {
		this.me = instance;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if ((command.getName().equalsIgnoreCase("speed"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (me.hasPluginPermission(this.player, "speed")) {
					if (this.me.sSpeed.contains(this.player)) {
						this.me.removeMobEffect(this.player, 1);
						this.me.sSpeed.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
						return true;
					}
					this.me.sSpeed.add(this.player);
					this.me.setMobEffect(this.player, 1, 1800, 1);
					this.player.sendMessage(ChatColor.GOLD
							+"Y"+ChatColor.YELLOW + "ou feel a sudden sensation in your legs, as though you can" +
							" run a marathon without breaking a sweat!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"1"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Athlete's Guild," +
								" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("hispeed"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (me.hasPluginPermission(this.player, "hispeed")) {
					if (this.me.sHi.contains(this.player)) {
						this.me.removeMobEffect(this.player, 1);
						this.me.sHi.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
						return true;
					}
					this.me.sHi.add(this.player);
					this.me.setMobEffect(this.player, 1, 3000, 2);
					this.player.sendMessage(ChatColor.GOLD
							+"Y"+ChatColor.YELLOW + "ou feel as though you can outrun olympic experts!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"2"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Athlete's Guild," +
								" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("superspeed"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (me.hasPluginPermission(this.player, "superspeed")) {
					if (this.me.sSuper.contains(this.player)) {
						this.me.removeMobEffect(this.player, 1);
						this.me.sSuper.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
						return true;
					}
					this.me.sSuper.add(this.player);
					this.me.setMobEffect(this.player, 1, 4200, 3);
					this.player.sendMessage(ChatColor.GOLD
							+"Y"+ChatColor.YELLOW + "our leg muscles densify, amplifying your speed" +
									" greater than that of even the fastest mobs!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"3"+ChatColor.DARK_BLUE+"]");
					return true;
				} 
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Athlete's Guild," +
								" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("hyperspeed"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (me.hasPluginPermission(this.player, "hyperspeed")) {
					if (this.me.sHyper.contains(this.player)) {
						this.me.removeMobEffect(this.player, 1);
						this.me.sHyper.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
						return true;
					}
					this.me.sHyper.add(this.player);
					this.me.setMobEffect(this.player, 1, 6000, 4);
					this.player.sendMessage(ChatColor.GOLD
							+"A"+ChatColor.YELLOW + " massive adrenaline overtakes your entity, making time " +
									"itself, seem to slow down all around you!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"4"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Athlete's Guild," +
								" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("godspeed"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (me.hasPluginPermission(this.player, "godspeed")) {
					if (this.me.sGod.contains(this.player)) {
						this.me.removeMobEffect(this.player, 1);
						this.me.sGod.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
						return true;
					}
					this.me.sGod.add(this.player);
					this.me.setMobEffect(this.player, 1, 9000, 5);
					this.player.sendMessage(ChatColor.GOLD
							+"Y"+ChatColor.YELLOW + "ou feel godly in your reaction time, speed, and jumping ability!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.GREEN+
							"5"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Athlete's Guild," +
								" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("divinespeed"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (me.hasPluginPermission(this.player, "divinespeed")) {
					if (this.me.sDivine.contains(this.player)) {
						this.me.removeMobEffect(this.player, 1);
						this.me.sDivine.remove(this.player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have calmed your own speed enhancement at will.");
						return true;
					}
					this.me.sDivine.add(this.player);
					this.me.setMobEffect(this.player, 1, 12000, 6);
					this.player.sendMessage(ChatColor.GOLD
							+"Y"+ChatColor.YELLOW + "our legs begin to shake as the divine energy of the " +
									"Minecraft Gods course through your veins!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"SPD"+ChatColor.GRAY+" Lvl "+ChatColor.RED+
							"6"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Athlete's Guild," +
								" or earn a higher rank within it.");
			}
			return false;
		}
		return false;
	}
}