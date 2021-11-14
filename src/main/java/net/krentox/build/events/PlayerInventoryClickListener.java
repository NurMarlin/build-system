package net.krentox.build.events;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import net.krentox.build.management.inventory.GameInventory;

public class PlayerInventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        //check if item or inventory is null
        if (event.getCurrentItem() == null || event.getClickedInventory() == null) {
            return;
        }

        //call click event from game inventory class
        GameInventory.INVENTORY_LIST.forEach(gameInventory -> {

            //check if game inventory is event inventory
            if (!event.getClickedInventory().equals(gameInventory.getInventory())) {
                return;
            }

            //call inventory click event
            gameInventory.onInventoryClick(event);
        });
    }

}
