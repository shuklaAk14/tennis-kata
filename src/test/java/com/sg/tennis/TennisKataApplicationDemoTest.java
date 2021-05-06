package com.sg.tennis;

import com.sg.tennis.entities.Player;
import com.sg.tennis.service.TennisGame;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TennisKataApplicationDemoTest{

    private Player player1;
    private Player player2;
    @Before
    public void beforeGameTest() {
        player1 = new Player("player1");
        player2 = new Player("player2");
    }

    private final TennisGame tennisGame = new TennisGame();
    @Test
    public void should_return_GAME_NOT_STARTED_message_when_both_player_has_score_zero() {
        String s = tennisGame.startGame(player1, player2);
        assertEquals(s,"Game not Started");
    }

    @Test
    public void should_return_player_name_and_score_when_player_has_score_three() {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        String s = tennisGame.startGame(player1, player2);
        assertEquals(s,"player1 won with 40 points");
    }

    @Test
    public void should_return_no_winner_when_no_player_has_score_three() {
        IntStream.rangeClosed(1, 2).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 1).forEach((Integer) -> player2.winBall());
        String s = tennisGame.startGame(player1, player2);
        assertEquals(s,"No Winner");
    }
    @Test
    public void should_return_deuce_when_both_player_has_score_three () {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player2.winBall());
        String s = tennisGame.startGame(player1, player2);
        assertEquals(s,"DEUCE");
    }

    @Test
    public void should_return_ADVANTAGE_when_any_player_has_score_more_then_three () {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 4).forEach((Integer) ->  player2.winBall());
        String s = tennisGame.startGame(player1, player2);
        assertEquals(s,"ADVANTAGE");
    }

    @Test
    public void should_return_player_name_and_score_when_player_has_AtLeastFourPoints_InTotal_And_AtLeastTwoPoints_More_Than_With_other_player () {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player1.winBall());
        IntStream.rangeClosed(1, 5).forEach((Integer) -> player2.winBall());
        String s = tennisGame.startGame(player1, player2);
        assertEquals(s,"player2 won with 5 points");
    }

}