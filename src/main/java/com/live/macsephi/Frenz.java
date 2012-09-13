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
*/
package com.live.macsephi;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.server.EntityLiving;
import net.minecraft.server.EntityPlayer;
import net.minecraft.server.MobEffect;
import net.minecraft.server.Packet42RemoveMobEffect;
//Mackenzie - Does this import have to do with the HashMap?

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

import com.live.macsephi.FrenzListener;
import com.live.macsephi.Admin.BoomExecutor;
import com.live.macsephi.Admin.KitExecutor;
import com.live.macsephi.Admin.ReloadFrenzCommand;
import com.live.macsephi.Admin.ShutUpCommand;
import com.live.macsephi.Arm.ChargeArmCommand;
import com.live.macsephi.Arm.DivineArmCommand;
import com.live.macsephi.Arm.FrenzyArmCommand;
import com.live.macsephi.Arm.PickaxeArmCommand;
import com.live.macsephi.Arm.PowerArmCommand;
import com.live.macsephi.Arm.StrengthArmCommand;
import com.live.macsephi.Blade.CarveBladeCommand;
import com.live.macsephi.Blade.DeathBladeCommand;
import com.live.macsephi.Blade.DivineBladeCommand;
import com.live.macsephi.Blade.ExtendBladeCommand;
import com.live.macsephi.Blade.SerrateBladeCommand;
import com.live.macsephi.Blade.SharpenBladeCommand;
import com.live.macsephi.Blade.TemperBladeCommand;
import com.live.macsephi.MiscCommands.CureCommand;
import com.live.macsephi.MiscCommands.CureMoreCommand;
import com.live.macsephi.MiscCommands.CurseCommand;
import com.live.macsephi.MiscCommands.DistortCommand;
import com.live.macsephi.MiscCommands.FoodCommand;
import com.live.macsephi.MiscCommands.FullRestoreCommand;
import com.live.macsephi.MiscCommands.OffCommand;
import com.live.macsephi.MiscCommands.SliceCommand;
import com.live.macsephi.MiscCommands.SuperDistortCommand;
import com.live.macsephi.Shield.DiamondShieldCommand;
import com.live.macsephi.Shield.GoldShieldCommand;
import com.live.macsephi.Shield.IronShieldCommand;
import com.live.macsephi.Shield.ObsidianShieldCommand;
import com.live.macsephi.Shield.StoneShieldCommand;
import com.live.macsephi.Shield.WoodShieldCommand;
import com.live.macsephi.Speed.DivineSpeedCommand;
import com.live.macsephi.Speed.ExtraSpeedCommand;
import com.live.macsephi.Speed.GodSpeedCommand;
import com.live.macsephi.Speed.HiSpeedCommand;
import com.live.macsephi.Speed.HyperSpeedCommand;
import com.live.macsephi.Speed.SuperSpeedCommand;

public class Frenz extends JavaPlugin {
    private static final String PERMISSION_BASE = "Frenz.";
    
    private Logger log;
    
    public FileConfiguration config;
    private File configFile;
    protected boolean disableFireCharges;
    public ArrayList<TNTPrimed> tntPrimed = new ArrayList<TNTPrimed>();
    public ArrayList<TNTPrimed> napalm = new ArrayList<TNTPrimed>();
    public ArrayList<Player> obsidian = new ArrayList<Player>();
    public ArrayList<Player> wood = new ArrayList<Player>();
    public ArrayList<Player> stone = new ArrayList<Player>();
    public ArrayList<Player> iron = new ArrayList<Player>();
    public ArrayList<Player> diamond = new ArrayList<Player>();
    public ArrayList<Player> gold = new ArrayList<Player>();
    public ArrayList<Player> carve = new ArrayList<Player>();
    public ArrayList<Player> sharpen = new ArrayList<Player>();
    public ArrayList<Player> serrate = new ArrayList<Player>();
    public ArrayList<Player> extend = new ArrayList<Player>();
    public ArrayList<Player> temper = new ArrayList<Player>();
    public ArrayList<Player> bDivine = new ArrayList<Player>();
    public ArrayList<Player> sDivine = new ArrayList<Player>();
    public ArrayList<Player> aDivine = new ArrayList<Player>();
    public ArrayList<Player> isEmo = new ArrayList<Player>();
    public ArrayList<Player> isOwner = new ArrayList<Player>();
    public ArrayList<Player> death = new ArrayList<Player>();
    public ArrayList<Player> isSlain = new ArrayList<Player>();
    
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
            getCommand("cure").setExecutor(new CureCommand(this));
            getCommand("curemore").setExecutor(new CureMoreCommand(this));
            getCommand("fullrestore").setExecutor(new FullRestoreCommand(this));
            getCommand("carveblade").setExecutor(new CarveBladeCommand(this));
            getCommand("sharpenblade").setExecutor(new SharpenBladeCommand(this));
            getCommand("serrateblade").setExecutor(new SerrateBladeCommand(this));
            getCommand("extendblade").setExecutor(new ExtendBladeCommand(this));
            getCommand("temperblade").setExecutor(new TemperBladeCommand(this));
            getCommand("divineblade").setExecutor(new DivineBladeCommand(this));
            getCommand("strengtharm").setExecutor(new StrengthArmCommand(this));
            getCommand("chargearm").setExecutor(new ChargeArmCommand(this));
            getCommand("powerarm").setExecutor(new PowerArmCommand(this));
            getCommand("frenzyarm").setExecutor(new FrenzyArmCommand(this));
            getCommand("pickaxearm").setExecutor(new PickaxeArmCommand(this));
            getCommand("divinearm").setExecutor(new DivineArmCommand(this));
            getCommand("extraspeed").setExecutor(new ExtraSpeedCommand(this));
            getCommand("hispeed").setExecutor(new HiSpeedCommand(this));
            getCommand("superspeed").setExecutor(new SuperSpeedCommand(this));
            getCommand("hyperspeed").setExecutor(new HyperSpeedCommand(this));
            getCommand("godspeed").setExecutor(new GodSpeedCommand(this));
            getCommand("divinespeed").setExecutor(new DivineSpeedCommand(this));
            getCommand("off").setExecutor(new OffCommand(this));
            getCommand("woodshield").setExecutor(new WoodShieldCommand(this));
            getCommand("stoneshield").setExecutor(new StoneShieldCommand(this));
            getCommand("goldshield").setExecutor(new GoldShieldCommand(this));
            getCommand("ironshield").setExecutor(new IronShieldCommand(this));
            getCommand("diamondshield").setExecutor(new DiamondShieldCommand(this));
            getCommand("obsidianshield").setExecutor(new ObsidianShieldCommand(this));
            getCommand("deathblade").setExecutor(new DeathBladeCommand(this));
            getCommand("freload").setExecutor(new ReloadFrenzCommand(this));
            getCommand("food").setExecutor(new FoodCommand(this));
        } catch (Exception e) {
            log.warning("[MobEffects] ERROR " + e);
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
        // Mackenzie - I have some research to do on config.yml. If you have any advice on it for a beginner, I'd
        //most certainly appreciate any given. I understand the DisableFireCharges, but this brings us back to
        //do I want to change my own oil, or know how the deeper mechanisms work? We both know it is the deeper
        //mechanisms/mechanics.
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
    public void removeMobEffect(LivingEntity entity, int type) {
        try {
            if ((entity instanceof Player)) {
                EntityPlayer player = ((CraftPlayer) entity).getHandle();
                player.netServerHandler.sendPacket(new Packet42RemoveMobEffect(
                        player.id, new MobEffect(type, 0, 0)));
            }
            Field field = EntityLiving.class.getDeclaredField("effects");
            field.setAccessible(true);

            //Mackenzie - I see you had to supress the warnings. Could you suggest a way for me to test this
            //particular function is still working correctly? I'm still trying to wrap my finger around the whole
            //HashMap system, its purpose and functionality.
            @SuppressWarnings("rawtypes")
            HashMap effects = (HashMap) field.get(((CraftLivingEntity) entity)
                    .getHandle());
            effects.remove(Integer.valueOf(type));
        } catch (Exception localException) {
        }
    }
    public void setMobEffect(LivingEntity entity, int type, int duration,
            int amplifier) {
        ((CraftLivingEntity) entity).getHandle().addEffect(
                new MobEffect(type, duration, amplifier));
    }
}