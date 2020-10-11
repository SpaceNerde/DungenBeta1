package de.spacenerd.swordartonline.listeners;



import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import de.spacenerd.swordartonline.util.ItemBuilder;





public class JoinListener implements Listener{
	
	
	
	Plugin plugin;
	public JoinListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void handlePlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		p.getInventory().clear();
		p.getInventory().addItem(new ItemBuilder(Material.SEEDS).setName("Coins").setLore("Money, Money, MOney").HideFlag().build());
		
		
	}
	
	

}
