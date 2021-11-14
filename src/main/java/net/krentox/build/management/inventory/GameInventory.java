package net.krentox.build.management.inventory;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

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
     * Fill inventory with item stack
     *
     * @param start target start
     * @param stop target stop
     * @param itemStack target item stack
     */
    public void fillInventory(int start, int stop, ItemStack itemStack) {

        for (int i = start; i < stop; i++) {
            this.getInventory().setItem(i, itemStack);
        }

    }

    /**
     * Open Inventory for player
     *
     * @param player target player
     */
    public void openInventory(Player player) {
        player.openInventory(this.getInventory());
    }

    /**
     * Check if inventory is a game inventory
     *
     * @param inventory target inventory
     * @return true or false
     */
    public static boolean isGameInventory(Inventory inventory) {
        return INVENTORY_LIST.stream().anyMatch(gameInventory -> gameInventory.getInventory().equals(inventory));
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
