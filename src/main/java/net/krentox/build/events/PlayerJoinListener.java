package net.krentox.build.events;

import net.krentox.build.management.item.GameItem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        //set items into inventory
        GameItem.updateInventory(player);

        //cancel event message
        event.setJoinMessage(null);

    }

}
