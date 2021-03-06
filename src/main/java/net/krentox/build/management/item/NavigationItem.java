package net.krentox.build.management.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.krentox.build.utils.ItemBuilder;
import org.bukkit.event.player.PlayerInteractEvent;
import net.krentox.build.management.inventory.GameInventory;
import net.krentox.build.management.inventory.NavigationInventory;

public class NavigationItem extends GameItem {

    @Override
    public ItemStack getItemStack() {
        return new ItemBuilder(Material.COMPASS).setName("§6§lNavigation").setLore("§1a", "§2b", "§3c").toItemStack();
    }

    @Override
    public int getSlot(Player player) {
        return player.getWorld().getName().equals("world") ? 4 : 22;
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {
        GameInventory.getInventoryByClass(NavigationInventory.class).openInventory(event.getPlayer());
    }
}
