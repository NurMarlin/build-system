package net.krentox.build.events;

import net.krentox.build.management.item.GameItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        //check if item not exits
        if (event.getItem() == null) {
            return;
        }

        //check if clicked with a right click on this item
        if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        GameItem.ITEM_LIST.forEach(gameItem -> {

            //check if game item is event item
            if (!event.getItem().equals(gameItem.getItemStack())) {
                return;
            }

            //call interact event
            gameItem.onInteract(event);
        });
    }

}
