package com.live.macsephi;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.live.macsephi.Frenz;

public class Heroes implements CommandExecutor {
	private final Frenz me;
	private Player player;

	public Heroes(Frenz me) {
		this.me = me;
	}

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if ((command.getName().equalsIgnoreCase("brawn"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "brawn")) {
					if (this.me.bBrawn.contains(player)) {
						this.me.bBrawn.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own offensive combat abilities.");
						return true;
					}
					this.me.bBrawn.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou feel a boost in offensive combat!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"STR"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"1"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("betterbrawn"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "betterbrawn")) {
					if (this.me.bBetter.contains(player)) {
						this.me.bBetter.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own offensive combat abilities.");
						return true;
					}
					this.me.bBetter.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou feel a powerful boost in offensive combat!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"STR"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"2"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("superbrawn"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "superbrawn")) {
					if (this.me.bSuper.contains(player)) {
						this.me.bSuper.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own offensive combat abilities.");
						return true;
					}
					this.me.bSuper.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "our reflexes in combat become so swift that it" +
							" directly affects your damage output!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"STR"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"3"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("hyperbrawn"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "hyperbrawn")) {
					if (this.me.bHyper.contains(player)) {
						this.me.bHyper.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own offensive combat abilities.");
						return true;
					}
					this.me.bHyper.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "our effectiveness at delivering a single blow" +
							" compares to that of even the mightiest of fighters!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"STR"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"4"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("godbrawn"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "godbrawn")) {
					if (this.me.bGod.contains(player)) {
						this.me.bGod.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own offensive combat abilities.");
						return true;
					}
					this.me.bGod.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou feel a tremendous adrenaline inside of you, " +
							"with the sheer godly intention to deal offensive damage!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"STR"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"5"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("divinebrawn"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "divinebrawn")) {
					if (this.me.bDivine.contains(player)) {
						this.me.bDivine.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own offensive combat abilities.");
						return true;
					}
					this.me.bDivine.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou begin perceiving your opponent's weaknesses to a level " +
							"they couldn't imagine as the power of the Minecraft Gods course" +
							" through your veins!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"STR"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.RED+"6"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("deathstrike"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "deathstrike")) {
					if (this.me.DeathStrike.contains(player)) {
						this.me.DeathStrike.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have negated your own intent to kill.");
						return true;
					}
					this.me.DeathStrike.add(player);
					this.player.sendMessage(ChatColor.BLACK
							+"Y"+ChatColor.GRAY + "our next victim will be successfully assassinated.");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.DARK_GRAY+"DEATH"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.RED+"1"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("shield"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "shield")) {
					if (this.me.Shield.contains(player)) {
						this.me.Shield.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have lowered your defenses.");
						return true;
					}
					this.me.Shield.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou feel your body becoming more tough!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEF"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"1"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("bettershield"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "bettershield")) {
					if (this.me.dBetter.contains(player)) {
						this.me.dBetter.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have lowered your defenses.");
						return true;
					}
					this.me.dBetter.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "our skin hardens, allowing you to endure more" +
							" punishment!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEF"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"2"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("supershield"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "supershield")) {
					if (this.me.dSuper.contains(player)) {
						this.me.dSuper.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have lowered your defenses.");
						return true;
					}
					this.me.dSuper.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou suddenly feel as though your skin is harder " +
							"than steel!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEF"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"3"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("hypershield"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "hypershield")) {
					if (this.me.dHyper.contains(player)) {
						this.me.dHyper.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have lowered your defenses.");
						return true;
					}
					this.me.dHyper.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou call forth an exoskeleton made of" +
							" pure tungsten to aid in your defenses!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEF"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"4"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("godshield"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "godshield")) {
					if (this.me.dGod.contains(player)) {
						this.me.dGod.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have lowered your defenses.");
						return true;
					}
					this.me.dGod.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou summon a godly exterior that mimes the" +
							" exceptionally powerful state of diamond!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEF"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.GREEN+"5"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		if ((command.getName().equalsIgnoreCase("divineshield"))) {
			if ((sender instanceof Player)) {
				this.player = ((Player) sender);
				if (this.me.hasPluginPermission(player, "divineshield")) {
					if (this.me.dDivine.contains(player)) {
						this.me.dDivine.remove(player);
						this.player.sendMessage(ChatColor.DARK_GRAY
								+"Y"+ChatColor.GRAY+"ou have lowered your defenses.");
						return true;
					}
					this.me.dDivine.add(player);
					this.player.sendMessage(ChatColor.DARK_GRAY
							+"Y"+ChatColor.DARK_RED + "ou call high unto the Minecraft Gods, whom" +
							" answer your call, sending you massively defensive divine energy!");
					this.player.sendMessage(ChatColor.DARK_BLUE + "["+ChatColor.AQUA+"DEF"+ChatColor.GRAY+"" +
							" Lvl "+ChatColor.RED+"6"+ChatColor.DARK_BLUE+"]");
					return true;
				}
				this.player.sendMessage(ChatColor.DARK_RED
						+"Y"+ChatColor.RED+"ou either need to join the Heroes' Guild," +
						" or earn a higher rank within it.");
			}
			return false;
		}
		return false;
	}
}