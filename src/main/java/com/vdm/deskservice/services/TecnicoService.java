package com.vdm.deskservice.services;

import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico localizaPeloId(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElse(null);
    }
}
