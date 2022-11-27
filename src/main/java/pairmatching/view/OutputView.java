package pairmatching.view;

import java.util.List;

public class OutputView {
    public static void ResultPairMatchingView(List<List<String>> resultCrew) {
        System.out.println("페어 매칭 결과입니다.");
        for (int i=0; i <resultCrew.size(); i++) {
            String str = resultCrew.get(i).toString();
            str = str.replace(","," :");
            str = str.replace("[","");
            str = str.replace("]","");
            System.out.println(str);
        }
    }
}
