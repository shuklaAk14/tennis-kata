package com.sg.tennis;

import com.sg.tennis.entities.Player;
import com.sg.tennis.service.GameStrategyContext;
import com.sg.tennis.service.TennisGame;
import com.sg.tennis.service.TennisSetStrategy;

import java.util.stream.IntStream;


public class TennisKataApplicationDemo {

    public static void main(String[] args) {

        Player p1=new Player("player1");
        Player p2=new Player("player2");

        IntStream.rangeClosed(1, 3).forEach((Integer) -> p1.winBall());
        IntStream.rangeClosed(1, 1).forEach((Integer) ->  p2.winBall());

        GameStrategyContext context = new GameStrategyContext(new TennisGame());
        System.out.println(context.executeStrategy(p1,p2,3));

        context = new GameStrategyContext(new TennisSetStrategy());
        System.out.println(context.executeStrategy(p1,p2,6));

    }
}
