package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.utils.ErrorMessage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PairMatching {
    List<List<String>> resultCrew = new ArrayList<>();
    Integer count = 0;

    public List<List<String>> run(Course course, Level level, String mission) throws IOException {
        while (count < 4) {
            List<String> shuffledCrew = shuffledCrew(makeCrew(course));
            if (match(shuffledCrew, course, level)) {
                return resultCrew;
            }
            count += 1;
        }
        throw new IllegalAccessError(ErrorMessage.EXCESS_COUNT.getMessage());
    }

    public List<String> makeCrew(Course course) throws IOException {
        List<String> crew = new ArrayList<>();
        for (Crew member : findType(course)) {
            crew.add(member.getName());
        }
        return crew;
    }

    public List<Crew> findType(Course course) {
        if (course.equals(Course.BACKEND)) {
            return MakeCrews.backendCrew;
        }
        return MakeCrews.frontendCrew;
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
            if (!checkPairCrews(crews,level)) {
                return false;
            }
            resultCrew.add(Arrays.asList(crews[0].getName(), crews[1].getName()));
            addPairCrews(crews, level);
        }
        return true;
    }

    private boolean matchOdd(List<String> shuffledCrew, Course course, Level level) {
        matchEven(shuffledCrew.subList(0,shuffledCrew.size()-3),course,level);
        Crew[] crews = findCrews(course, shuffledCrew.subList(shuffledCrew.size()-3,shuffledCrew.size()));
        if (!checkPairCrews(crews,level)) {
            return false;
        }
        resultCrew.add(Arrays.asList(crews[0].getName(),crews[1].getName(),crews[2].getName()));
        addPairCrews(crews,level);
        return true;
    }

    private Crew[] findCrews(Course course,List<String> shuffledCrew) {
        Crew[] crews = new Crew[shuffledCrew.size()];
        for (int i=0; i<shuffledCrew.size(); i++) {
            crews[i] = MakeCrews.returnCrew(course, shuffledCrew.get(i));
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

    private boolean checkPairCrews(Crew[] crews, Level level) {
        for (int i = 1; i < crews.length; i++) {
            if (!crews[0].checkPair(level,crews[i])) {
                return false;
            };
        }
        return true;
    }
}
