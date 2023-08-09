package com.vdm.deskservice.services;

import com.vdm.deskservice.domain.Chamado;
import com.vdm.deskservice.domain.Cliente;
import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.domain.enums.Perfil;
import com.vdm.deskservice.domain.enums.Prioridade;
import com.vdm.deskservice.domain.enums.Status;
import com.vdm.deskservice.repositories.ChamadoRepository;
import com.vdm.deskservice.repositories.ClienteRepository;
import com.vdm.deskservice.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Arrays;

@Service
public class DBServices {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instaciaDB() {
        Tecnico tec1 = new Tecnico(null, "Adrian Costa", "70418453110", "adrian@email.com", "mra123" );
        tec1.addPerfil(Perfil.TECNICO);

        Tecnico tec2 = new Tecnico(null, "Carlinhos Costa", "83637577305", "carlinhos@email.com", "cst123" );
        tec2.addPerfil(Perfil.TECNICO);

        Tecnico tec3 = new Tecnico(null, "Carlos", "28510763615", "carlos@email.com", "crl123" );
        tec3.addPerfil(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Garfield", "51916911641", "gar@email.com", "gar123");
        cli1.addPerfil(Perfil.CLIENTE);

        Cliente cli2 = new Cliente(null, "Ronald Mc Donalds", "88549727628", "mac@email.com", "mac123");
        cli2.addPerfil(Perfil.CLIENTE);

        Cliente cli3 = new Cliente(null, "Bozo", "78327204092", "bozo@email.com", "bz123");
        cli3.addPerfil(Perfil.CLIENTE);

        Chamado ordem1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Pc não liga", "slot de memória queimado", tec1, cli1);
        Chamado ordem2 = new Chamado(null, Prioridade.MEDIA, Status.ABERTO, "Tela Azul", "sistema crashow", tec2, cli2);
        Chamado ordem3 = new Chamado(null, Prioridade.BAIXA, Status.ANDAMENTO, "Computador desligando", "fonte queimada", tec3, cli3);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(ordem1));

        tecnicoRepository.saveAll(Arrays.asList(tec2));
        clienteRepository.saveAll(Arrays.asList(cli2));
        chamadoRepository.saveAll(Arrays.asList(ordem2));

        tecnicoRepository.saveAll(Arrays.asList(tec3));
        clienteRepository.saveAll(Arrays.asList(cli3));
        chamadoRepository.saveAll(Arrays.asList(ordem3));
    }
}
