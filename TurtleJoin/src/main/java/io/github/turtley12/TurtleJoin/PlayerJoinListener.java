package io.github.turtley12.TurtleJoin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public final class PlayerJoinListener implements Listener  {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		//code runs on player join
		Bukkit.getLogger().info("TurtleJoin detected player join");
		//get player as an offline player
		OfflinePlayer player = event.getPlayer();
		Bukkit.getLogger().info("TurtleJoin about to teleport player");
		//get time and add delay from config in milliseconds to getLastSeen()
		long time = System.currentTimeMillis();
		long delay = Config.getDelay() * 1000;
		@SuppressWarnings("deprecation")
		long last_played = player.getLastPlayed() + delay;
		final Location teleport_location = new Location(Bukkit.getWorld(Config.getWorld()), Config.getX(), Config.getY(), Config.getZ(), Config.getYaw(), Config.getPitch());
		//if the current time is greater, (later) than the lastplayed plus set delay,
		//teleport the player.
		if (time > last_played) {
			Player online_player = event.getPlayer();
			Bukkit.getLogger().info("TurtleJoin Reached Telelport Code!");
			online_player.teleport(teleport_location);
			Bukkit.getLogger().info("Turtlejoin Thinks it has teleported player");
		}
			
	}
}
