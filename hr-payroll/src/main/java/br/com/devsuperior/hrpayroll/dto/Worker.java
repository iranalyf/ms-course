package br.com.devsuperior.hrpayroll.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Worker {
    private Long id;
    private String name;
    private BigDecimal dailyIncome;
}
