/**
 * 
 */
package org.frenz.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.frenz.Frenz;

/**
 * @author morganm
 *
 */
public class FrenzTest implements CommandExecutor {
    // keep a reference to our plugin object
    final Frenz plugin;
    
    public FrenzTest(Frenz plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command,
            String label, String[] args)
    {
        sender.sendMessage(plugin.getConfig().getString("testMessage"));
        return true;
    }

}
