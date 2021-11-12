package net.krentox.build.management.board;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public abstract class Board {

    /**
     *
     */
    public final Player player;

    /**
     *
     * @param player
     */
    public Board(Player player) {
        this.player = player;
    }

    /**
     *
     */
    public abstract Scoreboard createBoard();

    /**
     *
     */
    public abstract void updateBoard();

    public Team createTeam(Scoreboard scoreboard, String id, String prefix, String entry, String suffix) {
        Team team = this.getTeam(scoreboard, id);
        team.setPrefix(prefix);
        team.addEntry(entry);
        team.setSuffix(suffix);
        return team;
    }

    /**
     * Get Team from scoreboard
     *
     * @param scoreboard target board
     * @param id         target id
     * @return team class from scoreboard
     */
    public Team getTeam(Scoreboard scoreboard, String id) {
        return scoreboard.getTeam(id) == null ? scoreboard.getTeam(id) : scoreboard.registerNewTeam(id);
    }

    /**
     * Get Scoreboard from player
     *
     * @return a scoreboard
     */
    public Scoreboard getScoreboard() {
        return this.player.getScoreboard().getObjective("aaa") == null ? Bukkit.getScoreboardManager().getNewScoreboard() : player.getScoreboard();
    }

}
