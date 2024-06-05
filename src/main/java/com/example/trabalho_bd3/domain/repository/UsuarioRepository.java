package com.example.trabalho_bd3.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trabalho_bd3.domain.model.Usuario;

public interface UsuarioRepositoy extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
