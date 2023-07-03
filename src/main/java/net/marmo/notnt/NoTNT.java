package net.marmo.notnt;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.TNTPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class NoTNT extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onTNTPrime (TNTPrimeEvent e){
        if (e.getBlock().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCrystalPlace (PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.END_CRYSTAL) && event.getPlayer().getWorld().getEnvironment().equals(World.Environment.NORMAL)){
                if (Objects.requireNonNull(event.getClickedBlock()).getType() == Material.OBSIDIAN || event.getClickedBlock().getType() == Material.BEDROCK) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
