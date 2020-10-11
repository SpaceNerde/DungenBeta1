package de.spacenerd.swordartonline.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;


import de.spacenerd.swordartonline.shop.Shop;


public class ShopSpawner implements CommandExecutor, Listener {


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("builder.shop")) {
				if(args.length == 0) {
					new Shop(p.getLocation());
				} else
					p.sendMessage("Ich glaube du hast dich vertippt");
			} else
				p.sendMessage("Server sagt NEIN!");
		}
		return false;
	}
	
	
	
	@EventHandler
	public void handleShopDamage(EntityDamageByEntityEvent e) {
		if(!(e.getEntity() instanceof Villager)) return;
		Villager shop = (Villager) e.getEntity();
		if(!(shop.getCustomName().equals(Shop.VILLAGER_NAME))) return;
		
		e.setCancelled(true);
		if(!(e.getDamager() instanceof Player)) return;
		Player p = (Player) e.getDamager();
		if(p.hasPermission("builder.shop.kill")) {
			if(p.getItemInHand().getType() == Material.LAVA_BUCKET) {
				shop.setHealth(0);
			}
		}
	}
	
	
	
	
	

}

//new ItemBuilder(Material.BOW).setName("Starter Bow").setLore("Das ist dein erster bow den du bekommst", "Mach was drauﬂ").setUnbreakable(true).addEntchantment(Enchantment.ARROW_INFINITE, 1).HideFlag().build());
