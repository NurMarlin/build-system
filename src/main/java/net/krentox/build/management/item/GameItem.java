package net.krentox.build.management.item;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public abstract class GameItem {

    /**
     * create list for game items
     */
    public static final Collection<GameItem> ITEM_LIST = new ArrayList<>(){{
        this.add(new NavigationItem());
    }};

    /**
     * The item's material
     *
     * @return the material
     */
    public abstract ItemStack getItemStack();

    /**
     * The item's slot
     *
     * @param player the player the item should be given to
     * @return the slot
     */
    public abstract int getSlot(Player player);

    /**
     * Management from interact
     *
     * @param event target event
     */
    public abstract void onInteract(PlayerInteractEvent event);

    /**
     * Set Item into inventory from player
     *
     * @param player target player
     */
    public void setItem(Player player) {
        player.getInventory().setItem(this.getSlot(player), this.getItemStack());
    }

    /**
     * Set all items from item list
     *
     * @param player target player
     */
    public static void updateInventory(Player player) {
        ITEM_LIST.forEach(gameItem -> gameItem.setItem(player));
    }

    /**
     * Check if item is a game item
     *
     * @param itemStack target itemStack
     * @return true or false
     */
    public static boolean isGameItem(ItemStack itemStack) {
        return ITEM_LIST.stream().anyMatch(item -> item.getItemStack().equals(itemStack));
    }

    /**
     * Gets an item by the class
     *
     * @param itemClass the item-class
     * @return the item or <code>null</code> if there is no item according to this class
     */
    public static GameItem getItemByClass(Class<? extends GameItem> itemClass) {
        return ITEM_LIST.stream().filter(item -> item.getClass().isAssignableFrom(itemClass)).findFirst().orElse(null);
    }

}
