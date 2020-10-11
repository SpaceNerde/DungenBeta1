package de.spacenerd.swordartonline.Waffen;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import de.spacenerd.swordartonline.main.Main;

public abstract class Zauberstaebe {
	
	private Main plugin;
	private Material material;
	private long reloadTime;
	private double damage;	
	private ArrayList<String> zauberStab;	
	
	public Zauberstaebe(Main plugin, Material material, long reloadTime, double damage) {	
		this.plugin = plugin;
		this.material = material;
		this.reloadTime = reloadTime;
		this.damage = damage;
		
		zauberStab = new ArrayList<>();
	}
	
	public void shoot(Player p) {
		if(!zauberStab.contains(p.getName())) {
			zauberStab.add(p.getName());
			shootEffects(p);
			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				@Override
				public void run() {
					zauberStab.remove(p.getName());
				}			
			}, reloadTime);
		}else {
			p.sendMessage("§cDein Mana füllt sich gerade auf");
		}
		
	}
	
	public abstract void shootEffects(Player p);
	
	public Material getMaterial() {
		return material;
	}
	
	public double getDamage() {
		return damage;
	}
		
	
}
