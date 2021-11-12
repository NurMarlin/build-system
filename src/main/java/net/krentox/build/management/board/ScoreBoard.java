package net.krentox.build.management.board;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoard extends Board {

    /**
     * @param player
     */
    public ScoreBoard(Player player) {
        super(player);
    }

    @Override
    public Scoreboard createBoard() {

        Scoreboard scoreboard = this.getScoreboard();
        Objective objective = scoreboard.registerNewObjective("aaa","bbb");

        objective.setDisplayName("Build-server");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        objective.getScore("").setScore(1);

        return scoreboard;
    }

    @Override
    public void updateBoard() {

    }
}
