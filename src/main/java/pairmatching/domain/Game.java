package pairmatching.domain;

import pairmatching.utils.Course;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.view.InputView.inquiryMacthingView;
import static pairmatching.view.InputView.pairMatchingView;

public class Game {

    public Game() {
        List<Pair> pairList = new ArrayList<>();

        while (true) {
            String feature = InputView.selectFeaturesView();
            if (feature.equals("1")) {  // 페어 매칭
                List<String> input = pairMatchingView();
                try {
                    PairMatching pair = new PairMatching();
                    List<List<String>> pairResult = pair.match(input.get(0),input.get(1),input.get(2));
                    Pair newPair = new Pair(Course.BACKEND, input.get(1), input.get(2), pairResult);
                    pairList.add(newPair);
                }catch (IOException e) {
                    System.out.println(e);
                }
            }

            if (feature.equals("2")) {  // 페어 조회
                List<String> input = inquiryMacthingView();
                for (int i = 0; i<pairList.size(); i++) {
                    List<List<String>> tmpList = pairList.get(i).findCrews(Course.BACKEND,input.get(1), input.get(2));
                    if (tmpList!=null) {
                        OutputView.ResultPairMatchingView(tmpList);
                        break;
                    };
                }
                System.out.println("[ERROR] 매칭 이력이 없습니다.");
            }

            if (feature.equals("3")) {  // 페어 초기화
                pairList = new ArrayList<>();
            }

            if (feature.equals("Q")) {  // 종료
                break;
            }

        }
    }
}
