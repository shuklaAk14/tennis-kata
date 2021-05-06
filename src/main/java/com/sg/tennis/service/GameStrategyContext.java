package com.sg.tennis.service;

import com.sg.tennis.entities.Player;

public class GameStrategyContext {

    private final GameStrategy strategy;

    public GameStrategyContext(GameStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeStrategy(Player p1, Player p2, int maxWiningPoint) {
        return strategy.startGame(p1, p2, maxWiningPoint);
    }
}
