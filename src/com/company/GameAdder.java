package com.company;

import java.util.Scanner;

public class GameAdder {

    private static GameAdder INSTANCE;

    private Scanner scanner;
    public void init() {
        scanner = new Scanner(System.in);

        addGame();
    }

    private void addGame() {
        System.out.println(
                "You have chosen to add a game to your library.\n" +
                        "What is the title of your game?");
        String gameTitle = scanner.nextLine();
        Game game = new Game(gameTitle);
        System.out.print("You set the game title to " + game.getTitle());
        Library library = Library.getLibrary();
        library.addGame(game);
        Home home = Home.getHome();
        home.init();
    }
    public static GameAdder getGameAdder() {
        if(INSTANCE == null) {
            INSTANCE = new GameAdder();
        }
        return INSTANCE;
    }

}
