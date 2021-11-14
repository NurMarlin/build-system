package net.krentox.build.management.inventory;

import net.krentox.build.utils.ItemBuilder;
import net.krentox.build.utils.Skull;
import net.krentox.build.utils.SkullBuilder;
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

        this.fillInventory(9,18, new ItemBuilder(Material.IRON_BARS).toItemStack());
        this.fillInventory(0,9, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).toItemStack());
        this.fillInventory(18,27, new ItemBuilder(Material.WHITE_STAINED_GLASS_PANE).toItemStack());

        this.inventory.setItem(11, new ItemBuilder(Material.CHEST).setName("§bTeam Welten").setLore("§7Hier kannst du alle", "§7Team Welten sehen").toItemStack());
        this.inventory.setItem(13, new ItemBuilder(Material.REDSTONE).setName("§cEinstellungen").setLore("§7Verwalte deine oder die Team Einstellungen").toItemStack());
        this.inventory.setItem(15, new SkullBuilder(Skull.WORLD_SKULL).getSkull("§eDeine Welten", "§7Hier kannst du deine", "§7eigenen Welten sehen").toItemStack());
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
        return "§8Navigation";
    }

    @Override
    public int getSlots() {
        return 27;
    }

}
