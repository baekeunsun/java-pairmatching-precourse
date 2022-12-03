package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.util.ArrayList;
import java.util.List;

public class PairMatch {

    public List<List<String>> pairmatch(Course course){
        List<String> shuffledCrew = shuffledCrew(makeNameList(course));
        return null;
    }

    public List<String> makeNameList(Course course){
        List<String> crews = new ArrayList<>();
        for (Crew crew : getCrew(course)) {
            crews.add(crew.getName());
        }
        return crews;
    }

    public List<Crew> getCrew(Course course) {
        if (course.equals(Course.BACKEND)) {
            return SetCrews.backendCrew;
        }
        return SetCrews.frontendCrew;
    }

    public List<String> shuffledCrew(List<String> crew) {
        List<String> shuffledCrew = Randoms.shuffle(crew);
        return shuffledCrew;
    }
}
