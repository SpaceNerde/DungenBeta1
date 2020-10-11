package de.spacenerd.swordartonline.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;

import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import de.spacenerd.swordartonline.main.Main;
import de.spacenerd.swordartonline.util.ItemBuilder;


public class DungenCommand implements CommandExecutor{

	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
	
	Player p = (Player) sender;
		if(sender instanceof Player) {
			
			if(p.hasPermission("player.dungen")) {
				if(args.length == 0) {
					
						
						
					p.getInventory().clear();
					p.getInventory().addItem(new ItemBuilder(Material.BOOK).setName("KIT").build());
					FileConfiguration config = Main.getPlugin().getConfig();
					World world = Bukkit.getWorld(config.getString("Dungen.World"));
					double x = config.getDouble("Room.X");
					double y = config.getDouble("Room.Y");
					double z = config.getDouble("Room.Z");
					float yaw = (float) config.getDouble("Room.Yaw");
					float pitch = (float) config.getDouble("Room.Pitch");
					Location location = new Location(world, x, y, z, yaw, pitch);
					p.teleport(location);
								 
								 
														
										
					double x1 = config.getDouble("Mob.X");
					double y1 = config.getDouble("Mob.Y");
					double z1 = config.getDouble("Mob.Z");
					float yaw1 = (float) config.getDouble("Mob.Yaw");
					float pitch1 = (float) config.getDouble("Mob.Pitch");
						
					Location location1 = new Location(world, x1, y1, z1, yaw1, pitch1);
								
							
					Zombie zombie = p.getWorld().spawn(location1, Zombie.class);
								
								
					zombie.setGlowing(true);
					zombie.setCustomName(ChatColor.RED+"Runner");
					zombie.setCustomNameVisible(true);
					zombie.setBaby(true);
					zombie.setTarget(p);
					
					
					EntityEquipment equipment = zombie.getEquipment();
					equipment.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					equipment.setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
					equipment.setHelmetDropChance(0);
					equipment.setItemInMainHandDropChance(0);
					
					
					
					double x2 = config.getDouble("Boss.X");
					double y2 = config.getDouble("Boss.Y");
					double z2 = config.getDouble("Boss.Z");
					float yaw2 = (float) config.getDouble("Boss.Yaw");
					float pitch2 = (float) config.getDouble("Boss.Pitch");
						
					Location location2 = new Location(world, x2, y2, z2, yaw2, pitch2);
								
							
					Zombie boss = p.getWorld().spawn(location2, Zombie.class);
								
					boss.setCustomName(ChatColor.RED+"Boss");	
					boss.setCustomNameVisible(true);
					boss.setGlowing(true);
					boss.setBaby(false);
					boss.setTarget(p);
					
					EntityEquipment bossequipment = boss.getEquipment();
					bossequipment.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					bossequipment.setItemInMainHand(new ItemStack(Material.DIAMOND_AXE));
					bossequipment.setHelmetDropChance(0);
					bossequipment.setItemInMainHandDropChance(0);
					
					double x21 = config.getDouble("Boss.X");
					double y21 = config.getDouble("Boss.Y");
					double z21 = config.getDouble("Boss.Z");
					float yaw21 = (float) config.getDouble("Boss.Yaw");
					float pitch21 = (float) config.getDouble("Boss.Pitch");
						
					Location location21 = new Location(world, x21, y21, z21, yaw21, pitch21);
								
							
					Skeleton archerboss = p.getWorld().spawn(location21, Skeleton.class);
								
								
					archerboss.setGlowing(true);
					archerboss.setCustomName(ChatColor.RED+"Boss");
					archerboss.setCustomNameVisible(true);
					archerboss.setTarget(p);
					
					
					
					EntityEquipment archerbossequipment = archerboss.getEquipment();
					archerbossequipment.setHelmet(new ItemStack(Material.DIAMOND_HELMET));
					archerbossequipment.setItemInMainHand(new ItemStack(Material.BOW));
					archerbossequipment.setHelmetDropChance(0);
					archerbossequipment.setItemInMainHandDropChance(0);
					
					
					
							
					
					
					
					
								
							
						
					
						
					
					
				}else
					p.sendMessage("§cIch glaube du dich vertippt");
			}else
				p.sendMessage("§cServer sagt NEIN!");
		}
		return true;
	}

}

//int e = Integer.parseInt(args[0]);
//for(int i = 0; i < e; i++) {