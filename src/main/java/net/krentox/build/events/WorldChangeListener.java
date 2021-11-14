package net.krentox.build.events;

import net.krentox.build.management.client.GamePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChangeListener implements Listener {

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {

        //update scoreboard
        GamePlayer.getInstance(event.getPlayer()).getRightBoard().updateBoard();
    }

}
