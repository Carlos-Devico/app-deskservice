package com.vdm.deskservice.repositories;

import com.vdm.deskservice.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository <Tecnico, Integer>{
}
