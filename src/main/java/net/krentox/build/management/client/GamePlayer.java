package net.krentox.build.management.client;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import org.bukkit.entity.Player;
import lombok.RequiredArgsConstructor;
import net.krentox.build.management.board.RightBoard;

@Getter
@RequiredArgsConstructor
public class GamePlayer {

    /**
     * create player list collection instance
     */
    private final static Collection<GamePlayer> PLAYER_LIST = new ArrayList<>();

    /**
     * create bukkit player instance
     */
    public final Player bukkitPlayer;

    /**
     * create right board instance
     */
    private final RightBoard rightBoard;

    /**
     * Create game player class
     *
     * @param bukkitPlayer target player
     */
    public GamePlayer(Player bukkitPlayer) {
        this.bukkitPlayer = bukkitPlayer;
        this.rightBoard = new RightBoard(bukkitPlayer);

        //put player into cache
        PLAYER_LIST.add(this);
    }

    /**
     * Get game player instance from player
     *
     * @param player target player
     * @return game player class
     */
    public static GamePlayer getInstance(Player player) {
        return PLAYER_LIST.stream().filter(gamePlayer -> gamePlayer.bukkitPlayer.equals(player)).findFirst().get();
    }

}
