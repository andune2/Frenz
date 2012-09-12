package com.live.macsephi.Admin;

import java.io.PrintStream;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import com.live.macsephi.Frenz;

public class KitExecutor implements CommandExecutor {
    private final Frenz me;
    private static final ItemStack[] KIT_1 = {
            new ItemStack(Material.WOOD_SWORD),
            new ItemStack(Material.COMPASS),
            new ItemStack(Material.SANDSTONE, 1, (short)1),
            new ItemStack(Material.SIGN), new ItemStack(Material.WOOD_PICKAXE) };

    private static final ItemStack[] KIT_2 = {
            new ItemStack(Material.WOOD_SWORD),
            new ItemStack(Material.COMPASS),
            new ItemStack(Material.SANDSTONE, 1, (short)1) };

    public KitExecutor(Frenz me) {
        this.me = me;
    }

    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args) {
        if ((sender instanceof Player)) {
            Player player = (Player) sender;
            if ((player.getName().equalsIgnoreCase("Kirbyarm"))
                    || (player.getName().equalsIgnoreCase("FyreLord"))) {
                if (command.getName().equalsIgnoreCase("a1")) {
                    player.getInventory().addItem(KIT_1);
                    player.updateInventory();
                    player.sendMessage(ChatColor.BLUE + "Use them well.");
                    return true;
                }
                if (command.getName().equalsIgnoreCase("a2")) {
                    player.getInventory().addItem(KIT_2);
                    player.updateInventory();
                    player.sendMessage(ChatColor.BLUE + "Use them well.");
                    return true;
                }
                if (command.getName().equalsIgnoreCase("a3")) {
                    player.getInventory().addItem(
                            new ItemStack[] { new ItemStack(373, 64, (short)8259) });
                    player.updateInventory();
                    player.sendMessage(ChatColor.BLUE + "Use them well.");
                    return true;
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission.");
            }
        } else {
            System.out
                    .println("[MobEffects] You must be a player to execute this command.");
        }
        return false;
    }
}