package pairmatching.domain;

import pairmatching.utils.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선")),
    LEVEL3("레벨3"),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5");

    private String name;
    private List<String> missions;

    Level(String name) {
        this.name = name;
    }

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level getName(String input) {
        return Arrays.stream(Level.values())
                .filter(l -> input.equals(l.name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_EXIST_LEVEL.getMessage()));
    }

    public String getMission(String mission) {
        if (this.missions.contains(mission)) {
            return mission;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_MISSION.getMessage());
    }
}
