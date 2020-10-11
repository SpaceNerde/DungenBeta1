package de.spacenerd.swordartonline.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class KitManager implements Listener{
	
	private final String GUI_NAME = "§cKiT";
	
	public void openGUI(Player player) {
		Inventory iventory = Bukkit.createInventory(null, 9*3, GUI_NAME);
		iventory.setItem(11, new ItemStack(Material.IRON_SWORD));
		iventory.setItem(13, new ItemStack(Material.STICK));
		iventory.setItem(15, new ItemStack(Material.BOW));
		player.openInventory(iventory);
	}
	
	@EventHandler
	public void handleKitManagerOpener(PlayerInteractEvent event) {
		if(event.getItem().getType() != Material.BOOK) return;
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
			openGUI(event.getPlayer());
	}
	
	@EventHandler
	public void handleKitManagerGUIClick(InventoryClickEvent event) {
		if(!(event.getWhoClicked() instanceof Player)) return;
		Player p = (Player) event.getWhoClicked();
		if(event.getClickedInventory().getTitle().equals(GUI_NAME)) {
			event.setCancelled(true);
			switch(event.getCurrentItem().getType()) {
			
			case IRON_SWORD:
				p.getInventory().setContents(Kits.WARRIOR.getContents());
				break;
			case BOW:
				p.getInventory().setContents(Kits.ARCHER.getContents());
				break;
			case STICK:
				p.getInventory().setContents(Kits.MAGIC.getContents());
				break;
			default:
				
				break;
				
			}
		}
	}

}
