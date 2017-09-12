package com.company;

public class Game {
    // 6 Ok here we have a simple model for our games
    //The only thing special here is the @Override at the bottom
    //When you try and list the games later on it will not want to list them because it wont know which variables it needs to use
    //So here we override the method that it will be using to choose how it will be displayed
    //Which in this case is just the title

    private String title;
    private String dueDate;

    public Game(String titleGiven){
    title = titleGiven;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return title;
    }
}
