package com.company;

import java.util.Scanner;

public class Home {
    // 2 Here we will need to make a menu in this class we will need 2 scanners for different inputs you
    //can use one scanner for multiple inputs but only if they use the same type of input such as both using strings
    //or both using integers but in this class we use integers and strings so start by making those
    //Then we will make the method init and call it from the main class to start the program in this class
    private Scanner scannerLn;
    private Scanner scannerInt;

    private Library library = new Library(this);

    private Boolean isValid;

    // 3 Inside init we need to initialize both of our scanners then call a method start menu that starts the menu
    // you can call a method like it is below then click at the end of the parentheses and click "Create method startMenu()
    public void init() {
        scannerLn = new Scanner(System.in);
        scannerInt = new Scanner(System.in);
        isValid = false;
        startMenu();

    }
    // 4 when we start here go back to the top and create a boolean is valid we will use this to check for valid responses in our start menu method
    //first we will make the try catch so we can put everything in it then below that we create our while loop for valid responses
    //Here our menu is actually just a System.out.println not too complicated then after that we have a switch statement using the integer scanner for input
    //here we can see why we have the isValid while loop once you get this working try putting in the word "one" and seeing what the code does if it works correctly
    //it should take you back to the start of the method
    private void startMenu() {
        try {
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
                // 5 So here we have the switch case using the scanner based on our menu list for now just add is valid == true to all the correct responses
                // except the default make that one false then call the method again to let the user try again
                //The next thing we need to do is create the game model **SEE GAME MODEL CLASS**
                //Once we come back after making our model we can add the method calls below for add remove checkout and checkin
                //Then again we can click next to the parentheses and create all these methods
                switch (scannerInt.nextInt()) {
                    case 1:
                        addGame();
                        isValid = true;
                        break;
                    case 2:
                        removeGame();
                        isValid = true;
                        break;
                    case 3:
                        // 11 here we call the method we just made for listing games in the library
                        library.listGamesInLibrary();
                        isValid = true;
                        break;
                    case 4:
                        checkoutGame();
                        isValid = true;
                        break;
                    case 5:
                        // 11 cont. here we list the games checked out using the method we just made
                        library.listGamesCheckedOut();
                        isValid = true;
                        break;
                    case 6:
                        checkinGame();
                        isValid = true;
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid input. Try again.");
                        isValid = false;
                        startMenu();
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            startMenu();
        }
    }
    // 7 We will do these methods one at a time first add game
    //So here we will go ahead and create the library class then come back here
    //Whenever we are making these we will call methods we haven't created yet just as we did before then add them afterwards in this case it will be addGame(game);
    //in the library class
    //Make sure to call init at the end to start the menu again when this method is done
    //Next go to the top of the class and add the initialization for the Library class so we can use the same instance and keep everything working in one instance
    private void addGame() {
        System.out.println(
                "You have chosen to add a game to your library.\n" +
                        "What is the title of your  game?");
        String gameTitle = scannerLn.nextLine();
        Game game = new Game(gameTitle);
        System.out.print("You set the game title to " + game.getTitle());
        library.addGame(game);
        init();
    }// 9 For remove games we need to create a method that lists the games for removing go to library
    private void removeGame() {
        System.out.println(
                "You have chosen to remove  a game from your library.\n" +
                        "Here is a list of games type the number of the one you would like to remove?");
        library.listGamesForRemoving();
        int gameIndex = scannerInt.nextInt();
        library.removeGame(gameIndex);
        init();
    }
    // 12 here we are checking out games so we will go create the method for that in the library see checkoutGame in library
    private void checkoutGame() {
        System.out.println(
                "You have chosen to checkout a game from your library.\n" +
                        "Here is a list of games type the  number of the one you would like to checkout?");
        library.listGamesForRemoving();
        int gameIndex = scannerInt.nextInt();
        library.checkoutGame(gameIndex);
        init();
    }
    // 14 lastly here we need to create the checkin method then go create the checkin method in the library
    private void checkinGame() {
        System.out.println(
                "You have chosen to check in a game from your library.\n" +
                        "Here is a list of games checked out type the number of the one you would like to  check in?");
        library.listGamesForCheckingIn();
        int gameIndex = scannerInt.nextInt();
        library.checkinGame(gameIndex);
        init();
    }


}
