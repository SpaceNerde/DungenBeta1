package de.spacenerd.swordartonline.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.spacenerd.swordartonline.Waffen.Fire;
import de.spacenerd.swordartonline.Waffen.ZauberstaebeHandler;
import de.spacenerd.swordartonline.boss.SuperArcher;
import de.spacenerd.swordartonline.boss.SuperZombie;
import de.spacenerd.swordartonline.commands.DungenCommand;
import de.spacenerd.swordartonline.commands.SetDungen;
import de.spacenerd.swordartonline.commands.ShopSpawner;
import de.spacenerd.swordartonline.events.BossBar;
import de.spacenerd.swordartonline.events.DamageEvent;
import de.spacenerd.swordartonline.events.EntityDrops;
import de.spacenerd.swordartonline.listeners.JoinListener;
import de.spacenerd.swordartonline.mobs.Runner;
import de.spacenerd.swordartonline.shop.Merchant;
import de.spacenerd.swordartonline.shop.MerchantOffer;
import de.spacenerd.swordartonline.util.InventoryBuilder;
import de.spacenerd.swordartonline.util.ItemBuilder;
import de.spacenerd.swordartonline.util.KitManager;


public class Main extends JavaPlugin implements Listener{

	
	private static Main plugin;
	
	@Override
	public void onEnable() {
		plugin = this;
		
		ShopSpawner shop = new ShopSpawner();
		
		getCommand("setdungen").setExecutor(new SetDungen());
		getCommand("startdungen").setExecutor(new DungenCommand());
		getCommand("setrunner").setExecutor(new Runner());
		getCommand("setboss").setExecutor(new SuperZombie());
		getCommand("setarcherboss").setExecutor(new SuperArcher());
		getCommand("setshop").setExecutor(shop);
		
		Bukkit.getPluginManager().registerEvents(this, this);
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new EntityDrops(), this);
		pm.registerEvents(new DamageEvent(), this);
		pm.registerEvents(new BossBar(), this);
		pm.registerEvents(new KitManager(), this);
		pm.registerEvents(new ZauberstaebeHandler(this), this);
		pm.registerEvents(shop, this);
		InventoryBuilder.load();		   
	}
	
	@EventHandler
	public void onPLayerInteractEntityEvent(PlayerInteractEntityEvent e) {
		if(e.getRightClicked() instanceof Villager) {
			e.setCancelled(true);
			
			Merchant m = new Merchant();
			m.setTitle("§6Shop");
			m.setCustomer(e.getPlayer());
			
			MerchantOffer o = new MerchantOffer(new ItemBuilder(Material.SEEDS).setName("Coins").setLore("Money, Money, MOney").HideFlag().build(), new ItemBuilder(Material.DIAMOND_SWORD).setName("Super Sword").setLore("Das Schwert kann alles").setUnbreakable(true).HideFlag().build());
			m.addOffer(o);
			
			MerchantOffer o2 = new MerchantOffer(new ItemBuilder(Material.SEEDS).setName("Coins").setLore("Money, Money, MOney").HideFlag().build(), new ItemBuilder(Material.BLAZE_ROD).setName("Feuer Starb").setLore("Brutzel sie weg").setUnbreakable(true).HideFlag().build());
			m.addOffer(o2);
			
			m.openTrading(e.getPlayer());
		}
		
	}
	
	public static MerchantOffer getOffer(Material arg1, Material arg2) {
		MerchantOffer o = new MerchantOffer(new ItemStack(arg1), new ItemStack(arg2));
		
		
		return o;
	}
	
	
	public static Main getPlugin() {
		return plugin;
	}
	

}
//new ItemBuilder(Material.SEEDS).setName("Coins").setLore("Money, Money, MOney").HideFlag().build(), new ItemBuilder(Material.DIAMOND_SWORD).setName("Super Sword").setLore("Das Schwert kann alles").setUnbreakable(true).HideFlag().build()));



