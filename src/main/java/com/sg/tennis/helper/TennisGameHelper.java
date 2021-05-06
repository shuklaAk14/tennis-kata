package com.sg.tennis.helper;

import com.sg.tennis.entities.Player;

import static java.lang.Math.abs;

public class TennisGameHelper {


    public String winnerPlayer(Player p1, Player p2) {
        Player leadPlayer = getLeadPlayer(p1, p2);
        return checkForWinner(leadPlayer);
    }

    private String checkForWinner(Player leadPlayer) {
        return leadPlayer.getScore() >= 3 ? leadPlayer.getName() : "No Winner";
    }


    private Player getLeadPlayer(Player player1, Player player2) {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }

}
