package net.krentox.build.management.board;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Board {

    /**
     * create display name instance
     */
    public final static String DISPLAY_NAME = "§eKrentoxNET";

    /**
     * create collection instance
     */
    public Collection<BoardScore> scores = new ArrayList<>();

    /**
     * create player instance
     */
    public final Player player;

    /**
     * create scoreboard instance
     */
    public final Scoreboard scoreboard;

    /**
     * Create board class
     *
     * @param player target
     */
    public Board(Player player) {
        this.player = player;
        this.scoreboard = this.getScoreboard();

        //register teams for scoreboard
        this.updateBoard();
    }

    /**
     * Create scoreboard team
     *
     * @param id     target id
     * @param prefix target prefix
     * @param suffix target suffix
     * @param entry  target entry
     */
    public void registerTeam(String id, String prefix, String suffix, String entry) {
        Team team = this.getTeam(id) == null ? this.scoreboard.registerNewTeam(id) : this.getTeam(id);

        //set team settings
        team.setPrefix(prefix);
        team.setSuffix(suffix);
        team.addEntry(entry);
    }

    /**
     * Get team from scoreboard
     *
     * @param id target id
     * @return Team class from scoreboard
     */
    public Team getTeam(String id) {
        return this.scoreboard.getTeam(id);
    }

    /**
     * Get scoreboard from player
     *
     * @return scoreboard class
     */
    public Scoreboard getScoreboard() {
        return Bukkit.getScoreboardManager().getMainScoreboard() == player.getScoreboard() ? Bukkit.getScoreboardManager().getNewScoreboard() : player.getScoreboard();
    }

    /**
     * create and update board
     */
    public abstract void updateBoard();

    /**
     * Register scoreboard
     *
     * @return scoreboard class
     */
    public abstract Scoreboard registerBoard();

    /**
     * Get scoreboard
     *
     * @return player scoreboard class
     */
    //  public abstract Scoreboard getScoreboard();

    /**
     * Get objective from scoreboard
     *
     * @return objective class
     */
    public abstract Objective getObjective();

}
