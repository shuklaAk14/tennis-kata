package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;

import static com.sg.tennis.util.GameUtil.getLeadPlayer;

public class WinnerRule implements IGameRuleProvider {
    @Override
    public String checkForRule(Player p1, Player p2, int maxWiningPoint) {
        Player leadPlayer = getLeadPlayer(p1, p2);
        return leadPlayer.getScore() >= maxWiningPoint ? leadPlayer.getName() : "No Winner";
    }
}
