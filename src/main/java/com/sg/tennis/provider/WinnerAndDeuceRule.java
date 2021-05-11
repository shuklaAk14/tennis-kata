package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;

import static com.sg.tennis.util.GameUtil.getLeadPlayerName;
import static java.lang.Math.abs;

public class WinnerAndDeuceRule implements IGameRuleProvider {

    @Override
    public String checkForRule(Player p1, Player p2, int maxWiningPoint) {
        return abs(p1.getScore() - p2.getScore()) >= 2 ?
                getLeadPlayerName(p1, p2) :
                new DeuceAndAdvantageRule().checkForRule(p1, p2, maxWiningPoint);
    }
}
