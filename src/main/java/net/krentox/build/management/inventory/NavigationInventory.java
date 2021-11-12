package net.krentox.build.management.inventory;

import net.krentox.build.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class NavigationInventory extends GameInventory {

    /**
     * create inventory instance
     */
    private final Inventory inventory = this.getInventory();

    @Override
    public void registerInventory() {
        this.inventory.setItem(12, new ItemBuilder(Material.CHEST).setName("§bTeam-Projekte").setLore("§7Hier siehst du alle Maps vom Team").toItemStack());
        this.inventory.setItem(14, new ItemBuilder(Material.CHEST).setName("§bMeine-Projekte").setLore("§7Hier siehst du alle Maps vom dir").toItemStack());
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        Bukkit.broadcastMessage("TEST2");
    }

    @Override
    public Inventory getInventory() {
        return this.inventory != null ? inventory : Bukkit.createInventory(null, this.getSlots(), this.getTitle());
    }

    @Override
    public String getTitle() {
        return "§6Navigation";
    }

    @Override
    public int getSlots() {
        return 27;
    }

}
