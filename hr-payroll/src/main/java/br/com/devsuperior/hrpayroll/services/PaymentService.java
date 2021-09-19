package br.com.devsuperior.hrpayroll.services;

import br.com.devsuperior.hrpayroll.config.AppConfig;
import br.com.devsuperior.hrpayroll.dto.Worker;
import br.com.devsuperior.hrpayroll.entities.Payment;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PaymentService {

    private RestTemplate restTemplate;

    private AppConfig appConfig;

    public Payment getPayment(Long workerId, int days){
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());

        ResponseEntity<Worker> forEntity = restTemplate
                .getForEntity(appConfig.getWorkerHost() + "/workers/{id}", Worker.class, uriVariables);
        return Payment.builder().name(forEntity.getBody().getName()).dailyIncome(forEntity.getBody().getDailyIncome())
                .days(days).build();
    }
}
