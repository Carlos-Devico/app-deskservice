package com.vdm.deskservice.repositories;

import com.vdm.deskservice.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository <Chamado, Integer>{
}
