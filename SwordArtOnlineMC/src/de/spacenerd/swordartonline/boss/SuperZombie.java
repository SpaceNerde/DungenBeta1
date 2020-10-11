package de.spacenerd.swordartonline.boss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import de.spacenerd.swordartonline.main.Main;
import net.minecraft.server.v1_12_R1.EntityZombie;




public class SuperZombie implements CommandExecutor {

	
		
	

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("group.builder")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Dungen.World", p.getWorld().getName());
					config.set("Boss.X", p.getLocation().getX());
					config.set("Boss.Y", p.getLocation().getY());
					config.set("Boss.Z", p.getLocation().getZ());
					config.set("Boss.Yaw", p.getLocation().getYaw());
					config.set("Boss.Pitch", p.getLocation().getPitch());
					Main.getPlugin().saveConfig();
			
				}else
					p.sendMessage("§cIch glaube du dich vertippt");
			}else
				p.sendMessage("§cServer sagt NEIN!");
		}
		return true;
	}
	
	

}
