package com.vdm.deskservice.repositories;

import com.vdm.deskservice.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{
}
