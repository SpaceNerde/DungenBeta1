package de.spacenerd.swordartonline.shop;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Shop {
	
	public static final String VILLAGER_NAME = "§6§lShop";

	public Shop(Location loc) {
		Villager shop = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
		shop.setCustomName(Shop.VILLAGER_NAME);
		shop.setCustomNameVisible(true);
		shop.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 500));
	}

}
