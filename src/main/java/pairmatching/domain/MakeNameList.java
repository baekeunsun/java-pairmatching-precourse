package pairmatching.domain;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MakeNameList {
    public static List<String> backendCrew = new ArrayList<>();
    public static List<String> frontendCrew = new ArrayList<>();

    public static List<String> makeBackendList() throws IOException {
        File backendFile = new File("src/main/resources/backend-crew.md");
        BufferedReader reader = new BufferedReader(
                new FileReader(backendFile)
        );
        String str;
        while ((str = reader.readLine()) != null) {
            backendCrew.add(str);
        }
        reader.close();
        return backendCrew;
    }

    public static List<String> makeFrontendList() throws IOException {
        File frontedFile = new File("src/main/resources/frontend-crew.md");
        BufferedReader reader = new BufferedReader(
                new FileReader(frontedFile)
        );
        String str;
        while ((str = reader.readLine()) != null) {
            frontendCrew.add(str);
        }
        reader.close();
        return frontendCrew;
    }
}
