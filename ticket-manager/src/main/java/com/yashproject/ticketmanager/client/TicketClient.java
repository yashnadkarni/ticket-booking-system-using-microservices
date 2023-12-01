package com.yashproject.ticketmanager.client;

import com.yashproject.ticketmanager.model.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface TicketClient {
    @GetExchange("/ticket")
    public List<Ticket> findTickets();
    @PostExchange("/ticket/hold")
    public boolean holdTicket(@RequestBody Ticket ticket);
    @PostExchange("/ticket/holdCancel")
    public boolean cancelHoldTicket(@RequestBody Ticket ticket);

}
