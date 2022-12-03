package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PairMatch {
    List<List<String>> resultPairMatch = new ArrayList<>();

    public List<List<String>> pairmatch(Course course, Level level){
        List<String> shuffledCrew = shuffledCrew(makeNameList(course));
        match(shuffledCrew,course,level);
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

    private boolean match(List<String> shuffledCrew, Course course, Level level) {
        if (shuffledCrew.size()%2 == 0) {
            return matchEven(shuffledCrew, course, level);
        }
        return matchOdd(shuffledCrew, course, level);
    }

    private boolean matchEven(List<String> shuffledCrew, Course course, Level level) {
        for (int i=0; i < shuffledCrew.size(); i +=2) {
            Crew[] crews = findCrews(course, shuffledCrew.subList(i,i+2));
            resultPairMatch.add(Arrays.asList(crews[0].getName(), crews[1].getName()));
            addPairCrews(crews, level);
        }
        return true;
    }

    private boolean matchOdd(List<String> shuffledCrew, Course course, Level level) {
        matchEven(shuffledCrew.subList(0,shuffledCrew.size()-3),course,level);
        Crew[] crews = findCrews(course, shuffledCrew.subList(shuffledCrew.size()-3,shuffledCrew.size()));
        resultPairMatch.add(Arrays.asList(crews[0].getName(),crews[1].getName(),crews[2].getName()));
        addPairCrews(crews,level);
        return true;
    }

    private Crew[] findCrews(Course course,List<String> shuffledCrew) {
        Crew[] crews = new Crew[shuffledCrew.size()];
        for (int i=0; i<shuffledCrew.size(); i++) {
            crews[i] = SetCrews.returnCrew(course, shuffledCrew.get(i));
        }
        return crews;
    }

    private void addPairCrews(Crew[] crews, Level level) {
        for (int i = 0; i < crews.length; i++) {
            for (int j = 0; j < crews.length; j++) {
                crews[i].addPair(level, crews[j]);
            }
        }
    }
}
