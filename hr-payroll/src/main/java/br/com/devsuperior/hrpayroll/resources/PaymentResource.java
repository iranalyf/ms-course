package br.com.devsuperior.hrpayroll.resources;

import br.com.devsuperior.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
@AllArgsConstructor
public class PaymentResource {

    private final PaymentService service;

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<?> getPayment(@PathVariable Long workerId, @PathVariable int days){
        return ResponseEntity.ok(service.getPayment(workerId, days));
    }
}
