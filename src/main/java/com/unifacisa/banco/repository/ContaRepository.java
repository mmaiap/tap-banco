package com.unifacisa.banco.repository;

import com.unifacisa.banco.domain.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    @Query("SELECT c FROM Conta c WHERE c.cpf = :cpf")
    Conta buscarContaPorCpf(@Param("cpf") String cpf);
}
