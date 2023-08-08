package com.vdm.deskservice.repositories;

import com.vdm.deskservice.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Integer>{
}
