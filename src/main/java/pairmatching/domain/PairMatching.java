package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static pairmatching.utils.Course.BACKEND;

public class PairMatching {
    public static List<String> shuffledBackendCrew = new ArrayList<>();
    public static List<String> shuffledFrontendCrew = new ArrayList<>();

    public PairMatching() throws IOException {
        List<String> backendCrew = MakeNameList.makeBackendList();
        this.shuffledBackendCrew = Randoms.shuffle(backendCrew);

        List<String> frontendCrew = MakeNameList.makeFrontendList();
        this.shuffledFrontendCrew = Randoms.shuffle(frontendCrew);
    }
    public void match(String endType, String levelType, String missionType) {
        List<String> shuffledCrew = shuffledBackendCrew;
        List<List<String>> resultCrew = new ArrayList<>();

        System.out.println(shuffledCrew);

        if (shuffledCrew.size()%2 == 0) {
            System.out.println("짝수");
            resultCrew = matchEven(shuffledCrew);
        }
        printMatching(resultCrew);
    }
    private List<List<String>> matchEven(List<String> shuffledCrew) {
        List<List<String>> resultCrew = new ArrayList<>();
        for (int i=0; i < shuffledCrew.size(); i +=2) {
            System.out.println(i);
            resultCrew.add(Arrays.asList(shuffledCrew.get(i),shuffledCrew.get(i+1)));
        }
        return resultCrew;
    }
    public void printMatching(List<List<String>> resultCrew) {
        for (int i=0; i <resultCrew.size(); i++) {
            String str = resultCrew.get(i).toString();
            str = str.replace(","," :");
            str = str.replace("[","");
            str = str.replace("]","");
            System.out.println(str);
        }
    }
}
