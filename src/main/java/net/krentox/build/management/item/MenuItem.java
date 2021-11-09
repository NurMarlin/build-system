package net.krentox.build.management.item;

import net.krentox.build.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerInteractEvent;

public class MenuItem extends GameItem {

    @Override
    public ItemStack getItemStack() {
        return new ItemBuilder(Material.COMPASS).setName("§6§lNavigation").setLore("§1a","§2b","§3c").toItemStack();
    }

    @Override
    public int getSlot(Player player) {
        return player.getWorld().getName().equals("world") ? 4 : 22;
    }

    @Override
    public void onInteract(PlayerInteractEvent event) {
        Bukkit.broadcastMessage("TEST");
    }
}
