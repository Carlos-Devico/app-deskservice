package com.vdm.deskservice;


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
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DeskserviceApplication implements CommandLineRunner {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    public static void main(String[] args) {
        SpringApplication.run(DeskserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tecnico tec1 = new Tecnico(null, "Adrian Costa", "70418453110", "adrian@email.com", "mra123" );
        tec1.addPerfil(Perfil.TECNICO);

        Cliente cli1 = new Cliente(null, "Garfield", "51916911641", "gar@email.com", "gar123");
        cli1.addPerfil(Perfil.CLIENTE);

        Chamado ordem1 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Pc não liga", "slot de memória queimado", tec1, cli1);

        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(ordem1));
    }
}
