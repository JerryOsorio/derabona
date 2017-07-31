package com.example.jerry.derabona;

import java.util.Map;

/**
 * Created by jerry on 7/30/17.
 */

public class user {
    String first_name;
    String last_name;
    String email;
    Map<String , String> wagers;

    public user() {
    }

    public user(String first_name, String last_name, String email, Map<String, String> wagers) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.wagers = wagers;
    }

    public user(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getWagers() {
        return wagers;
    }

    public void setWagers(Map<String, String> wagers) {
        this.wagers = wagers;
    }
}
