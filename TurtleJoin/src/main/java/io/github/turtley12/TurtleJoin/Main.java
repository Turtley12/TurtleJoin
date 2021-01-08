package io.github.turtley12.TurtleJoin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		//on enable
		
		//save default config from jar file
		this.saveDefaultConfig();
		
		//create instance of turtlejoin config class and load config variabled from config.yml
		Config c = new Config(this);
		c.reload();
		
		//if plugin is enabled in config, startup message and register PlayerJoin listener
		//else, say that it is not enabled and tell how to enable it in config
		FileConfiguration config = this.getConfig();
		if (config.getBoolean("enabled")) {
			getLogger().info("-----------------------------------");
			getLogger().info("|TurtleJoin Succesfully Enabled!  |");
			getLogger().info("|      ______   ___               |");
			getLogger().info("|     /      \\ (__*)              |");
			getLogger().info("|    |________|/                  |");
			getLogger().info("|     |_|  |_|                    |");
			getLogger().info("|TurtleJoin Written by Turtley12  |");
			getLogger().info("-----------------------------------");
			//register PlayerJoinListener
			getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
			
			
		}
		else {
			getLogger().info("TurtleJoin Enabled");
			getLogger().info("You have disabled TurtleJoin in the config file. ");
			getLogger().info("To enable TurtleJoin, go to /plugins/TurtleJoin/config.yml");
			getLogger().info("and change enabled to 'true'");
		}
		
	}
	
	@Override
	public void onDisable() {
		//on disable
		getLogger().info("TurtleJoin Diabled");
	}
	private PluginDescriptionFile pdf = this.getDescription(); //Get plugin.yml
	//on command for turtlejoin. this has the turtlejoin version and reload commands
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,  String[] args) {
		if (cmd.getName().equalsIgnoreCase("turtlejoin")) { //if the command was "turtlejoin"
			if (sender.hasPermission("turtlejoin.admin")) {
				if (args.length < 1) {
					//if no arguments
					sender.sendMessage(ChatColor.GREEN + "TurtleJoin Version " + pdf.getVersion());
					return true;
				}
				if (args[0].equalsIgnoreCase("version")) {
					//if first argument = version
					sender.sendMessage(ChatColor.GREEN + "TurtleJoin Version " + pdf.getVersion());
					return true;
				}
				if (args[0].equalsIgnoreCase("reload")) {
					//if first argument = reload
					//create instance of turtlejoin config class and load config variabled from config.yml
					Config c = new Config(this);
					c.reload();
					sender.sendMessage(ChatColor.GREEN + "TurtleJoin Config Reloaded");
					return true;
				}
				if (args.length > 1) {
					//if more than 1 argument
					sender.sendMessage(ChatColor.RED + "Too many arguments!");
					return false;
				}
			}	
		}
		return false;
	}
}
