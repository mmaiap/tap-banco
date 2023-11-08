package com.unifacisa.banco.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String cpf;

    private String nome;

    private String conta;

    private String agencia;

    private BigDecimal saldo = new BigDecimal(0);

    public void depositar(BigDecimal valor){
        this.saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor) {
        this.saldo = saldo.subtract(valor);
    }

}
