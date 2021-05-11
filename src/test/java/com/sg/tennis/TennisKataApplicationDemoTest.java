package com.sg.tennis;

import com.sg.tennis.entities.Player;
import com.sg.tennis.service.GameStrategyContext;
import com.sg.tennis.service.TennisIGame;
import com.sg.tennis.service.TennisSetStrategy;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class TennisKataApplicationDemoTest{

    private Player player1 =new Player("player1");
    private Player player2 = new Player("player2");
    private final GameStrategyContext tennisGameContext = new GameStrategyContext(new TennisIGame());
    private final GameStrategyContext tennisSetContext = new GameStrategyContext(new TennisSetStrategy());

    @Test
    public void should_return_GAME_NOT_STARTED_message_when_both_player_not_started_and_has_score_zero() {
        String s = tennisGameContext.executeStrategy(player1, player2,3);
        assertEquals(s,"Game not Started");
    }

    @Test
    public void should_return_player_name_and_score_when_player_has_score_MaxWiningPint() {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        String s = tennisGameContext.executeStrategy(player1, player2,3);
        assertEquals(s,"player1 won with 40 points");
    }

    @Test
    public void should_return_no_winner_when_no_player_has_MaxWiningPint() {
        IntStream.rangeClosed(1, 2).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 1).forEach((Integer) -> player2.winBall());
        String s = tennisGameContext.executeStrategy(player1, player2,3);
        assertEquals(s,"No Winner");
    }
    @Test
    public void should_return_deuce_when_both_player_has_MaxWiningPint () {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player2.winBall());
        String s = tennisGameContext.executeStrategy(player1, player2,3);
        assertEquals(s,"DEUCE");
    }

    @Test
    public void should_return_ADVANTAGE_when_any_player_has_score_more_then_MaxWiningPint () {
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 4).forEach((Integer) ->  player2.winBall());
        String s = tennisGameContext.executeStrategy(player1, player2,3);
        assertEquals(s,"ADVANTAGE");
    }

    @Test
    public void should_return_player_name_and_score_when_player_has_AtLeast_MaxWining_InTotal_And_AtLeastTwoPoints_More_Than_With_other_player () {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> player1.winBall());
        IntStream.rangeClosed(1, 5).forEach((Integer) -> player2.winBall());
        String s = tennisGameContext.executeStrategy(player1, player2,3);
        assertEquals(s,"player2 won with 5 points");
    }


    @Test
    public void should_return_player_when_any_player_has_maxWinningpoint () {
        IntStream.rangeClosed(1, 4).forEach((Integer) ->  player1.winBall());
        IntStream.rangeClosed(1, 6).forEach((Integer) ->  player2.winBall());
        String s = tennisSetContext.executeStrategy(player1, player2,6);
        assertEquals(s,"player2 won with 6 points");
    }

    @Test
    public void should_return_No_Winner_when_player_not_having_TwoPoints_More_With_other_player () {
        IntStream.rangeClosed(1, 6).forEach((Integer) -> player1.winBall());
        IntStream.rangeClosed(1, 5).forEach((Integer) -> player2.winBall());
        String s = tennisSetContext.executeStrategy(player1, player2,6);
        assertEquals(s,"No Winner");
    }

    @Test
    public void should_return_player_name_and_score_when_player_has_AtLeastmax_InTotal_And_AtLeastTwoPoints_More_Than_With_other_player () {
        IntStream.rangeClosed(1, 6).forEach((Integer) -> player1.winBall());
        IntStream.rangeClosed(1, 9).forEach((Integer) -> player2.winBall());
        String s = tennisSetContext.executeStrategy(player1, player2,6);
        assertEquals(s,"player2 won with 9 points");
    }

}