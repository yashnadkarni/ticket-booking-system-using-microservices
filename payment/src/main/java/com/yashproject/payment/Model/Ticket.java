package com.yashproject.payment.Model;

public class Ticket {
    private String game;
    private int ticketCount;

    public Ticket() {
    }

    public Ticket(String game, int ticketCount) {
        this.game = game;
        this.ticketCount = ticketCount;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }
}
