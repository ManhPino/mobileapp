package com.example.firebasetest;

public class User {
    public String email;
    public String password;
    public String sdt;

    public User(String email, String password, String sdt) {
        this.email = email;
        this.password = password;
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
