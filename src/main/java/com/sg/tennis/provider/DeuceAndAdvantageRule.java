package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;

public class DeuceAndAdvantageRule implements IGameRuleProvider {

    @Override
    public String checkForRule(Player p1, Player p2, int maxWiningPoint) {
        return p1.getScore() == p2.getScore() ? "DEUCE" : "ADVANTAGE";
    }
}
