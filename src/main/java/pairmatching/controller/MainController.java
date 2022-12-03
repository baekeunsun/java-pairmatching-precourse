package pairmatching.controller;

import pairmatching.service.SetCrews;
import pairmatching.view.InputView;

import java.io.IOException;
import java.util.List;


public class MainController {

    public MainController() throws IOException {
        new SetCrews();
    }

    public void run(){
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

    private void pairMatching(){
        List<String> input = InputView.pairMatchingView();
    }
}
