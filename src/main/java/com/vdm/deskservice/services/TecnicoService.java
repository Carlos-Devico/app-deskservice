package com.vdm.deskservice.services;

import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    public Tecnico localizaPeloId(Integer id) {
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElse(null);
    }

    public boolean existById(int id) {
        return tecnicoRepository.existsById(id);
    }


    public Optional<Tecnico> getOne(Integer id) {
        return  tecnicoRepository.findById(id);
    }

    public Tecnico salvar(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public List<Tecnico> listaTodosTecnicos() {
        return tecnicoRepository.findAll();
    }
}
