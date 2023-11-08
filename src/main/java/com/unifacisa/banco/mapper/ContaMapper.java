package com.unifacisa.banco.mapper;

import com.unifacisa.banco.domain.entity.Conta;
import com.unifacisa.banco.domain.entity.ContaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContaMapper {

    ContaDTO domainToDTO(Conta conta);

    Conta toDomain(ContaDTO conta);
}
