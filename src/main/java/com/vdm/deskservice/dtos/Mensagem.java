package com.vdm.deskservice.dtos;

public class Mensagem {
    private String mensagem;

    public Mensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMsg(String mensagem) {
        this.mensagem = mensagem;
    }
}
