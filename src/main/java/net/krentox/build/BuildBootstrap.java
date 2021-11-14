package net.krentox.build;

import lombok.Getter;
import net.krentox.build.events.PlayerInventoryClickListener;
import net.krentox.build.events.WorldChangeListener;
import net.krentox.build.management.inventory.GameInventory;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import net.krentox.build.events.PlayerJoinListener;
import net.krentox.build.events.PlayerInteractListener;

public class BuildBootstrap extends JavaPlugin implements IPluginRegister {

    /**
     * create main instance
     */
    @Getter
    private static BuildBootstrap instance;

    @Override
    public void onLoad() {

        //set main instance
        instance = this;

        //loading classes
        this.registerClasses();
    }

    @Override
    public void onEnable() {

        //register inventories
        GameInventory.INVENTORY_LIST.forEach(GameInventory::registerInventory);

        //register events
        this.registerEvents();

    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void registerCommands() {

    }

    @Override
    public void registerEvents() {

        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new WorldChangeListener(), this);
        pluginManager.registerEvents(new PlayerInteractListener(), this);
        pluginManager.registerEvents(new PlayerInventoryClickListener(), this);
    }

    @Override
    public void registerClasses() {

    }

}
