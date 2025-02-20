package com.example.application.services;

import com.example.application.exceptions.NotEnoughMoneyException;
import com.example.application.models.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
