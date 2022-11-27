package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PairMatching {
    public static List<String> shuffledBackendCrew = new ArrayList<>();
    public static List<String> shuffledFrontendCrew = new ArrayList<>();

    public List<List<String>> match(String endType, String levelType, String missionType) throws IOException {
        List<String> shuffledCrew = crewType(endType);  // endType점검, 셔플
        List<List<String>> resultCrew = Numtype(shuffledCrew);  // 짝홀점검
        printMatching(resultCrew);  // 출력
        return resultCrew;
    }

    private List<List<String>> Numtype(List<String> shuffledCrew) {
        List<List<String>> resultCrew = new ArrayList<>();
        if (shuffledCrew.size()%2 == 0) {
            resultCrew = matchEven(shuffledCrew);
        }
        if (shuffledCrew.size()%2 == 1) {
            resultCrew = matchOdd(shuffledCrew);
        }
        return resultCrew;
    }

    private List<List<String>> matchEven(List<String> shuffledCrew) {
        List<List<String>> resultCrew = new ArrayList<>();
        for (int i=0; i < shuffledCrew.size(); i +=2) {
            resultCrew.add(Arrays.asList(shuffledCrew.get(i),shuffledCrew.get(i+1)));
        }
        return resultCrew;
    }

    private List<List<String>> matchOdd(List<String> shuffledCrew) {
        List<List<String>> resultCrew = new ArrayList<>();
        for (int i=0; i < shuffledCrew.size()-3; i +=2) {
            System.out.println(i);
            resultCrew.add(Arrays.asList(shuffledCrew.get(i),shuffledCrew.get(i+1)));
        }
        resultCrew.add(Arrays.asList(shuffledCrew.get(shuffledCrew.size()-3),shuffledCrew.get(shuffledCrew.size()-2),shuffledCrew.get(shuffledCrew.size()-1)));
        return resultCrew;
    }

    private List<String> crewType(String endType) throws IOException {
        if (endType.equals("백엔드")) {
            List<String> backendCrew = MakeNameList.makeBackendList();
            this.shuffledBackendCrew = Randoms.shuffle(backendCrew);
            return shuffledBackendCrew;
        }
        List<String> frontendCrew = MakeNameList.makeFrontendList();
        this.shuffledFrontendCrew = Randoms.shuffle(frontendCrew);
        return shuffledFrontendCrew;
    }

    public void printMatching(List<List<String>> resultCrew) {
        OutputView.ResultPairMatchingView(resultCrew);
    }
}
