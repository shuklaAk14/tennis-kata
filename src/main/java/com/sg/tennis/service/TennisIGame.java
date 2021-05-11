package com.sg.tennis.service;

import com.sg.tennis.entities.Player;

import static com.sg.tennis.util.GameUtil.buildGameResult;
import static com.sg.tennis.util.GameUtil.getWinnerMsgOrName;

public class TennisIGame implements IGameStrategy {

    @Override
    public String startGame(Player p1, Player p2, int maxWiningPoint) {
        if (p1.getScore() == 0 && p2.getScore() == 0) {
            return "Game not Started";
        }
        String winnerMsgOrName = getWinnerMsgOrName(p1, p2, maxWiningPoint);
        return buildGameResult(p1, p2, winnerMsgOrName);
    }
}
