package com.example.trabalho_bd3.domain.Enum;

public enum EMarcaCarro {
    FIAT("FIAT"),
    FORD("FORD"),
    CHEVROLET("CHEVROLET"),
    VOLKSWAGEN("VOLKSWAGEN"),
    HYUNDAI("HYUNDAI");

    private String marca;

    private EMarcaCarro(String marca){
        this.marca = marca; 
    }

    public String getmarca() {
        return marca;
    }
}
