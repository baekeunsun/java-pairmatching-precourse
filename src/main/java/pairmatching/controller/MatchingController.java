package pairmatching.controller;

import pairmatching.domain.Pair;
import pairmatching.domain.PairMatching;
import pairmatching.utils.Course;
import pairmatching.utils.ErrorMessage;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.view.InputView.*;

public class MatchingController {
    List<Pair> pairList = new ArrayList<>();

    public MatchingController() {
        pairList = new ArrayList<>();
    }

    public void run() {
        boolean gameRun = true;
        while (gameRun) {
            String input = InputView.selectFeaturesView();
            gameRun = selectMenu(input);
        }
    }

    public boolean selectMenu(String input) {
        if (input.equals("1")) {  // 페어 매칭
            pairMatching();
            return true;
        }
        if (input.equals("2")) {  // 페어 조회
            inquiryMatching();
            return true;
        }
        if (input.equals("3")) {  // 페어 초기화
            pairList = new ArrayList<>();
            return true;
        }
        if (input.equals("Q")) {  // 종료
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_123Q.getMessage());
    }
    private boolean checkPair(List<String> input) {
        for (int i = 0; i<pairList.size(); i++) {
            List<List<String>> tmpList = pairList.get(i).findCrews(Course.BACKEND,input.get(1), input.get(2));
            if (tmpList!=null) {
                String retry = retryMatchingView();
                if (retry.equals("네")) {
                    System.out.println(pairList.size());
                    pairList.remove(i);
                    System.out.println(pairList.size());
                    return true;
                }
                if (retry.equals("아니오")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void pairMatching() {
        List<String> input = pairMatchingView();
        try {
            PairMatching pair = new PairMatching();
            List<List<String>> pairResult = pair.match(input.get(0),input.get(1),input.get(2));
            Pair newPair = new Pair(Course.BACKEND, input.get(1), input.get(2), pairResult);
            pairList.add(newPair);
            OutputView.ResultPairMatchingView(pairResult);
        }catch (IOException e) {
            System.out.println(e);
        }
    }

    private void inquiryMatching() {
        List<String> input = inquiryMacthingView();
        for (int i = 0; i<pairList.size(); i++) {
            List<List<String>> tmpList = pairList.get(i).findCrews(Course.BACKEND,input.get(1), input.get(2));
            if (tmpList!=null) {
                OutputView.ResultPairMatchingView(tmpList);
            }
        }
        // System.out.println("[ERROR] 매칭 이력이 없습니다.");
    }
}
