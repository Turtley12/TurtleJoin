package io.github.turtley12.TurtleJoin;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    Main plugin;
    public Config (Main instance) {
    	//makes instance of main class to use getConfig() in different class than main
        plugin = instance;
    }
    
    //define variable before setting them from config
    public static String world;
    public static double x;
    public static double y;
    public static double z;
    public static float yaw;
    public static float pitch;
    public static long delay;
    
	public void load() {
		//save default config from jar file if it doesn't exist already
		plugin.saveDefaultConfig();
		//load config values into variables defined earlier
		FileConfiguration config = plugin.getConfig();
		world = config.getString("teleport.world");
		x = config.getInt("teleport.x");
		y = config.getInt("teleport.y");
		z = config.getInt("teleport.z");
		yaw = config.getInt("teleport.yaw");
		pitch = config.getInt("teleport.pitch");
		delay = config.getInt("teleport_delay");
	}
	public void reload() {
		//call bukkits reloadConfig() and call load config method above
		plugin.reloadConfig();
		this.load();
	}
	//Get functions that return the variables defined and set above
	public static String getWorld() {
		return world;
	}
	
	public static double getX() {
		return x;
	}
	public static double getY() {
		return y;
	}
	public static double getZ() {
		return z;
	}
	public static float getYaw() {
		return yaw;
	}
	public static float getPitch() {
		return pitch;
	}
	public static long getDelay() {
		return delay;
	}
	
}