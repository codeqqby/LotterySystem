package net.loadphase.Listener;

import net.loadphase.Main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Created by loadp on 06.07.2017.
 */
public class CloseChest implements Listener {
    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if(e.equals("Lotterie")) {
            Main.main.remove(e.getPlayer());
        }
    }
}
