package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.utils.ErrorMessage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MakeCrews {
    public static List<Crew> backendCrew = new ArrayList<>();
    public static List<Crew> frontendCrew = new ArrayList<>();

    public MakeCrews() throws IOException {
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
            backendCrew.add(new Crew(name,Course.BACKEND));
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

    public static Crew returnCrew(Course course, String name) {
        List<Crew> crew = findType(course);
        for (int i=0; i < crew.size(); i++) {
            if (crew.get(i).getName().equals(name)) {
                return crew.get(i);
            }
        }
        throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_CREW.getMessage());
    }

    private static List<Crew> findType(Course course) {
        List<Crew> crew = new ArrayList<>();
        if (course.equals(Course.BACKEND)) {
            crew = backendCrew;
        }
        if (course.equals(Course.FRONTEND)) {
            crew = frontendCrew;
        }
        return crew;
    }
}
