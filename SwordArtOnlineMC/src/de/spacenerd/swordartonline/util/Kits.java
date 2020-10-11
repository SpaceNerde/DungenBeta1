package de.spacenerd.swordartonline.util;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public enum Kits {
	
	ARCHER("ARCHER",InventoryBuilder.Archer),
	MAGIC("MAGIC",InventoryBuilder.Magic),
	WARRIOR("WARRIOR",InventoryBuilder.Warrior);
	

	String name;
	Inventory inventory;
	
	Kits(String name, Inventory inventory) {
		this.name = name;
		this.inventory = inventory;
	}
	
	public ItemStack[] getContents() {
		return this.inventory.getContents();
	}
	
	public String getName() {
		return this.name;
	}
	
}
