package pairmatching.domain;

import java.util.List;

public class Pair {
    private Course course;
    private Level level;
    private String mission;
    private List<List<String>> crews;

    public Pair(Course course, Level level, String mission, List<List<String>> crews) {
        this.course = course;
        this.level = level;
        this.mission = mission;
        this.crews = crews;
    }

    public List<List<String>> getCrews(Course pairCourse, Level pairLevel, String pairMission) {
        if(pairCourse.equals(course) && pairLevel.equals(level) && pairMission.equals(mission)) {
            return this.crews;
        }
        return null;
    }
}
