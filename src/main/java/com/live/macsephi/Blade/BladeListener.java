package com.live.macsephi.Blade;

//Mackenzie - I need to inquire... This obvious entity: EnderDragonPart I'm guessing ensures that even the boss
//mob EnderDragon is slain by /deathblade 's effects, correct? I know you can't just know for sure, but is that
//what the code is also telling you?
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.live.macsephi.Frenz;

public class BladeListener implements Listener {
    private final Frenz me;

    public BladeListener(Frenz me) {
        this.me = me;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBladeEvent(EntityDamageByEntityEvent event) {
        if (((event.getDamager() instanceof Player))
                && (this.me.death.contains(event.getDamager()))) {
            event.setDamage(event.getDamage() * 5000);
            if ((event.getEntity() instanceof Player)) {
                this.me.isSlain.add((Player) event.getEntity());
            }
            return;
        }

        if ((event.getEntity() instanceof EnderDragonPart))
            return;
        int damage;
        if ((event.getDamager() instanceof Player)) {
            Player attacker = (Player) event.getDamager();
            damage = getNewDamage(event.getDamage(), attacker);
        } else {
            damage = event.getDamage();
        }

        if (!(event.getEntity() instanceof Player)) {
            event.setDamage(damage);
            return;
        }

        Player player = (Player) event.getEntity();
        if (this.me.obsidian.contains(player)) {
            int finalDamage = (int) (damage * 0.15D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.diamond.contains(player)) {
            int finalDamage = (int) (damage * 0.5D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.iron.contains(player)) {
            int finalDamage = (int) (damage * 0.6D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.gold.contains(player)) {
            int finalDamage = (int) (damage * 0.7D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.stone.contains(player)) {
            int finalDamage = (int) (damage * 0.8D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        if (this.me.wood.contains(player)) {
            int finalDamage = (int) (damage * 0.9D);
            if (finalDamage > 20)
                event.setDamage(20);
            else
                event.setDamage(finalDamage);
            return;
        }
        event.setDamage(damage);
    }

    public int getNewDamage(int damage, Player attacker) {
        if (this.me.bDivine.contains(attacker))
            return damage + 50;
        if (this.me.temper.contains(attacker))
            return damage + 20;
        if (this.me.extend.contains(attacker))
            return damage + 16;
        if (this.me.serrate.contains(attacker))
            return damage + 12;
        if (this.me.sharpen.contains(attacker))
            return damage + 8;
        if (this.me.carve.contains(attacker))
            return damage + 4;
        return damage;
    }
}