package com.example.trabalho_bd3.domain.dto.carro;

import com.example.trabalho_bd3.domain.Enum.ECorCarro;
import com.example.trabalho_bd3.domain.Enum.EMarcaCarro;

public class CarroRequestDTO {
    private Long id;
    private String modelo;
    private EMarcaCarro marca;
    private ECorCarro cor;
    private int potencia;
    private int ano;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public EMarcaCarro getMarca() {
        return marca;
    }
    public void setMarca(EMarcaCarro marca) {
        this.marca = marca;
    }
    public ECorCarro getCor() {
        return cor;
    }
    public void setCor(ECorCarro cor) {
        this.cor = cor;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
}
