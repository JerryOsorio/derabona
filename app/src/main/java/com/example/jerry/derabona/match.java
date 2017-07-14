package com.example.jerry.derabona;

/**
 * Created by jerry on 7/13/17.
 */

public class match {
    private String date;
    private String match;
    private String winner;
    private String status;

    public match(){

    }

    public match(String date, String match, String winner, String status){
        this.date = date;
        this.match = match;
        this.winner = winner;
        this.status = status;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
