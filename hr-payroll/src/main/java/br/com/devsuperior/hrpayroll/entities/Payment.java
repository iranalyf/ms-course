package br.com.devsuperior.hrpayroll.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@ToString
public class Payment {
    private String name;
    private BigDecimal dailyIncome;
    private Integer days;

    public BigDecimal getTotal(){
        return dailyIncome.multiply(BigDecimal.valueOf(days));
    }
}
