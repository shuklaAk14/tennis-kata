package com.sg.tennis.enums;

public enum ScoreEnum {
    UN(15),
    DEUX(30),
    TROIS(40);

    private final Integer value;

    ScoreEnum(Integer envUrl) {
        this.value = envUrl;
    }

    public Integer getValue() {
        return value;
    }

}
