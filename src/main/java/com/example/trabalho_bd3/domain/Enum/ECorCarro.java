package com.example.trabalho_bd3.domain.Enum;

public enum ECorCarro{
    PRETO("Preto"),
    BRANCO("Branco"),
    VERMELHO("Vermelho");

    private String cor;

    private ECorCarro(String cor){
        this.cor = cor; 
    }

    public String getCor() {
        return cor;
    }
}

