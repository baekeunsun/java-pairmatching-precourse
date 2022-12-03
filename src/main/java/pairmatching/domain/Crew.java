package pairmatching.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Crew {
    private String name;
    private Course course;
    private static Map<Level, List<Crew>> pairCrew = new HashMap<>();

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

    public void addPair(Level level, Crew crew) {
        if (this.pairCrew.get(level) == null) {
            this.pairCrew.put(level, new ArrayList<>());
        }
        if (this.name != crew.getName()) {
            this.pairCrew.get(level).add(crew);
        }
    }

    public boolean checkPair(Level level, Crew crew) {
        if (this.pairCrew.get(level) == null) {
            return true;
        }
        if (this.pairCrew.get(level).equals(crew)) {
            return false;
        }
        return true;
    }

    public static void removePair(Crew crew) {
        pairCrew.remove(crew);
    }

    public static void initializaePair() {
        pairCrew.clear();
    }
}
