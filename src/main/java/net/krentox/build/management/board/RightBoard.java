package net.krentox.build.management.board;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class RightBoard extends Board {

    /**
     * Create board class
     *
     * @param player target
     */
    public RightBoard(Player player) {
        super(player);
    }

    @Override
    public Scoreboard registerBoard() {

        Objective objective = this.getObjective();

        //set scoreboard settings
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName("§f§lKRENTOX§7§l.§f§lNET");

        objective.getScore("  ").setScore(7);
        objective.getScore("§fKarte:").setScore(6);
        objective.getScore("§2").setScore(5);
        objective.getScore(" ").setScore(4);
        objective.getScore("§fSpieler:").setScore(3);
        objective.getScore("§1").setScore(2);
        objective.getScore("").setScore(1);

        return this.scoreboard;
    }

    @Override
    public void updateBoard() {
        this.registerTeam("world_team", "§a" + player.getWorld().getName(), "", "§2");
        this.registerTeam("player_team", "§e" + Bukkit.getOnlinePlayers().size(), "", "§1");
    }

    @Override
    public Objective getObjective() {
        return this.scoreboard.getObjective("aaa") == null ? this.scoreboard.registerNewObjective("aaa", "bbb") : this.scoreboard.getObjective("aaa");
    }
}
