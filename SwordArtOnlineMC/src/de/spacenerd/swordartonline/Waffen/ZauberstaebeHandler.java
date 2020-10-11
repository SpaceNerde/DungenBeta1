package de.spacenerd.swordartonline.Waffen;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.spacenerd.swordartonline.main.Main;

public class ZauberstaebeHandler implements Listener{

	private ArrayList<Zauberstaebe> zauberstab;
	
	public ZauberstaebeHandler(Main plugin) {
		zauberstab = new ArrayList<>();
		zauberstab.add(new Eis(plugin, Material.STICK, 5, 2.0));
		zauberstab.add(new Fire(plugin, Material.BLAZE_ROD, 9, 10.0));
	}
	
	@EventHandler
	public void handleWeaponShot(PlayerInteractEvent e) {
		if(e.getAction() != Action.RIGHT_CLICK_AIR) return;
		Zauberstaebe zauberstab = checkWeaponMaterial(e.getItem().getType());
		if(zauberstab != null) 
			zauberstab.shoot(e.getPlayer());
	}
	
	@EventHandler
	public void handleWeaponDamage(EntityDamageByEntityEvent e) {
		if(!(e.getDamager() instanceof Projectile)) return;
		Projectile porjectile = (Projectile) e.getDamager();
		if(!(porjectile.getShooter() instanceof Player)) return;
		Player player = (Player) porjectile.getShooter();
		Zauberstaebe zauberstab = checkWeaponMaterial(player.getItemInHand().getType());
		if(zauberstab != null)
			e.setDamage(zauberstab.getDamage());
	}
	
	private Zauberstaebe checkWeaponMaterial(Material material) {
		for(Zauberstaebe current : zauberstab) {
			if(current.getMaterial() == material)
				return current;
		}
		return null;
	}
}
