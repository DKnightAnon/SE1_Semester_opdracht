package com.example.se_opdracht.User;

public class User {

    private String UserName;
    private String Email;
    private String password;
    private boolean DarkMode;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getDarkMode() {
        return DarkMode;
    }

    public void getDarkMode(boolean darkMode) {
        DarkMode = darkMode;
    }
}
