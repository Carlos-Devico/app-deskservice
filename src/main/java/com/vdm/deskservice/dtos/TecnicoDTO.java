package com.vdm.deskservice.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vdm.deskservice.domain.Tecnico;
import com.vdm.deskservice.domain.enums.Perfil;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TecnicoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotBlank
    protected String nome;
    @NotBlank
    protected String cpf;
    @NotBlank
    protected String email;
    @NotBlank
    @Min(3)
    protected String senha;

    @Enumerated(EnumType.STRING) // SE DER ERRO RETIRAR ESSA LINHA
    protected Set<Integer> perfis = new HashSet<>();

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public TecnicoDTO() {
        super();
    }

    public TecnicoDTO(Tecnico tec) {
        super();
        this.id = tec.getId();
        this.nome = tec.getNome();
        this.cpf = tec.getCpf();
        this.email = tec.getEmail();
        this.senha = tec.getSenha();
        this.perfis = tec.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCriacao = tec.getDataCriacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfis() {
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfis.add(perfil.getCodigo());
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
//0:27

