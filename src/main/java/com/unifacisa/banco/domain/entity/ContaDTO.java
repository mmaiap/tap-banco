package com.unifacisa.banco.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private String cpf;

    private BigDecimal saldo;

    private String conta;

    private String agencia;

}
