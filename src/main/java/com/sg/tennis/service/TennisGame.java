package com.sg.tennis.service;

import com.sg.tennis.entities.Player;
import com.sg.tennis.enums.ScoreEnum;
import com.sg.tennis.helper.TennisGameHelper;

public class TennisGame implements GameStrategy {

    @Override
    public String startGame(Player p1, Player p2, int maxWiningPoint) {
        if (p1.getScore() == 0 && p2.getScore() == 0) {
            return "Game not Started";
        }
        TennisGameHelper tennisGameHelper = new TennisGameHelper();
        String winnerMsgOrName = tennisGameHelper.winnerPlayer(p1, p2, maxWiningPoint);
        return p1.getName().equals(winnerMsgOrName) || p2.getName().equals(winnerMsgOrName) ?
                buildWinnerMessage(p1, p2, winnerMsgOrName) :
                winnerMsgOrName;
    }

    private String buildWinnerMessage(Player p1, Player p2, String winnerPlayer) {
        return p1.getName().equals(winnerPlayer) ?
                p1.getName() + " won with " + displayScore(p1.getScore()) + " points" :
                p2.getName() + " won with " + displayScore(p2.getScore()) + " points";
    }

    public Integer displayScore(Integer score) {
        switch (score) {
            case 1:
                return ScoreEnum.UN.getValue();
            case 2:
                return ScoreEnum.DEUX.getValue();
            case 3:
                return ScoreEnum.TROIS.getValue();
            default:
                return score;
        }
    }
}
