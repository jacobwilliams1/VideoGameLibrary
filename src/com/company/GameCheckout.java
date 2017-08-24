package com.company;

import java.util.Scanner;

public class GameCheckout {

    private Scanner scanner;

    private static GameCheckout INSTANCE;

    public void init() {
        scanner = new Scanner(System.in);
        checkoutGame();
    }

    private void checkoutGame() {
        System.out.println(
                "You have chosen to checkout a game from your library.\n" +
                        "Here is a list of games type the number of the one you would like to checkout?");
        Library library = Library.getLibrary();
        library.listGamesForRemoving();
        int gameIndex = scanner.nextInt();
        library.checkoutGame(gameIndex);
        Home home = Home.getHome();
        home.init();
    }

    public static GameCheckout getGameCheckout() {
        if(INSTANCE == null) {
            INSTANCE = new GameCheckout();
        }
        return INSTANCE;
    }


}
