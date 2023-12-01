package com.yashproject.payment.Repository;

import com.yashproject.payment.Model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    public Payment addPayment(Payment payment){
        payments.add(payment);
        return payment;
    }

    public List<Payment> findPayments(){
        return payments;
    }

    public boolean pay(Payment payment){
        for(Payment p: payments){
            if(p.getGame().equals(payment.getGame())){
                return p.getCost() == payment.getCost();
            }
        }
        return false;
    }
}
