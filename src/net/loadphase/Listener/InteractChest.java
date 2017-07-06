package net.loadphase.Listener;

import net.loadphase.Main.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.ArrayList;

/**
 * Created by loadp on 06.07.2017.
 */
public class InteractChest implements Listener {
    public static ArrayList<Material> list = new ArrayList<>();
    @EventHandler
    public void onInterct(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getClickedBlock() != null) {
            if (e.getClickedBlock().getType() == Material.CHEST) {
                Main.getPlugin().getLotteryManager().method(p);
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory() != null) {
            if (e.getInventory().getName().contains("Lotterie")) {
                if (Main.main.containsKey(p)) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
