package com.sg.tennis.service;

import com.sg.tennis.entities.Player;

import static com.sg.tennis.util.GameUtil.*;
import static java.lang.Math.abs;

public class TennisSetStrategy implements GameStrategy {
    @Override
    public String startGame(Player p1, Player p2, int maxWiningPoint) {
        Player leadPlayer = getLeadPlayer(p1, p2);
        if (leadPlayer.getScore() >= maxWiningPoint && abs(p1.getScore() - p2.getScore()) < 2) {
            return "No Winner";
        }
        String winnerMsgOrName = getWinnerMsgOrName(p1, p2, maxWiningPoint);
        return buildGameResult(p1, p2, winnerMsgOrName);
    }
}
