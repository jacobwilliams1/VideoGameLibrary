package com.company;

public class Game {

    private String title;
    private String dueDate;


    public Game(String titleGiven){
    title = titleGiven;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
