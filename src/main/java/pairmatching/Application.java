package pairmatching;

import pairmatching.controller.MainController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        try {
            new MainController().run();
        } catch (IOException e) {
        }
    }
}
