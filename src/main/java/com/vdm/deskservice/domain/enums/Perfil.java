package com.vdm.deskservice.domain.enums;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"), TECNICO(2, "ROLE_TECNICO"),CLIENTE(3, "ROLE_CLIENTE");
    private final int codigo;
    private final String descricao;

    Perfil(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod){
        if (cod==null){
            return null;
        }
        for (Perfil x : Perfil.values()){
            if (cod.equals(x.getCodigo())){
                return x;
            }
        }
        throw new IllegalArgumentException("Perfil inválido !");
    }
}
