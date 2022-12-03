package pairmatching.domain;

public class Crew {
    private String name;
    private Course course;

    public Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return this.name;
    }

}
