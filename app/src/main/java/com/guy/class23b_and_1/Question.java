package com.guy.class23b_and_1;

public class Question {

    private String name;
    private int image;
    private boolean kosher;

    public Question() {}

    public Question(String name, int image, boolean kosher) {
        this.name = name;
        this.image = image;
        this.kosher = kosher;
    }

    public String getName() {
        return name;
    }

    public Question setName(String name) {
        this.name = name;
        return this;
    }

    public int getImage() {
        return image;
    }

    public Question setImage(int image) {
        this.image = image;
        return this;
    }

    public boolean isKosher() {
        return kosher;
    }

    public Question setKosher(boolean kosher) {
        this.kosher = kosher;
        return this;
    }
}
