package com.deltadax.views_example.entity;

import com.deltadax.views_example.C;

/**
 * Created by JosePablo on 01/08/17.
 */

public class ListItem {

    private String name;
    private int state;
    private String image;
    private int points;

    public ListItem(String name) {
        this.name = name;
        this.state = C.state_active;
    }

    public ListItem(String name, int state, String image, int points) {
        this.name = name;
        this.state = state;
        this.image = image;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
