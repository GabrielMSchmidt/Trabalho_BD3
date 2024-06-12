package com.example.trabalho_bd3.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalho_bd3.domain.model.Carro;
import com.example.trabalho_bd3.domain.model.Usuario;

import java.util.List;
import com.example.trabalho_bd3.domain.Enum.EMarcaCarro;



public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByUsuario(Usuario usuario);
    List<Carro> findByMarca(EMarcaCarro marca);
}

