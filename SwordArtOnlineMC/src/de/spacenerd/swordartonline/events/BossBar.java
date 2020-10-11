package de.spacenerd.swordartonline.events;


import java.util.List;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BossBar implements Listener{
	

	public static BossBar createBossBar(Plugin plugin, LivingEntity livingEntity, String title, BarColor color, BarStyle style, BarFlag... flags) {
		BossBar bossBar = (BossBar) plugin.getServer().createBossBar(title, color, style, flags);
		new BukkitRunnable() {
			public void run() {
				if (!livingEntity.isDead()) {
					((org.bukkit.boss.BossBar) bossBar).setProgress(livingEntity.getHealth() / livingEntity.getMaxHealth());
				}else {
					List<Player> players = ((org.bukkit.boss.BossBar) bossBar).getPlayers();
					for (Player player : players) {
						((org.bukkit.boss.BossBar) bossBar).removePlayer(player);
					}
					
					((org.bukkit.boss.BossBar) bossBar).setVisible(false);
					cancel();
				}				
			}	
		}.runTask(plugin);
		return bossBar;		
	}			  	
}


