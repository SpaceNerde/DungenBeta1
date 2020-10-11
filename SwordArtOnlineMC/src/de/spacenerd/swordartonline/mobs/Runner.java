package de.spacenerd.swordartonline.mobs;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;


import de.spacenerd.swordartonline.main.Main;


public class Runner implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("player.dungen")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Dungen.World", p.getWorld().getName());
					config.set("Mob.X", p.getLocation().getX());
					config.set("Mob.Y", p.getLocation().getY());
					config.set("Mob.Z", p.getLocation().getZ());
					config.set("Mob.Yaw", p.getLocation().getYaw());
					config.set("Mob.Pitch", p.getLocation().getPitch());
					Main.getPlugin().saveConfig();
			
				}else
					p.sendMessage("§cIch glaube du dich vertippt");
			}else
				p.sendMessage("§cServer sagt NEIN!");
		}
		return true;
	}
}
