package de.spacenerd.swordartonline.util;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder {
	
	private ItemStack item;
	private ItemMeta itemMeta;
	
	public ItemBuilder(Material material, short subID) {
		item = new ItemStack(material, 1, subID);
		itemMeta = item.getItemMeta();
	}
	
	public ItemBuilder(Material material) {
		this(material, (short)0);
	}
	
	public ItemBuilder setName(String name) {
		itemMeta.setDisplayName(name);
		return this;
	}
	
	public ItemBuilder setLore(String... lore) {
		itemMeta.setLore(Arrays.asList(lore));
		return this;
	}
	
	public ItemBuilder setUnbreakable(boolean b) {
		itemMeta.setUnbreakable(true);
		return this;
	}
	
	public ItemBuilder setAmount(int amount) {
		item.setAmount(amount);
		return this;
	}
	public ItemBuilder setAttribute(String attribute) {
		item.setData(null);
		return this;		
	}
	
	public ItemBuilder addEntchantment(Enchantment entchantment,int level) {
		itemMeta.addEnchant(entchantment, level, false);
		return this;
	}
		
	public ItemBuilder HideFlag(ItemFlag itemflag) {
		itemMeta.addItemFlags(itemflag);
		return this;		
	}
	
	public ItemBuilder HideFlag() {
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		itemMeta.addItemFlags(ItemFlag.HIDE_DESTROYS);
		itemMeta.addItemFlags(ItemFlag.HIDE_PLACED_ON);
		itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		return this;		
	}
				
	
	
	public ItemStack build() {
		item.setItemMeta(itemMeta);
		return item;
	}

	

}
