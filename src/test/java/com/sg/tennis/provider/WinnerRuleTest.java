package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class WinnerRuleTest {

    private final Player player1  = new Player("player1");
    private final Player player2 = new Player("player2");
    private final IGameRuleProvider winnerProvider = new WinnerRule();

    @Test
    public void should_return_no_winner_when_both_player_has_score_zero() {
        String actual = winnerProvider.checkForRule(player1, player2, 3);
        assertEquals(actual, "No Winner");
    }

    @Test
    public void should_return_player_name_when_player_has_score_three() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player1.winBall());
        String actual =  winnerProvider.checkForRule(player1, player2,3);
        assertEquals(actual,"player1");
    }

}