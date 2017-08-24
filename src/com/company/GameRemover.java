package com.company;

import java.util.Scanner;

public class GameRemover {

    private static GameRemover INSTANCE;

    private Scanner scanner;

    public void init() {
        scanner = new Scanner(System.in);

        removeGame();
    }

    private void removeGame() {
        System.out.println(
                "You have chosen to remove a game from your library.\n" +
                        "Here is a list of games type the number of the one you would like to remove?");
        Library library = Library.getLibrary();
        library.listGamesForRemoving();
        int gameIndex = scanner.nextInt();
        library.removeGame(gameIndex);
        Home home = Home.getHome();
        home.init();
    }

    public static GameRemover getGameRemover() {
        if(INSTANCE == null) {
            INSTANCE = new GameRemover();
        }
        return INSTANCE;
    }


}
