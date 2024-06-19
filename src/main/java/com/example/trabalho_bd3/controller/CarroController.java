package com.example.trabalho_bd3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.trabalho_bd3.domain.dto.carro.CarroRequestDTO;
import com.example.trabalho_bd3.domain.dto.carro.CarroResponseDTO;
import com.example.trabalho_bd3.domain.service.CarroService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/carros")
public class CarroController {
    @Autowired
    private CarroService carroService;

    @GetMapping
    public ResponseEntity<List<CarroResponseDTO>> obterTodos(){
        return ResponseEntity.ok(carroService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> obterPorId (@PathVariable Long id){
        return ResponseEntity.ok(carroService.obterPorId(id));
    }

    @PostMapping
    public ResponseEntity<CarroResponseDTO> cadastrar (@RequestBody CarroRequestDTO dto){
        CarroResponseDTO carro = carroService.cadastrar(dto);
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarroResponseDTO> atualizar (@PathVariable Long id, @RequestBody CarroRequestDTO dto){
        CarroResponseDTO carro = carroService.atualizar(id, dto);
        return ResponseEntity.ok(carro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        carroService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
