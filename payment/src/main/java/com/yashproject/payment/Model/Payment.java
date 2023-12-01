package com.yashproject.payment.Model;

public class Payment {
    private String game;
    private int cost;

    public Payment() {
    }

    public Payment(String game, int cost) {
        this.game = game;
        this.cost = cost;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
