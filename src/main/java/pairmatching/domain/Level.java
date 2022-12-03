package pairmatching.domain;

import pairmatching.utils.ErrorMessage;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level getName(String input) {
        return Arrays.stream(Level.values())
                .filter(l -> input.equals(l.name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LEVEL.getMessage()));
    }
}
