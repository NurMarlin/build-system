package net.krentox.build.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum MessageType {

    ERROR("§7[§cError§7] "), INFO("§7[§eKrentox§7] "), DEBUG (  "§7[§b§lDEBUG§7] ");

    /**
     *
     */
    private final String prefix;

    /**
     * Create MessageType class
     *
     * @param prefix target prefix
     */
    MessageType(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Send a Console Message
     *
     * @param type target type
     * @param message target message
     */
    public static void sendConsoleMessage(MessageType type, String message) {
        Bukkit.broadcastMessage(type.prefix + message);
    }

    /**
     * Send a Player Message
     *
     * @param type target type
     * @param player target player
     * @param message target message
     */
    public static void sendMessage(MessageType type, Player player, String message) {
        player.sendMessage(type.prefix + message);
    }

}
