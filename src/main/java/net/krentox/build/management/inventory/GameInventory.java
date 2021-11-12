package net.krentox.build.management.inventory;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class GameInventory {

    /**
     * create collection list for inventory
     */
    public final static Collection<GameInventory> INVENTORY_LIST = new ArrayList<>() {{
        this.add(new NavigationInventory());
    }};

    /**
     * register inventory for create or update
     */
    public abstract void registerInventory();

    /**
     * Inventory click handling
     *
     * @param event target event
     */
    public abstract void onInventoryClick(InventoryClickEvent event);

    /**
     * Get Inventory
     *
     * @return target inventory
     */
    public abstract Inventory getInventory();

    /**
     * Get title for inventory
     *
     * @return target title
     */
    public abstract String getTitle();

    /**
     * Get slots for inventory
     *
     * @return target slots
     */
    public abstract int getSlots();

    /**
     * Open Inventory for player
     *
     * @param player target player
     */
    public void openInventory(Player player) {
       player.openInventory(this.getInventory());
    }

    /**
     * Gets an inventory by the class
     *
     * @param inventoryClass the inventory-class
     * @return the inventory or <code>null</code> if there is no item according to this class
     */
    public static GameInventory getInventoryByClass(Class<? extends GameInventory> inventoryClass) {
        return INVENTORY_LIST.stream().filter(inventory -> inventory.getClass().isAssignableFrom(inventoryClass)).findFirst().orElse(null);
    }

}
