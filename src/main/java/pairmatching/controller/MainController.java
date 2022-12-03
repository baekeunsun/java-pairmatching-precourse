package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.service.PairMatch;
import pairmatching.service.SetCrews;
import pairmatching.utils.ErrorMessage;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pairmatching.service.SetCrews.returnCrew;


public class MainController {
    List<Pair> pairList;

    public MainController() throws IOException {
        pairList = new ArrayList<>();
        new SetCrews();
    }

    public void run() throws IOException {
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
            pairList.clear();
            Crew.initializaePair();
            return true;
        }
        if (input.equals("Q")) {  // 종료
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_123Q.getMessage());
    }

    private void pairMatching() {
        List<String> input = InputView.pairMatchingView();
        Course course = Course.getName(input.get(0));
        Level level = Level.getName(input.get(1));
        String mission = level.getMission(input.get(2));

        if (checkPair(course, level, mission)) {
            List<List<String>> pairResult = new PairMatch().pairmatch(course,level);
            pairList.add(new Pair(course, level, mission, pairResult));
            OutputView.ResultPairMatchingView(pairResult);
        }
    }

    private boolean checkPair(Course course, Level level, String mission) {
        for (int i = 0; i<pairList.size(); i++) {
            List<List<String>> preList = pairList.get(i).getCrews(course, level, mission);
            if (preList!=null) {
                return retryPair(course, preList, i);
            }
        }
        return true;
    }

    private boolean retryPair(Course course,List<List<String>> preList,int i ) {
        String retry = InputView.retryMatchingView();
        if (retry.equals("네")) {
            pairList.remove(i);
            removeExistPair(course, preList);
            return true;
        }
        if (retry.equals("아니오")) {
            return false;
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_YES_OR_NO.getMessage());
    }

    private void removeExistPair(Course course, List<List<String>> preList) {
        for (List<String> nowPair : preList) {
            Crew[] crews = new Crew[nowPair.size()];
            for (int i =0; i < nowPair.size(); i++) {
                crews[i] = returnCrew(course, nowPair.get(i));
            }
            removePairCrew(crews);
        }
    }

    private void removePairCrew(Crew[] crews) {
        for (int i = 0; i < crews.length; i++) {
            for (int j = 0; j < crews.length; j++) {
                crews[i].removePair(crews[j]);
            }
        }
    }

    private void inquiryMatching() {
        List<String> input = InputView.inquiryMacthingView();
        Course course = Course.getName(input.get(0));
        Level level = Level.getName(input.get(1));
        String mission = level.getMission(input.get(2));

        for (int i = 0; i<pairList.size(); i++) {
            List<List<String>> findPairList = pairList.get(i).getCrews(course, level, mission);
            if (findPairList!=null) {
                OutputView.ResultPairMatchingView(findPairList);
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_PAIR.getMessage());
    }
}
