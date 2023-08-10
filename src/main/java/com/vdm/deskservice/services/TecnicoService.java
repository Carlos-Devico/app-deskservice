package com.vdm.deskservice.services;

import com.vdm.deskservice.domain.Pessoa;
import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.dtos.TecnicoDTO;
import com.vdm.deskservice.repositories.PessoaRepository;
import com.vdm.deskservice.repositories.TecnicoRepository;
import com.vdm.deskservice.services.exceptions.CpfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

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

    public Tecnico criar(TecnicoDTO dto) {
        dto.setId(null);
        validaPorCfpEmail(dto);
        Tecnico newObj = new Tecnico(dto);
        return tecnicoRepository.save(newObj);
    }

    private void validaPorCfpEmail(TecnicoDTO dto) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(dto.getCpf());
        if (obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new CpfException("Cpf ja cadastrado no Sistema!");
        }
        obj = pessoaRepository.findByEmail(dto.getEmail());
        if (obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new CpfException("Email ja cadastrado no Sistema!");
        }
    }
}
