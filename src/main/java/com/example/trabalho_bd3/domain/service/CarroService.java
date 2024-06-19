package com.example.trabalho_bd3.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.trabalho_bd3.domain.dto.carro.CarroRequestDTO;
import com.example.trabalho_bd3.domain.dto.carro.CarroResponseDTO;
import com.example.trabalho_bd3.domain.exception.ResourceNotFoundException;
import com.example.trabalho_bd3.domain.model.Carro;
import com.example.trabalho_bd3.domain.model.Usuario;
import com.example.trabalho_bd3.domain.repository.CarroRepository;

@Service
public class CarroService implements ICRUDService<CarroRequestDTO, CarroResponseDTO> {
    @Autowired
    private CarroRepository carroRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<CarroResponseDTO> obterTodos() {
        Usuario usuario = (Usuario) SecurityContextHolder
       .getContext().getAuthentication().getPrincipal();
       List<Carro> lista = carroRepository.findByUsuario(usuario);
       return lista.stream().map(carro -> mapper.map(carro, CarroResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public CarroResponseDTO obterPorId(Long id) {
        Optional<Carro> optCarro = carroRepository.findById(id);
       if(optCarro.isEmpty()){
        throw new ResourceNotFoundException("Não foi possível encontrar o Carro com o id: " + id);
       }
       Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       if(optCarro.get().getUsuario().getId() != usuario.getId()){
            throw new ResourceNotFoundException("O Carro com o id: " +
            id + "não pertence a esse Usuário");
       }
       return mapper.map(optCarro.get(), CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO cadastrar(CarroRequestDTO dto) {
        Carro carro = mapper.map(dto, 
        Carro.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        carro.setUsuario(usuario);
        carro.setId(null);
        carro = carroRepository.save(carro);
        return mapper.map(carro, CarroResponseDTO.class);
    }

    @Override
    public CarroResponseDTO atualizar(Long id, CarroRequestDTO dto) {
        obterPorId(id);
        Carro carro = mapper.map(dto, 
        Carro.class);
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        carro.setUsuario(usuario);
        carro.setId(id);
        carro = carroRepository.save(carro);
        return mapper.map(carro, 
        CarroResponseDTO.class);
    }

    @Override
    public void deletar(Long id) {
        obterPorId(id);
       carroRepository.deleteById(id);
    }
}
