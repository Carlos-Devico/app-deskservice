package com.vdm.deskservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vdm.deskservice.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "TECNICO")
public class Tecnico extends Pessoa{
    private static final long serialVersionUID = 1L;
    @JsonIgnore
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tecnico")
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
