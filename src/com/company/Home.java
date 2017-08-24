package com.company;

import java.util.Scanner;

public class Home {

    private static Home INSTANCE;

    private Scanner scanner;


    public void init() {
        scanner = new Scanner(System.in);
        startMenu();

    }

    private void startMenu() {
        System.out.println("Welcome to the Video Game Library.");
            System.out.println(
                            "1: Add a video game to your Library\n" +
                            "2: Remove video game from your library\n" +
                            "3: View the Library of your video games\n" +
                            "4: Check out a game\n" +
                            "5: View the checked out games\n" +
                            "6: Check in a game\n" +
                            "7: Close the program"
            );
            switch (scanner.next()) {
                case "1":
                    GameAdder gameAdder = GameAdder.getGameAdder();
                    gameAdder.init();
                    break;
                case "2":
                    GameRemover gameRemover = GameRemover.getGameRemover();
                    gameRemover.init();
                    break;
                case "3":
                    Library library = Library.getLibrary();
                    library.listGamesInLibrary();
                    break;
                case "4":
                    GameCheckout gameCheckout = GameCheckout.getGameCheckout();
                    gameCheckout.init();
                    break;
                case "5":
                    Library library1 = Library.getLibrary();
                    library1.listGamesCheckedOut();
                    break;
                case "6":
                    GameCheckin gameCheckin = GameCheckin.getGameCheckin();
                    gameCheckin.init();
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    startMenu();
                    break;

            }
        }

    public static Home getHome() {
        if(INSTANCE == null) {
            INSTANCE = new Home();
        }
        return INSTANCE;
    }
}
