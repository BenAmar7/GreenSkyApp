package com.example.user.myapplication;

public class User {
    private long id;
    private String name;
    private String password;
    private long points;

    public User() {}

    public User(String name, String password, long id) {
        setId(id);
        setName(name);
        setPassword(password);
        setPoints(0);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public long getPoints() {
        return this.points;
    }
}

