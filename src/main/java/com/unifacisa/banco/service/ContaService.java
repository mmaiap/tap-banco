package com.unifacisa.banco.service;

import com.unifacisa.banco.domain.entity.Conta;
import com.unifacisa.banco.domain.entity.ContaDTO;
import com.unifacisa.banco.exception.ContaException;
import com.unifacisa.banco.exception.ContaNaoEncontradaException;
import com.unifacisa.banco.mapper.ContaMapper;
import com.unifacisa.banco.repository.AcoesRepository;
import com.unifacisa.banco.repository.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;

    private final AcoesRepository acoesRepository;

    private final ContaMapper mapper;

    public Conta criarConta(Conta conta){

        var contaPorCpf = repository.buscarContaPorCpf(conta.getCpf());

        if(!ObjectUtils.isEmpty(contaPorCpf)){
            throw new ContaException("Conta já existe para esse cpf");
        }

        return repository.save(conta);
    }

    public Conta depositarEmConta(String cpf, BigDecimal valor){

        var conta = repository.buscarContaPorCpf(cpf);

        conta.depositar(valor);

        return repository.save(conta);
    }

    public Conta saqueDeConta(String cpf, BigDecimal valor){

        var conta = repository.buscarContaPorCpf(cpf);

        if (conta.getSaldo().compareTo(valor) < 0){
            throw new ContaException("Saque negado: valor é superior ao saldo");
        }

        conta.sacar(valor);

        return repository.save(conta);
    }

    public Conta buscarInformacoesConta(String cpf){

        var conta = repository.buscarContaPorCpf(cpf);

        if (ObjectUtils.isEmpty(conta)){
            throw new ContaNaoEncontradaException("Conta não encontrada");
        }

        //TODO
        //implementar chamada para serviço de fora

        return conta;
    }
}
