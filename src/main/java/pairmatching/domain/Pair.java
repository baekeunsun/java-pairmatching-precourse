package pairmatching.domain;

import pairmatching.utils.Course;

import java.util.List;

public class Pair {
    private Course course;
    private String level;
    private String mission;
    private List<List<String>> crews;

    public Pair(Course course, String level, String mission, List<List<String>> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }

    public List<List<String>> findCrews(Course course, String level, String mission) {
        if ((level.equals(level)) && (mission.equals(this.mission))) {
            return this.crews;
        }
        return null;
    }
}
