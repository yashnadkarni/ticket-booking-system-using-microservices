package com.yashproject.ticketmanager.client;

import com.yashproject.ticketmanager.model.Payment;
import com.yashproject.ticketmanager.model.Ticket;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange
public interface PaymentClient {
    @GetExchange("/payment")
    public List<Payment> findPayments();
    @PostExchange("/payment/pay")
    public boolean pay(@RequestBody Payment payment);
}
