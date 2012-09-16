/* Mackenzie - Commit 8: Deleted AdminListener class, implementing its necessary functionality into the main
 * FrenzListener class. My question here is, I had to change this:
 * import com.live.macsephi.Admin.AdminListener; into this:
 * import com.live.macsephi.FrenzListener;
 * There aren't any warnings, but is that necessary to leave there? I get the feeling that import is no longer
 * necessary. Please let me know what you think. Not feeling confident at all about this change, since I've
 * never done anything like it before.. testing plugin now. Sweet!! All works, no debugging necessary,
 * permissions and all that work fine too, tested only the affected functionality of course. Pushing.
 * 
 * Commit 9: Repeated through process of previous commit, only not AdminListener, but instead, BladeListener.
 * No bugs or errors, all worked out perfectly. Only took extra time to test as I had to multi-account and
 * verify that with defense enhancements AND attack enhances that they still coincide properly and the
 * damage is properly calculated in game, which it is so it's all good! Pushing.
 * 
 * Commit 10: This was extremely difficult and tedious for me to figure out toggling them by command. Added the
 * arrays and utilized them well. Colorized and personalized the messages received to be much more professional,
 * corrected the timers of them, removed the dead toggle code that did not work for any of the commands except
 * the /divinespeeed originally. I initially organized all speed commands into one easy to maintain class called
 * SpeedCommands, appropriately enabling me to delete all 6 (Name)SpeedCommand classes, and the Speed package.
 * Plugin fully tested and verified to work in every way, including permissions! (: Pushing.
 * 
 * Commit 11: Wow, despite having been able to organize much faster than the SpeedCommands, condensing the 6 Arm
 * classes proved to be a massive headache.. finally some real troubleshooting! Alas, I figured it out myself,
 * without having to research a single thing! (I could've looked answers up, but I love challenging myself).
 * No errors in eclipse help, just vague stack traces. Anyways, merged the Arm classes, deleting them in the
 * process, into a new class called MiningCommands. Tied up loose ends, customized the timers and messages,
 * will consider at a later point if I want them toggleable or not.
*/
package com.live.macsephi;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MobEffect;
import net.minecraft.server.Packet42RemoveMobEffect;

import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import com.live.macsephi.Admin.BoomExecutor;
import com.live.macsephi.Admin.KitExecutor;
import com.live.macsephi.Admin.ReloadFrenzCommand;
import com.live.macsephi.Admin.ShutUpCommand;
import com.live.macsephi.MiscCommands.CureMoreCommand;
import com.live.macsephi.MiscCommands.CurseCommand;
import com.live.macsephi.MiscCommands.DistortCommand;
import com.live.macsephi.MiscCommands.FoodCommand;
import com.live.macsephi.MiscCommands.FullRestoreCommand;
import com.live.macsephi.MiscCommands.OffCommand;
import com.live.macsephi.MiscCommands.SliceCommand;
import com.live.macsephi.MiscCommands.SuperDistortCommand;

public class Frenz extends JavaPlugin {
    private static final String PERMISSION_BASE = "Frenz.";
    
    private Logger log;
    
    public FileConfiguration config;
    private File configFile;
    protected boolean disableFireCharges;
    public List<TNTPrimed> tntPrimed = new ArrayList<TNTPrimed>();
    public List<TNTPrimed> napalm = new ArrayList<TNTPrimed>();
    public List<Player> Shield = new ArrayList<Player>();
    public List<Player> dBetter = new ArrayList<Player>();
    public List<Player> dSuper = new ArrayList<Player>();
    public List<Player> dHyper = new ArrayList<Player>();
    public List<Player> dGod = new ArrayList<Player>();
    public List<Player> dDivine = new ArrayList<Player>();
    public List<Player> Miner = new ArrayList<Player>();
    public List<Player> mBetter = new ArrayList<Player>();
    public List<Player> mSuper = new ArrayList<Player>();
    public List<Player> mHyper = new ArrayList<Player>();
    public List<Player> mGod = new ArrayList<Player>();
    public List<Player> mDivine = new ArrayList<Player>();
    public List<Player> bBrawn = new ArrayList<Player>();
    public List<Player> bBetter = new ArrayList<Player>();
    public List<Player> bSuper = new ArrayList<Player>();
    public List<Player> bHyper = new ArrayList<Player>();
    public List<Player> bGod = new ArrayList<Player>();
    public List<Player> bDivine = new ArrayList<Player>();
    public List<Player> sDivine = new ArrayList<Player>();
    public List<Player> sGod = new ArrayList<Player>();
    public List<Player> sHyper = new ArrayList<Player>();
    public List<Player> sSuper = new ArrayList<Player>();
    public List<Player> sHi = new ArrayList<Player>();
    public List<Player> sSpeed = new ArrayList<Player>();
    public List<Player> DeathStrike = new ArrayList<Player>();
    
    public List<Player> isMuted = Collections.synchronizedList(new ArrayList<Player>());

    private final CommandExecutor boomExecutor = new BoomExecutor(this);
    private final CommandExecutor kitExecutor = new KitExecutor(this);

    public void onEnable() {
        log = getLogger();
        
        checkConfig();
        registerCommands();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new FrenzListener(this), this);

        log.info("version "+getDescription().getVersion()+" has been Enabled!");
    }

    public void onDisable() {
        log.info("version "+getDescription().getVersion()+" has been Disabled!");
    }

    private void registerCommands() {
        try {
            getCommand("a1").setExecutor(this.kitExecutor);
            getCommand("a2").setExecutor(this.kitExecutor);
            getCommand("a3").setExecutor(this.kitExecutor);
            getCommand("boom").setExecutor(this.boomExecutor);
            getCommand("napalm").setExecutor(this.boomExecutor);
            getCommand("shutup").setExecutor(new ShutUpCommand(this));
            getCommand("distort").setExecutor(new DistortCommand(this));
            getCommand("superdistort").setExecutor(new SuperDistortCommand(this));
            getCommand("slice").setExecutor(new SliceCommand(this));
            getCommand("curse").setExecutor(new CurseCommand(this));
            getCommand("cure").setExecutor(new Mages(this));
            getCommand("curemore").setExecutor(new CureMoreCommand(this));
            getCommand("fullrestore").setExecutor(new FullRestoreCommand(this));
            getCommand("brawn").setExecutor(new Heroes(this));
            getCommand("betterbrawn").setExecutor(new Heroes(this));
            getCommand("superbrawn").setExecutor(new Heroes(this));
            getCommand("hyperbrawn").setExecutor(new Heroes(this));
            getCommand("godbrawn").setExecutor(new Heroes(this));
            getCommand("divinebrawn").setExecutor(new Heroes(this));
            getCommand("deathstrike").setExecutor(new Heroes(this));
            getCommand("miner").setExecutor(new Workers(this));
            getCommand("betterminer").setExecutor(new Workers(this));
            getCommand("superminer").setExecutor(new Workers(this));
            getCommand("hyperminer").setExecutor(new Workers(this));
            getCommand("godminer").setExecutor(new Workers(this));
            getCommand("divineminer").setExecutor(new Workers(this));
            getCommand("speed").setExecutor(new Thieves(this));
            getCommand("hispeed").setExecutor(new Thieves(this));
            getCommand("superspeed").setExecutor(new Thieves(this));
            getCommand("hyperspeed").setExecutor(new Thieves(this));
            getCommand("godspeed").setExecutor(new Thieves(this));
            getCommand("divinespeed").setExecutor(new Thieves(this));
            getCommand("onspeed").setExecutor(new Thieves(this));
            getCommand("off").setExecutor(new OffCommand(this));
            getCommand("shield").setExecutor(new Heroes(this));
            getCommand("bettershield").setExecutor(new Heroes(this));
            getCommand("supershield").setExecutor(new Heroes(this));
            getCommand("hypershield").setExecutor(new Heroes(this));
            getCommand("godshield").setExecutor(new Heroes(this));
            getCommand("divineshield").setExecutor(new Heroes(this));
            getCommand("freload").setExecutor(new ReloadFrenzCommand(this));
            getCommand("food").setExecutor(new FoodCommand(this));
        } catch (Exception e) {
            log.warning("[MobEffects] ERROR " + e);
            e.printStackTrace();
        }
    }

    public boolean hasPluginPermission(Player player, String node) {
        return player.hasPermission(PERMISSION_BASE+node);
    }

    private void checkConfig() {
        getDataFolder().mkdirs();
        this.configFile = new File(getDataFolder(), "config.yml");
        if (!this.configFile.exists()) {
            try {
                this.configFile.createNewFile();
            } catch (IOException e) {
                log.severe("[MobEffects] ERROR could not create config.yml!\r\n"
                        + e);
                return;
            }
        }
        this.config = YamlConfiguration.loadConfiguration(this.configFile);

        if (!this.config.contains("DisableFireCharges")) {
            this.config.set("DisableFireCharges", Boolean.valueOf(true));
        }

        this.disableFireCharges = this.config.getBoolean("DisableFireCharges", true);
        saveConfig();
}

    public void reloadConfig() {
        try {
            if (this.configFile == null) {
                checkConfig();
            }
            this.config.load(this.configFile);
        } catch (Exception e) {
            log.severe("[MobEffects] ERROR config.yml could not be properly loaded. Please check the file for syntax errors."
                    + e);
            this.config = YamlConfiguration.loadConfiguration(this.configFile);
        }
    }

    public void saveConfig() {
        try {
            if (this.configFile == null) {
                checkConfig();
            }
            this.config.save(this.configFile);
        } catch (IOException e) {
            log.severe("[MobEffects] ERROR could not save config.yml\r\n" + e);
        }
    }
	public void setPotion(LivingEntity entity, int type, int duration, int amplifier) {
		((CraftLivingEntity) entity).getHandle().addEffect(new MobEffect(type, duration, amplifier));
	}
	public void unsetPotion(LivingEntity entity, int type) {
		try {
			if ((entity instanceof Player)) {
				EntityPlayer player = ((CraftPlayer) entity).getHandle();
				player.netServerHandler.sendPacket(new Packet42RemoveMobEffect(player.id, new MobEffect(type, 0, 0)));
			}
			Field field = EntityLiving.class.getDeclaredField("effects");
			field.setAccessible(true);
			@SuppressWarnings("rawtypes")
			HashMap effects = (HashMap) field.get(((CraftLivingEntity) entity).getHandle());
			effects.remove(Integer.valueOf(type));
		} catch (Exception localException) {
		}
	}
	
    /* Storage format is:
     *   { playerNameA =>
     *       { effectType1 => schedulerId,
     *         effectType2 => schedulerId },
     *     playerNameB =>
     *       { effectType1 => schedulerId }
     *   }
     */
    private final Map<String, Map<PotionEffectType, Integer>> tasks = new HashMap<String, Map<PotionEffectType, Integer>>();
    
	/** Add a timeout for a given effect. Keep track of the timeout so we can cancel
	 * it prematurely if we want to.
     * 
     * @param player the player the timer is for
     * @param type the PotionEffect to be removed when the timer fires
     * @param delay how many ticks until the timer fires
     * @param trackingList a list to remove the player from when the timer fires (optional, can be null)
     * @param timeoutMessage a message to send the player when the timeout fires (optional, can be null)
     */
    public void addEffectTimeout(final Player player, final PotionEffectType type, final int delay,
            final List<Player> trackingList, final String timeoutMessage)
    {
        int id = getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            public void run() {
                player.removePotionEffect(type);    // remove the effect
                cancelTimeout(player, type);        // cleanup the timer

                // remove them from the list, if there is one
                if( trackingList != null )
                    trackingList.remove(player);

                // send the message, if there is one
                if( timeoutMessage != null )
                    player.sendMessage(timeoutMessage);
            }
        }, delay);
        
        // get playerMap, or create new one if none exists
        Map<PotionEffectType, Integer> playerMap = tasks.get(player.getName());
        if( playerMap == null ) {
            playerMap = new HashMap<PotionEffectType, Integer>();
            tasks.put(player.getName(), playerMap);     // store the new map
        }
        
        playerMap.put(type, id);    // store the scheduleId
    }
    
    /** Cancel a scheduled timer and cleanup the hash.
     * 
     * @param player
     * @param type
     */
    public void cancelTimeout(final Player player, final PotionEffectType type) {
        Map<PotionEffectType, Integer> playerMap = tasks.get(player.getName());

        if( playerMap == null ) // don't do anything if we weren't tracking any tasks for this player
            return;
        
        Integer id = playerMap.remove(type);    // cleanup the timer from the hash
        if( id != null ) {
            getServer().getScheduler().cancelTask(id);  // cancel the Bukkit scheduled task
        }
    }

}