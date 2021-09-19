package br.com.devsuperior.hrpayroll.services;

import br.com.devsuperior.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return Payment.builder().name("Bob Dylan").dailyIncome(new BigDecimal("200.00")).days(days).build();
    }
}
