package de.spacenerd.swordartonline.events;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;


import de.spacenerd.swordartonline.util.ItemBuilder;

public class EntityDrops implements Listener{
	
//	private Main plugin = Main.getPlugin(Main.class);
	
	@EventHandler
	public void mobDeath(EntityDeathEvent e) {
		e.getDrops().clear();
		e.setDroppedExp(10);
		
		LivingEntity l = e.getEntity();
		
		if(l instanceof Zombie) {
			l.getLocation().getWorld().dropItem(l.getLocation(), new ItemBuilder(Material.SEEDS).setName("Coins").setAmount(1).setLore("Money, Money, MOney").HideFlag().build());
		}if(l instanceof Skeleton){
			l.getLocation().getWorld().dropItem(l.getLocation(), new ItemBuilder(Material.SEEDS).setName("Coins").setAmount(1).setLore("Money, Money, MOney").HideFlag().build());
		}
	}		
}
