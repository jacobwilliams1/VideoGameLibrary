package com.company;

import java.util.Scanner;

public class Home {

    private Scanner scannerLn;
    private Scanner scannerInt;

    private Library library = new Library(this);

    private Boolean isValid;


    public void init() {
        scannerLn = new Scanner(System.in);
        scannerInt = new Scanner(System.in);
        isValid = false;
        startMenu();

    }

    private void startMenu() {
        while (!isValid) {
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
            switch (scannerLn.nextLine()) {
                case "1":
                    addGame();
                    isValid = true;
                    break;
                case "2":
                    removeGame();
                    isValid = true;
                    break;
                case "3":
                    library.listGamesInLibrary();
                    isValid = true;
                    break;
                case "4":
                    checkoutGame();
                    isValid = true;
                    break;
                case "5":
                    library.listGamesCheckedOut();
                    isValid = true;
                    break;
                case "6":
                    checkinGame();
                    isValid = true;
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    isValid = false;
                    startMenu();
                    break;
            }
        }
    }
    private void checkinGame() {
        System.out.println(
                "You have chosen to check in a game from your library.\n" +
                        "Here is a list of games checked out type the number of the one you would like to  check in?");
        library.listGamesForCheckingIn();
        int gameIndex = scannerInt.nextInt();
        library.checkinGame(gameIndex);
        init();
    }
    private void addGame() {
        System.out.println(
                "You have chosen to add a game to your library.\n" +
                        "What is the title of your  game?");
        String gameTitle = scannerLn.nextLine();
        Game game = new Game(gameTitle);
        System.out.print("You set the game title to " + game.getTitle());
        library.addGame(game);
        init();
    }
    private void checkoutGame() {
        System.out.println(
                "You have chosen to checkout a game from your library.\n" +
                        "Here is a list of games type the  number of the one you would like to checkout?");
        library.listGamesForRemoving();
        int gameIndex = scannerInt.nextInt();
        library.checkoutGame(gameIndex);
        init();
    }
    private void removeGame() {
        System.out.println(
                "You have chosen to remove  a game from your library.\n" +
                        "Here is a list of games type the number of the one you would like to remove?");
        library.listGamesForRemoving();
        int gameIndex = scannerInt.nextInt();
        library.removeGame(gameIndex);
        init();
    }
}
