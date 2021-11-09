package net.krentox.build;

import com.google.common.reflect.ClassPath;
import lombok.Getter;
import net.krentox.build.events.PlayerInteractListener;
import net.krentox.build.events.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

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
        pluginManager.registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void registerClasses() {

    }
}
