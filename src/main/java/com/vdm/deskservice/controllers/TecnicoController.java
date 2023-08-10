package com.vdm.deskservice.controllers;

import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.dtos.TecnicoDTO;
import com.vdm.deskservice.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {
    @Autowired
    private TecnicoService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
        Tecnico obj = service.localizaPeloId(id);
        return ResponseEntity.ok().body(new TecnicoDTO(obj));

    }
}
