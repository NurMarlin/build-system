package net.krentox.build;

public interface IPluginRegister {

    /**
     * register all bukkit commands
     */
    void registerCommands();

    /**
     * register all events
     */
    void registerEvents();

    /**
     * register all classes for plugin
     */
    void registerClasses();

}
