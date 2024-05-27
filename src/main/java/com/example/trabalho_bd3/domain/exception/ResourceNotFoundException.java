package com.example.trabalho_bd3.domain.exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }
}


