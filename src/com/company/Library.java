package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Library {
    //  Go ahead and create an instance of home here to use for the future when going back to our homepage
    // Then go ahead and make these two lists for our games
    private final Home home;

    private List<Game> gamesLibrary = new ArrayList();

    private List<Game> checkedOutGames = new ArrayList();

    private DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    public Library(Home home) {
        this.home = home;
    }
    // 8 Here we do add game which just adds the game you pass in from home
    public void addGame(Game game) {
        gamesLibrary.add(game);
    }
    public void removeGame(int gameIndex) {
        gameIndex -= gameIndex;
        gamesLibrary.remove(gameIndex);
        System.out.println("\nYou removed the game from the list of games");
    }
    // 13 here we minus 1 from the game index because the index actually starts at 0 but we set it as 1 so the user would have a better experience
    //and when we minus 1 it brings it back to where we can use it to move the game to the other list
    //then we add the game to the checkedOutGames list because it was just checked out
    //next we need to create a date formatter at the top to make a time for the user to check the book back in
    // here the amount in the calobj.add is days so 2 weeks is the time they have to turn the book back in
    public void checkoutGame(int gameIndex) {
        gameIndex -= gameIndex;
        Game game = gamesLibrary.get(gameIndex);
        checkedOutGames.add(game);

        Calendar calobj = Calendar.getInstance();
        System.out.println("You checked this game out on " +df.format(calobj.getTime()));
        calobj.add(Calendar.DAY_OF_YEAR, 14);
        System.out.println("It is due back on " +df.format(calobj.getTime()) + "\n");
        game.setDueDate(df.format(calobj.getTime()));
        gamesLibrary.remove(gameIndex);
    }
    // 15 this method is just like the checkout game method except we need to check and make sure that they turned the book in on time put this in a ty catch in case it breaks
    //
    public void checkinGame(int gameIndex) {
        gameIndex -= gameIndex;
        Game game = checkedOutGames.get(gameIndex);
        gamesLibrary.add(game);
        try {
            Calendar calobj = Calendar.getInstance();
            String currentDate = df.format(calobj.getTime());
            String dueDate = game.getDueDate();
            if (df.parse(currentDate).before(df.parse(dueDate))){
                System.out.println("You turned the book in on time thanks!");
                System.out.println("\n");
            }else {
                System.out.println("You turned the book in late shame on you!");
                System.out.println("\n");
            }
        } catch (ParseException e){
            e.printStackTrace();
        }

        checkedOutGames.remove(gameIndex);
    }

    public void listGamesInLibrary(){
        if(gamesLibrary.size() > 0) {
            for (Game aGamesLibrary : gamesLibrary) {
                System.out.println(aGamesLibrary);
            }
            System.out.println("\n");
            home.init();
        }else{
            System.out.println("There are no games in the Library.");
            System.out.println("\n");
            home.init();
        }
    }
    public void listGamesCheckedOut(){
        if(checkedOutGames.size() > 0) {
            for (Game aCheckedOutGames : checkedOutGames) {
                System.out.println(aCheckedOutGames);
            }
            System.out.println("\n");
            home.init();
        }else{
            System.out.println("There are no games checked out.");
            System.out.println("\n");
            home.init();
        }

    }
    // 10 in this method we just set an index for the list then list the games in the game library then go ahead and make a similar method below and above for
    // use in the future when we check in games and look for games checked in and checked out then go back to the menu and call the ones you need
    public void listGamesForRemoving() {
        int index=1;
        if(gamesLibrary.size() > 0) {
            for (Game aGamesLibrary : gamesLibrary) {
                System.out.println(String.valueOf(index++) + ": " + aGamesLibrary);
            }
        }else{
            System.out.println("\n");
            System.out.println("Sorry no games were found. ");
            System.out.println("\n");
            home.init();
        }
    }
    public void listGamesForCheckingIn() {
        int index=1;
        if (checkedOutGames.size() > 0) {
            for (Game aCheckedOutGames : checkedOutGames) {
                System.out.println(String.valueOf(index++) + ": " + aCheckedOutGames);
            }
        }else{
            System.out.println("\n");
            System.out.println("Sorry no games were found.");
            System.out.println("\n");
            home.init();
        }
    }
}
