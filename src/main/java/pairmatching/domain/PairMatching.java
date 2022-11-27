package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.List;

public class PairMatching {
    public PairMatching() throws IOException {
        List<String> backendCrew = MakeNameList.makeBackendList();
        List<String> shuffledBackendCrew = Randoms.shuffle(backendCrew);

        List<String> frontendCrew = MakeNameList.makeFrontendList();
        List<String> shuffledFrontendCrew = Randoms.shuffle(frontendCrew);
    }
}
