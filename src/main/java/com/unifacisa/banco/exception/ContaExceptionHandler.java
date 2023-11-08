package com.unifacisa.banco.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ContaExceptionHandler {

    private static final Integer CONTA_ENCONTRADA_EXCEPTION_CODE = 1;

    private static final Integer CONTA_GENERIC_EXCEPTION_CODE = 2;

    @ExceptionHandler(ContaNaoEncontradaException.class)
    public ResponseEntity<Erro> handlerContaNaoEncontradaException(ContaNaoEncontradaException exception) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(getErro(exception, CONTA_ENCONTRADA_EXCEPTION_CODE));
    }

    @ExceptionHandler(ContaException.class)
    public ResponseEntity<Erro> handlerContaException(ContaException exception) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErro(exception, CONTA_GENERIC_EXCEPTION_CODE));
    }

    private Erro getErro(Exception exception, Integer code){
        return new Erro(exception.getMessage(), code);
    }
}
