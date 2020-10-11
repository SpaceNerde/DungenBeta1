package de.spacenerd.swordartonline.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

	public static Inventory Warrior = Bukkit.createInventory(null, 36);
	public static Inventory Archer = Bukkit.createInventory(null, 36);
	public static Inventory Magic = Bukkit.createInventory(null, 36);
		
	
	public static void load() {
		Warrior.setItem(0, new ItemBuilder(Material.IRON_SWORD).setName("Starter Sword").setLore("Das ist das erste schwert das du bekommst", "Mach was drauﬂ").setUnbreakable(true).build());
		Warrior.setItem(8, new ItemStack(Material.GOLDEN_APPLE));
		
		Archer.setItem(0, new ItemBuilder(Material.BOW).setName("Starter Bow").setLore("Das ist dein erster bow den du bekommst", "Mach was drauﬂ").setUnbreakable(true).addEntchantment(Enchantment.ARROW_INFINITE, 1).HideFlag().build());
		Archer.setItem(8, new ItemStack(Material.ARROW));
		
		Magic.setItem(0, new ItemStack(Material.STICK));
		
		
	}
	
	
	
}


//ItemBuilder(Material.IRON_SWORD).setName("Starter Sword").setLore("Das ist das erste schwert das du bekommst", "Mach was drauﬂ").build());
//public ArrayList<ItemStack[]> items = new ArrayList<ItemStack[]>();
//@EventHandler
//public void onDamage(EntityDamageByEntityEvent event) {
//	if(event.getDamager() instanceof Player) {
//		Player p = (Player) event.getDamager();
//		if(p.getInventory().getItemInMainHand().equals(Warrior)) {
//			event.setDamage(50);
//		}
//	}
//}