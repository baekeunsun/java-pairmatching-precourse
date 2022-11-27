package pairmatching;

import pairmatching.domain.Game;

public class Application {
    public static void main(String[] args) {
        try {
            new Game();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
