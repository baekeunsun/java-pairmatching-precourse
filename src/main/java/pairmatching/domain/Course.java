package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getName(String input) {
        return Arrays.stream(values())
                .filter(l -> input.equals(l.name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지않는 코스입니다."));
    }
}
