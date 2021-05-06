package com.sg.tennis.helper;

import com.sg.tennis.entities.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TennisGameHelperTest {
    Player player1;
    Player player2;
    @Before
    public void beforeGameTest() {
        player1 = new Player("player1");
        player2 = new Player("player2");
    }
private final TennisGameHelper tennisGameHelper = new TennisGameHelper();
    @Test
    public void should_return_no_winner_when_both_player_has_score_zero() {
      String s =  tennisGameHelper.winnerPlayer(player1, player2);
        assertEquals(s,"No Winner");
    }

    @Test
    public void should_return_player_name_when_player_has_score_three() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player1.winBall());
        String s =  tennisGameHelper.winnerPlayer(player1, player2);
        assertEquals(s,"player1");
    }

    @Test
    public void should_no_winner_when_no_player_has_reach_score_three() {
        IntStream.rangeClosed(1, 2).forEach((Integer) -> player1.winBall());
        IntStream.rangeClosed(1, 1).forEach((Integer) -> player2.winBall());
        String s =  tennisGameHelper.winnerPlayer(player1, player2);
        assertEquals(s,"No Winner");
    }






}