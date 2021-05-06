package com.sg.tennis.service;

import com.sg.tennis.entities.Player;
import com.sg.tennis.helper.TennisGameHelper;

import static java.lang.Math.abs;

public class TennisSetStrategy implements GameStrategy{
    @Override
    public String startGame(Player p1, Player p2, int maxWiningPoint) {

        TennisGameHelper tennisGameHelper=new TennisGameHelper();
        Player leadPlayer = tennisGameHelper.getLeadPlayer(p1, p2);
        if(leadPlayer.getScore()>=maxWiningPoint && abs(p1.getScore() - p2.getScore()) < 2){
            return "No Winner";
        }
        String winnerMsgOrName = tennisGameHelper.winnerPlayer(p1, p2, maxWiningPoint);
        return p1.getName().equals(winnerMsgOrName) || p2.getName().equals(winnerMsgOrName) ?
                buildWinnerMessage(p1, p2, winnerMsgOrName) :
                winnerMsgOrName;
    }

    private String buildWinnerMessage(Player p1, Player p2, String winnerPlayer) {
        return p1.getName().equals(winnerPlayer) ?
                p1.getName() + " won with " + p1.getScore() + " points" :
                p2.getName() + " won with " + p2.getScore() + " points";
    }
}
