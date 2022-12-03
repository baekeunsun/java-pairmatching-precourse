package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SetCrews {
    public static List<Crew> backendCrew = new ArrayList<>();
    public static List<Crew> frontendCrew = new ArrayList<>();

    public SetCrews() throws IOException {
        makeBackendCrews();
        makeFrontendCrews();
    }

    private static BufferedReader readFile(File filename) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader;
    }

    public static void makeBackendCrews() throws IOException {
        BufferedReader reader = readFile(new File("src/main/resources/backend-crew.md"));
        String name;
        while ((name = reader.readLine()) != null) {
            backendCrew.add(new Crew(name, Course.BACKEND));
        }
        reader.close();
    }

    public static void makeFrontendCrews() throws IOException {
        File frontedFile = new File("src/main/resources/frontend-crew.md");
        BufferedReader reader = new BufferedReader(
                new FileReader(frontedFile)
        );
        String name;
        while ((name = reader.readLine()) != null) {
            frontendCrew.add(new Crew(name,Course.FRONTEND));
        }
        reader.close();
    }
}
