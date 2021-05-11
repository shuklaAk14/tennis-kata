package com.sg.tennis.util;

import com.sg.tennis.entities.Player;
import com.sg.tennis.enums.ScoreEnum;
import com.sg.tennis.provider.WinnerAndDeuceRule;
import com.sg.tennis.provider.WinnerRule;

public class GameUtil {

    public static String getWinnerMsgOrName(Player p1, Player p2, int maxWiningPoint) {
        return p1.getScore() >= maxWiningPoint && p2.getScore() >= maxWiningPoint ?
                new WinnerAndDeuceRule().checkForRule(p1, p2, maxWiningPoint) :
                new WinnerRule().checkForRule(p1, p2, maxWiningPoint);
    }

    public static Player getLeadPlayer(Player player1, Player player2) {
        return player1.getScore() > player2.getScore() ? player1 : player2;
    }

    public static String getLeadPlayerName(Player player1, Player player2) {
        return getLeadPlayer(player1, player2).getName();
    }

    public static String buildWinnerMessage(Player p1, Player p2, String winnerPlayer) {
        return p1.getName().equals(winnerPlayer) ?
                p1.getName() + " won with " + displayScore(p1.getScore()) + " points" :
                p2.getName() + " won with " + displayScore(p2.getScore()) + " points";
    }

    public static String buildGameResult(Player p1, Player p2, String winnerMsgOrName) {
        return p1.getName().equals(winnerMsgOrName) || p2.getName().equals(winnerMsgOrName) ?
                buildWinnerMessage(p1, p2, winnerMsgOrName) :
                winnerMsgOrName;
    }

    public static Integer displayScore(Integer score) {
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
