package com.unifacisa.banco.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(name = "acoes",url = "${external-service.url}")
public interface AcoesRepository {

    @GetMapping
    Map<String, Object> findExternal();
}
