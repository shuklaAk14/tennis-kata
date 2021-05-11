package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;

public class DeuceAndAdvantageProvider implements GameRuleProvider {

    @Override
    public String checkForRule(Player p1, Player p2, int maxWiningPoint) {
        return p1.getScore() == p2.getScore() ? "DEUCE" : "ADVANTAGE";
    }
}
