package com.sg.tennis;

import com.sg.tennis.entities.Player;
import com.sg.tennis.service.TennisGame;

import java.util.stream.IntStream;


public class TennisKataApplicationDemo {

    public static void main(String args[]) {

        Player p1=new Player("player1");
        Player p2=new Player("Player2");

        IntStream.rangeClosed(0, 1).forEach((Integer) -> p1.winBall());
        IntStream.rangeClosed(0, 2).forEach((Integer) -> p2.winBall());
        TennisGame tennisGame = new TennisGame();
        System.out.println(tennisGame.startGame(p1,p2));

    }
}
