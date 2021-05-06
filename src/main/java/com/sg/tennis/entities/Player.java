package com.sg.tennis.entities;

public class Player {
    private int score;
    private final String name;

    public Player(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public int getScore() {
        return score;
    }
    public void winBall() {
        this.score = this.score + 1;
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
}
