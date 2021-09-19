package br.com.devsuperior.hrpayroll.services;

import br.com.devsuperior.hrpayroll.config.AppConfig;
import br.com.devsuperior.hrpayroll.dto.Worker;
import br.com.devsuperior.hrpayroll.entities.Payment;
import br.com.devsuperior.hrpayroll.feignclients.WorkerFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class PaymentService {

    private AppConfig appConfig;

    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, int days){
        ResponseEntity<Worker> byId = workerFeignClient.findById(workerId);
        return Payment.builder().name(byId.getBody().getName()).dailyIncome(byId.getBody().getDailyIncome())
                .days(days).build();
    }
}
