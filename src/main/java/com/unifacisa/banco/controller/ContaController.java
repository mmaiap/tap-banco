package com.unifacisa.banco.controller;

import com.unifacisa.banco.domain.entity.Conta;
import com.unifacisa.banco.domain.entity.ContaDTO;
import com.unifacisa.banco.mapper.ContaMapper;
import com.unifacisa.banco.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api-conta")
public class ContaController {

    private final ContaService service;

    private final ContaMapper mapper;


    @PostMapping()
    public ResponseEntity<ContaDTO> criarConta(@RequestBody Conta conta){
        ContaDTO contaDTO = mapper.domainToDTO(service.criarConta(conta));
        return new ResponseEntity<>(contaDTO, HttpStatus.CREATED);
    }

    @PutMapping(path = "/sacar")
    public ResponseEntity<ContaDTO> sacarDaConta(@RequestParam("cpf") String cpf, @RequestParam("valor") BigDecimal valor){
        ContaDTO contaDTO = mapper.domainToDTO(service.saqueDeConta(cpf, valor));
        return new ResponseEntity<>(contaDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/depositar")
    public ResponseEntity<ContaDTO> depositarNaConta(@RequestParam("cpf") String cpf, @RequestParam("valor") BigDecimal valor){
        ContaDTO contaDTO = mapper.domainToDTO(service.depositarEmConta(cpf, valor));
        return new ResponseEntity<>(contaDTO, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<ContaDTO> listarInformacoesDaConta(@RequestParam("cpf") String cpf){
        ContaDTO contaDTO = mapper.domainToDTO(service.depositarEmConta(cpf, valor));
        return new ResponseEntity<>(contaDTO, HttpStatus.OK);
    }
}
