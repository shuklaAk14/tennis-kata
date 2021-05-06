package com.sg.tennis.helper;

import com.sg.tennis.entities.Player;

import static java.lang.Math.abs;

public class TennisGameHelper {


    public String winnerPlayer(Player p1, Player p2, int maxWiningPoint) {
        Player leadPlayer = getLeadPlayer(p1, p2);
        return p1.getScore() >= maxWiningPoint && p2.getScore() >= maxWiningPoint ?
                checkForDeuceOrAdvantageOrWinner(p1, p2, leadPlayer) :
                checkForWinner(leadPlayer, maxWiningPoint);
    }

    private String checkForWinner(Player leadPlayer, int maxWiningPoint) {
        return leadPlayer.getScore() >= maxWiningPoint ? leadPlayer.getName() : "No Winner";
    }

    private String checkForDeuceOrAdvantageOrWinner(Player p1, Player p2, Player leadPlayer) {
        return abs(p1.getScore() - p2.getScore()) >= 2 ? leadPlayer.getName() : checkForDeuceOrAdvantage(p1, p2);
    }

    private String checkForDeuceOrAdvantage(Player p1, Player p2) {
        return p1.getScore() == p2.getScore() ? "DEUCE" : "ADVANTAGE";
    }

    public Player getLeadPlayer(Player player1, Player player2) {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }

}
