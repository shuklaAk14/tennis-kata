package com.sg.tennis.service;

import com.sg.tennis.entities.Player;

@FunctionalInterface
public interface IGameStrategy {
    String startGame(Player p1, Player p2, int maxWiningPoint);
}