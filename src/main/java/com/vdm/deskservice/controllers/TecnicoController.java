package com.vdm.deskservice.controllers;

import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.dtos.Mensagem;
import com.vdm.deskservice.dtos.TecnicoDTO;
import com.vdm.deskservice.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tecnicos")
@CrossOrigin(origins = "http://localhost:4200")
public class TecnicoController {
    @Autowired
    private TecnicoService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable("id") Integer id){
        if (!service.existById(id))
            return new ResponseEntity(new Mensagem("Não existe !"), HttpStatus.NOT_FOUND) ;
        Tecnico tecnico = service.getOne(id).get();
        return new ResponseEntity(tecnico, HttpStatus.OK);
    }
}
