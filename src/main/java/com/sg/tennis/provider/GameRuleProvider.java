package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;

@FunctionalInterface
public interface GameRuleProvider {
    String checkForRule(Player p1, Player p2, int maxWiningPoint);
}