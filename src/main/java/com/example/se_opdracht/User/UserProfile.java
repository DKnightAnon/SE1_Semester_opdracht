package com.example.se_opdracht.User;

public class UserProfile{

    private String username;
    private String email;
    private boolean darkMode;

    private static UserProfile instance;
    private UserProfile(){}

    public static UserProfile getInstance(){
        if(instance == null){
            instance = new UserProfile();
        }
        return instance;
    }

    public void setUser(User user){
        this.username = user.getUserName();
        this.email = user.getEmail();
        this.darkMode = user.getDarkMode();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }
}
