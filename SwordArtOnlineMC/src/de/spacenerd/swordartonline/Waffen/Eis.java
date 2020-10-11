package de.spacenerd.swordartonline.Waffen;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;


import de.spacenerd.swordartonline.main.Main;

public class Eis extends Zauberstaebe{

	public Eis(Main plugin, Material material, long reloadTime, double damage) {
		super(plugin, material, reloadTime, damage);
	
	}

	@Override
	public void shootEffects(Player p) {
		Snowball projectile = p.launchProjectile(Snowball.class);
		
	}

}
