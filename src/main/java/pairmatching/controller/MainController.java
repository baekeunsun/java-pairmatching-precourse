package pairmatching.controller;

import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.service.PairMatch;
import pairmatching.service.SetCrews;
import pairmatching.view.InputView;

import java.io.IOException;
import java.util.List;


public class MainController {

    public MainController() throws IOException {
        new SetCrews();
    }

    public void run() throws IOException {
        boolean gameRun = true;
        while (gameRun) {
            String input = InputView.selectFeaturesView();
            gameRun = selectMenu(input);
        }
    }

    public boolean selectMenu(String input) throws IOException {
        if (input.equals("1")) {  // 페어 매칭
            pairMatching();
            return true;
        }
        if (input.equals("2")) {  // 페어 조회
            return true;
        }
        if (input.equals("3")) {  // 페어 초기화
            return true;
        }
        if (input.equals("Q")) {  // 종료
            return false;
        }
        throw new IllegalArgumentException();
    }

    private void pairMatching() throws IOException {
        List<String> input = InputView.pairMatchingView();
        Course course = Course.getName(input.get(0));
        Level level = Level.getName(input.get(1));
        List<List<String>> pairResult = new PairMatch().pairmatch(course,level);
    }
}
