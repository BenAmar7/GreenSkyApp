package com.example.user.myapplication;

public class User {
    private long id;
    private String name;
    private String password;
    private long points;

    public User(String name, String password, long id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.points = 0;
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

