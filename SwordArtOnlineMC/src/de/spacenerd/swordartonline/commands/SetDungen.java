package de.spacenerd.swordartonline.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.spacenerd.swordartonline.main.Main;

public class SetDungen implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("builder.dungen")) {
				if(args.length == 0) {
					
					FileConfiguration config = Main.getPlugin().getConfig();
					config.set("Dungen.World", p.getWorld().getName());
					config.set("Room.X", p.getLocation().getX());
					config.set("Room.Y", p.getLocation().getY());
					config.set("Room.Z", p.getLocation().getZ());
					config.set("Room.Yaw", p.getLocation().getYaw());
					config.set("Room.Pitch", p.getLocation().getPitch());
					Main.getPlugin().saveConfig();
					p.sendMessage("§aDa hst du dein DungenSpawn umgesetzt");
					
				}else
					p.sendMessage("§cIch glaube du hast dich verdippt");
			}else 
				p.sendMessage("§cServer sagt NEIN!");
		}
		
		return false;
	}

}
