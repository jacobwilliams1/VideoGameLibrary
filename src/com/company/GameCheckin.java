package com.company;

import java.util.Scanner;

public class GameCheckin {

    private Scanner scanner;

    private static GameCheckin INSTANCE;


    public void init() {
        scanner = new Scanner(System.in);
        checkinGame();
    }

    private void checkinGame() {
        System.out.println(
                "You have chosen to check in a game from your library.\n" +
                        "Here is a list of games checked out type the number of the one you would like to check in?");
        Library library = Library.getLibrary();
        library.listGamesForCheckingIn();
        int gameIndex = scanner.nextInt();
        library.checkinGame(gameIndex);
        Home home = Home.getHome();
        home.init();
    }

    public static GameCheckin getGameCheckin() {
        if(INSTANCE == null) {
            INSTANCE = new GameCheckin();
        }
        return INSTANCE;
    }


}
