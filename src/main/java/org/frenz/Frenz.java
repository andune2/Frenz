package org.frenz;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.frenz.commands.FrenzTest;

public class Frenz extends JavaPlugin
{
    private Logger log;
    
    public void onEnable() {
        this.log = getLogger();
        
        saveDefaultConfig();    // copy default config.yml into place if necessary
        
        // map Bukkit commands to our plugin command classes
        getCommand("frenztest").setExecutor(new FrenzTest(this));
        
        log.info("version "+getDescription().getVersion()+" is enabled");
    }

    public void onDisable() {
        log.info("version "+getDescription().getVersion()+" is disabled");
    }
}
