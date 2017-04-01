package com.shivang.recyclerviewassign;

/**
 * Created by sa on 3/27/2017.
 */
public class Movie {
    private String title, genre;

    private boolean isSelected;
    public Movie() {
    }

    public Movie(String title, String genre,boolean isSelected) {
        this.title = title;
        this.genre = genre;
        this.isSelected = isSelected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}