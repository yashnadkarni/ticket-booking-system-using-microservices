package com.yashproject.payment.Controller;

import com.yashproject.payment.Model.Payment;
import com.yashproject.payment.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository repository;

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment){
        return repository.addPayment(payment);
    }

    @GetMapping
    public List<Payment> findPayments(){
        return repository.findPayments();
    }

    @PostMapping("/pay")
    public boolean pay(@RequestBody Payment payment){
        return repository.pay(payment);
    }

}
