package com.example.trabalho_bd3.domain.model;

import com.example.trabalho_bd3.domain.Enum.ECorCarro;
import com.example.trabalho_bd3.domain.Enum.EMarcaCarro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carro")
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarro")
    private Long id;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private EMarcaCarro marca;
    @Column(nullable = false)
    private ECorCarro cor;
    @Column (nullable = false)
    private int potencia;
    @Column(nullable = false)
    private int ano;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    
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
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
