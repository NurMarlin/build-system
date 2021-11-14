package net.krentox.build.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import net.krentox.build.management.item.GameItem;
import net.krentox.build.management.client.GamePlayer;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        GamePlayer gamePlayer = new GamePlayer(player);

        //create right board
        player.setScoreboard(gamePlayer.getRightBoard().registerBoard());

        //set items into inventory
        GameItem.updateInventory(player);

        //cancel event message
        event.setJoinMessage(null);
    }

}
