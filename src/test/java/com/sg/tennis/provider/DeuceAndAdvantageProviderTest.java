package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class DeuceAndAdvantageProviderTest{

    private final Player player1  = new Player("player1");
    private final Player player2 = new Player("player2");
    private final GameRuleProvider deuceAndAdvantageProvider = new DeuceAndAdvantageProvider();

    @Test
    public void should_return_DEUCE_when_both_player_has_score_three () {
        String actual =  deuceAndAdvantageProvider.checkForRule(player1, player2,3);
        assertEquals(actual,"DEUCE");
    }

    @Test
    public void should_return_ADVANTAGE_when_any_player_has_score_more_then_three () {
        player1.winBall();
        String actual =  deuceAndAdvantageProvider.checkForRule(player1, player2,3);
        assertEquals(actual,"ADVANTAGE");
    }

}