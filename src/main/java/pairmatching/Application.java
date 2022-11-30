package pairmatching;

import pairmatching.controller.MatchingController;

public class Application {
    public static void main(String[] args) {
        try {
            new MatchingController().run();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
