/* Mackenzie - Commit 2: Sacred Wool functionality successfully removed all traces. Verified in-game that it
* has not only been removed, but your changes such as the new hasPluginPermissions works fully, which it does!
* No errors or warnings at this point, no stack trace or errors onEnable of test. Looks good.
* 
* Commit 3: Testing to see if pushing this time correctly displays changes on Github.
* 
* Commit 4: Verified a few other functions are still error free in some of the Admin class commands.
* Completely remove the "reloadme" command and effectively replaced it with a new class "freload" appropriately
* changing the relative name in the code alone, without any personal or core changes. Tidied up the loose ends it
* left behind. Plugin tested, fully functional as per these changes.
* 
* Commit 5: Despite there being no errors during the plugin test, upon loading the plugin to localhost I
* received a Null Pointer Exception without a stacktrace, but quickly identified (and learned a valuable lesson)
* that it was because I didn't remove the:
*             getCommand("implode").setExecutor(this.boomExecutor);
* while implementing more removal changes. Changes include a small back door in KitExecutor class, removal of
* the /implode command and its functions, with a small inquiry in the AdminListener class (comment). Second
* plugin test has it functioning fully once again!
* 
* Commit 6: Quite a few larger changes this time, main listener class MEListener deleted and appropriately
* replaced with FrenzListener, all ties to the changes successfully cleaned up without error or warning, and
* same applies to the other changes, which includes removing AztecListener class and RecipeHandler class, making
* necessary changes to compensate within the main Frenz class. Updated plugin.yml
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

import com.live.macsephi.Admin.AdminListener;
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
import com.live.macsephi.Blade.BladeListener;
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
/*Does this import perchance have to do with the HashMap? 
* Mackenzie 12/09/2012
*/
//Mackenzie - Removed imports to no longer existing SacredWool classes.
//Mackenzie - Removed imports to no longer existing EmosuicideCommand class.

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
    //Mackenzie - Where are these two arrays used elsewhere? "isEmo, isOwner"
    public ArrayList<Player> isEmo = new ArrayList<Player>();
    public ArrayList<Player> isOwner = new ArrayList<Player>();
    //Mackenzie - Is this array "death" used anywhere since you cleaned out death messages? Things to consider:
    //DeathBladeCommand, BladeListener, Shield commands.
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
        //Mackenzie - Removed SacredListener registerEvents
        pm.registerEvents(new BladeListener(this), this);
        pm.registerEvents(new AdminListener(this, this.config), this);

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

            // Mackenzie - Removed SacredWool getCommand
            getCommand("shutup").setExecutor(new ShutUpCommand(this));
            getCommand("distort").setExecutor(new DistortCommand(this));
            getCommand("superdistort").setExecutor(new SuperDistortCommand(this));
            // Mackenzie - Removed emosuicide getCommand
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

        if (!this.config.contains("Enchantments.DiscountedCost(%)")) {
            this.config.set("Enchantments.DiscountedCost(%)",
                    Integer.valueOf(50));
        }
        if (!this.config.contains("DeathMessages.Explosion.Enabled")) {
            this.config.set("DeathMessages.Explosion.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Explosion.Message")) {
            this.config.set("DeathMessages.Explosion.Message", "has exploded!");
        }
        if (!this.config.contains("DeathMessages.Suicide.Enabled")) {
            this.config.set("DeathMessages.Suicide.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Suicide.Message")) {
            this.config.set("DeathMessages.Suicide.Message",
                    "has committed suicide!");
        }
        if (!this.config.contains("DeathMessages.Drowning.Enabled")) {
            this.config.set("DeathMessages.Drowning.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Drowning.Message")) {
            this.config.set("DeathMessages.Drowning.Message", "has drowned!");
        }
        if (!this.config.contains("DeathMessages.Fall.Enabled")) {
            this.config.set("DeathMessages.Fall.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Fall.Message")) {
            this.config.set("DeathMessages.Fall.Message",
                    "has fallen to their death!");
        }
        if (!this.config.contains("DeathMessages.Fire.Enabled")) {
            this.config.set("DeathMessages.Fire.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Fire.Message")) {
            this.config.set("DeathMessages.Fire.Message",
                    "has burned to death!");
        }
        if (!this.config.contains("DeathMessages.Lava.Enabled")) {
            this.config.set("DeathMessages.Lava.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Lava.Message")) {
            this.config.set("DeathMessages.Lava.Message",
                    "has burned to death!");
        }
        if (!this.config.contains("DeathMessages.Lightning.Enabled")) {
            this.config.set("DeathMessages.Lightning.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Lightning.Message")) {
            this.config.set("DeathMessages.Lightning.Message",
                    "has been struck down by the gods!");
        }
        if (!this.config.contains("DeathMessages.Magic.Enabled")) {
            this.config.set("DeathMessages.Magic.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Magic.Message")) {
            this.config.set("DeathMessages.Magic.Message",
                    "has been killed by magic!");
        }
        if (!this.config.contains("DeathMessages.Poison.Enabled")) {
            this.config.set("DeathMessages.Poison.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Poison.Message")) {
            this.config.set("DeathMessages.Poison.Message",
                    "has died from poison!");
        }
        if (!this.config.contains("DeathMessages.Starvation.Enabled")) {
            this.config.set("DeathMessages.Starvation.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Starvation.Message")) {
            this.config.set("DeathMessages.Starvation.Message",
                    "has starved to death!");
        }
        if (!this.config.contains("DeathMessages.Suffocation.Enabled")) {
            this.config.set("DeathMessages.Suffocation.Enabled",
                    Boolean.valueOf(false));
        }
        if (!this.config.contains("DeathMessages.Suffocation.Message")) {
            this.config.set("DeathMessages.Suffocation.Message",
                    "has suffocated!");
        }
        if (!this.config.contains("DisableFireCharges")) {
            this.config.set("DisableFireCharges", Boolean.valueOf(true));
        }

        this.disableFireCharges = this.config.getBoolean("DisableFireCharges",
                true);

        String[] worlds = { "sollidium", "syradia", "eklimata", "aquarius",
                "tamriel", "oblivion", "terralite", "aztec", "earth",
                "earth_nether" };
        for (String world : worlds) {
            if (!this.config.contains("EnabledMobs." + world + ".Ocelot")) {
                this.config.set("EnabledMobs." + world + ".Ocelot",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".IronGolem")) {
                this.config.set("EnabledMobs." + world + ".IronGolem",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Blaze")) {
                this.config.set("EnabledMobs." + world + ".Blaze",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Cave-Spider")) {
                this.config.set("EnabledMobs." + world + ".Cave-Spider",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Chicken")) {
                this.config.set("EnabledMobs." + world + ".Chicken",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Cow")) {
                this.config.set("EnabledMobs." + world + ".Cow",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Creeper")) {
                this.config.set("EnabledMobs." + world + ".Creeper",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Ender Dragon")) {
                this.config.set("EnabledMobs." + world + ".Ender Dragon",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Enderman")) {
                this.config.set("EnabledMobs." + world + ".Enderman",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Ghast")) {
                this.config.set("EnabledMobs." + world + ".Ghast",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Magma Cube")) {
                this.config.set("EnabledMobs." + world + ".Magma Cube",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Mooshroom")) {
                this.config.set("EnabledMobs." + world + ".Mooshroom",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Pig")) {
                this.config.set("EnabledMobs." + world + ".Pig",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Pigman")) {
                this.config.set("EnabledMobs." + world + ".Pigman",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Sheep")) {
                this.config.set("EnabledMobs." + world + ".Sheep",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Silverfish")) {
                this.config.set("EnabledMobs." + world + ".Silverfish",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Skeleton")) {
                this.config.set("EnabledMobs." + world + ".Skeleton",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Slime")) {
                this.config.set("EnabledMobs." + world + ".Slime",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Snowman")) {
                this.config.set("EnabledMobs." + world + ".Snowman",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Spider")) {
                this.config.set("EnabledMobs." + world + ".Spider",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Squid")) {
                this.config.set("EnabledMobs." + world + ".Squid",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Villager")) {
                this.config.set("EnabledMobs." + world + ".Villager",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Wolf")) {
                this.config.set("EnabledMobs." + world + ".Wolf",
                        Boolean.valueOf(true));
            }
            if (!this.config.contains("EnabledMobs." + world + ".Zombie")) {
                this.config.set("EnabledMobs." + world + ".Zombie",
                        Boolean.valueOf(true));
            }
        }
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

    /** Warning due to raw type, this is using CraftBukkit instead of
     * Bukkit API. Need to look at if there is a way to do this without
     * using CraftBukkit.  -morganm 9/11/12
     * 
     * Update: there is, it involves .removePotionEffect() call, which
     * requires converting the raw integer 2nd argument into a 
     * PotionEffectType class (has impact on all calling classes, big
     * change that requires careful testing to be sure we get it all
     * right).  -morganm 9/11/12
     * 
     * @param entity
     * @param type
     */
    public void removeMobEffect(LivingEntity entity, int type) {
        try {
            if ((entity instanceof Player)) {
                EntityPlayer player = ((CraftPlayer) entity).getHandle();
                player.netServerHandler.sendPacket(new Packet42RemoveMobEffect(
                        player.id, new MobEffect(type, 0, 0)));
            }
            Field field = EntityLiving.class.getDeclaredField("effects");
            field.setAccessible(true);

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