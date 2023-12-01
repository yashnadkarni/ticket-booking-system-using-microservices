package com.yashproject.ticketmanager.controller;

import com.netflix.discovery.converters.Auto;
import com.yashproject.ticketmanager.client.PaymentClient;
import com.yashproject.ticketmanager.client.TicketClient;
import com.yashproject.ticketmanager.model.Payment;
import com.yashproject.ticketmanager.model.Ticket;
import com.yashproject.ticketmanager.repository.TMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/TicketManager")
public class TMController {

    @Autowired
    private TMRepository tmRepository;
    @Autowired
    private TicketClient ticketClient;
    @Autowired
    private PaymentClient paymentClient;

    @GetMapping("/find-ticket")
    public List<Ticket> findTickets(){
        return ticketClient.findTickets();
    }

    @PostMapping("/hold-ticket")
    public boolean holdTicket(@RequestBody Ticket ticket){
        return ticketClient.holdTicket(ticket);
    }

    @PostMapping("/holdCancel-ticket")
    public boolean cancelHoldTicket(@RequestBody Ticket ticket){
        return ticketClient.cancelHoldTicket(ticket);
    }

    @GetMapping("/find-payment")
    public List<Payment> findPayments(){
        return paymentClient.findPayments();
    }

    @PostMapping("/pay")
    public boolean pay(@RequestBody Payment payment){
        return paymentClient.pay(payment);
    }

}
