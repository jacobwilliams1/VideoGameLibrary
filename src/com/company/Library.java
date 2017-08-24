package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Library {

    private static Library INSTANCE;

    private ArrayList<Game> gamesLibrary = new ArrayList();

    private ArrayList<Game> checkedOutGames = new ArrayList();

    private DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");


    public void addGame(Game game) {
        gamesLibrary.add(game);
    }
    public void removeGame(int gameIndex) {
        gamesLibrary.remove(gameIndex);
        System.out.println("\nYou removed item " + gameIndex + " from the list of games");
    }
    public void checkoutGame(int gameIndex) {
        Game game = gamesLibrary.get(gameIndex);
        checkedOutGames.add(game);

        Calendar calobj = Calendar.getInstance();
        System.out.println("You checked this game out on " +df.format(calobj.getTime()));
        calobj.add(Calendar.DAY_OF_YEAR, 14);
        System.out.println("It is due back on " +df.format(calobj.getTime()) + "\n");
        game.setDueDate(df.format(calobj.getTime()));
        gamesLibrary.remove(gameIndex);
    }
    public void checkinGame(int gameIndex) {
        Game game = checkedOutGames.get(gameIndex);
        gamesLibrary.add(game);
        try {
            Calendar calobj = Calendar.getInstance();
            String currentDate = df.format(calobj.getTime());
            String dueDate = game.getDueDate();
            System.out.println(df.parse(currentDate).before(df.parse(dueDate)));
            if (df.parse(currentDate).before(df.parse(dueDate))){
                System.out.println("You turned the book in on time thanks!");
            }else {
                System.out.println("You turned the book in late shame on you!");
            }
        } catch (ParseException e){
            e.printStackTrace();
        }

        checkedOutGames.remove(gameIndex);
    }

    public void listGamesInLibrary(){
        for (Game aGamesLibrary : gamesLibrary) {
            System.out.println(aGamesLibrary);
        }
        System.out.println("\n");
        Home home = Home.getHome();
        home.init();
    }
    public void listGamesCheckedOut(){
        for (Game aCheckedOutGames : checkedOutGames) {
            System.out.println(aCheckedOutGames);
        }
        System.out.println("\n");
        Home home = Home.getHome();
        home.init();
    }

    public void listGamesForRemoving() {
        int index=0;
        for (Game aGamesLibrary : gamesLibrary) {
            System.out.println(String.valueOf(index++)+": " + aGamesLibrary);
        }
    }
    public void listGamesForCheckingIn() {
        int index=0;
        for (Game aCheckedOutGames : checkedOutGames) {
            System.out.println(String.valueOf(index++)+": " + aCheckedOutGames);
        }
    }


    public static Library getLibrary() {
        if (INSTANCE == null) {
            INSTANCE = new Library();
        }
        return INSTANCE;
    }


}
