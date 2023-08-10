package com.vdm.deskservice.controllers;

import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.dtos.Mensagem;
import com.vdm.deskservice.dtos.TecnicoDTO;
import com.vdm.deskservice.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
@CrossOrigin(origins = "http://localhost:4200")
public class TecnicoController {
    @Autowired
    private TecnicoService service;

//      LOCALIZA PELO ID
    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable("id") Integer id){
        if (!service.existById(id))
            return new ResponseEntity(new Mensagem("Não existe !"), HttpStatus.valueOf(HttpStatus.NOT_FOUND.value())) ;
        Tecnico tecnico = service.getOne(id).get();
        return new ResponseEntity(tecnico, HttpStatus.OK);
    }

//    CADASTRAR
    @PostMapping
        public ResponseEntity<TecnicoDTO> criar(@RequestBody TecnicoDTO dto) {
        if (StringUtils.isEmpty(dto.getNome()))
            return new ResponseEntity(new Mensagem("O nome é obrigatório"), HttpStatus.BAD_REQUEST);
        if (dto.getSenha().equals(""))
            return new ResponseEntity(new Mensagem("A senha não pode estar em branco"), HttpStatus.BAD_REQUEST);
        Tecnico obj = service.criar(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
        }

//        LISTAR TODOS O TECNICOS
    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> listaTodos(){
        List<Tecnico>tecnicos = service.listaTodosTecnicos();
        List<TecnicoDTO>dtoList = tecnicos.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
        }
}
