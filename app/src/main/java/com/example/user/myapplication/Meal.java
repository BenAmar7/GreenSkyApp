package com.example.user.myapplication;

public class Meal {
    private boolean vegetarian, meat, vegan;
    private boolean[] meal;
    private int points;

    public Meal() {
    }

    public Meal(boolean vegetarian, boolean meat, boolean vegan) {
        this.setVegetarian(vegetarian);
        this.setMeat(meat);
        this.setVegan(vegan);
        this.setMeal(new boolean[]{vegetarian,meat,vegan});
        this.setPoints(0);
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean[] getMeal() {
        return meal;
    }

    public void setMeal(boolean[] meal) {
        this.meal = meal;
    }
}
