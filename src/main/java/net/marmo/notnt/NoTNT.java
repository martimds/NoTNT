package net.marmo.notnt;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoTNT extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("TNTs disabled in overworld dimension");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onTNTExplosion (TNTPrimeEvent e){
        if (e.getBlock().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
            e.setCancelled(true);
        }
    }
}
