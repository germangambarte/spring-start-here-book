package com.example.application.controllers;

import com.example.application.exceptions.NotEnoughMoneyException;
import com.example.application.models.ErrorDetails;
import com.example.application.models.PaymentDetails;
import com.example.application.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {
    private final PaymentService paymentService;
    private Logger logger = Logger.getLogger(PaymentDetails.class.getName());

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(
            @RequestBody PaymentDetails paymentDetails
    ) {
        logger.info("Received payment " + paymentDetails.getAmount());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentDetails);
    }
}
