package com.sg.tennis.provider;

import com.sg.tennis.entities.Player;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class WinnerAndDeuceRuleTest {

    private final Player player1  = new Player("player1");
    private final Player player2 = new Player("player2");
    private final IGameRuleProvider winnerAndDeuceProvider = new WinnerAndDeuceRule();

    @Test
    public void should_return_player_name_when_player_has_AtLeastFourPoints_InTotal_And_AtLeastTwoPoints_More_Than_With_other_player () {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player1.winBall());
        IntStream.rangeClosed(1, 5).forEach((Integer) -> player2.winBall());
        String actual =  winnerAndDeuceProvider.checkForRule(player1, player2,3);
        assertEquals(actual,"player2");
    }
    @Test
    public void should_return_DEUCE_when_both_player_has_MaxWiningPint () {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player2.winBall());
        String actual = winnerAndDeuceProvider.checkForRule(player1, player2,3);
        assertEquals(actual,"DEUCE");
    }

    @Test
    public void should_return_ADVANTAGE_when_any_player_has_score_more_then_MaxWiningPint () {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 4).forEach((Integer) ->  player2.winBall());
        String actual = winnerAndDeuceProvider.checkForRule(player1, player2,3);
        assertEquals(actual,"ADVANTAGE");
    }

}