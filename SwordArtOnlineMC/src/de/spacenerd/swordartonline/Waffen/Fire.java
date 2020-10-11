package de.spacenerd.swordartonline.Waffen;

import org.bukkit.Material;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;

import de.spacenerd.swordartonline.main.Main;

public class Fire extends Zauberstaebe{

	public Fire(Main plugin, Material material, long reloadTime, double damage) {
		super(plugin, material, reloadTime, damage);
	
	}

	@Override
	public void shootEffects(Player p) {
		Fireball projectile = p.launchProjectile(Fireball.class);
		projectile.setInvulnerable(false);
		projectile.setYield(0f);
	}

}
