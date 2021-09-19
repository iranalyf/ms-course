package br.com.devsuperior.hrpayroll.resources;

import br.com.devsuperior.hrpayroll.entities.Payment;
import br.com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor
public class PaymentResource {

    private final PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<?> getPayment(@PathVariable Long workerId, @PathVariable int days){
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }

    public ResponseEntity<?> getPaymentAlternative(Long workerId, int days){
        Payment payment = Payment.builder().name("Brann").dailyIncome(new BigDecimal("400")).days(days).build();
        return ResponseEntity.ok(payment);
    }
}
