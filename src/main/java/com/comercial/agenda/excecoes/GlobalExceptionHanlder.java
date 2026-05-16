package com.comercial.agenda.excecoes;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(ContatoCampoInvalidoException.class)
    public ResponseEntity<?> tratarCamposInvalidos(
            ContatoCampoInvalidoException ex,
            HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ContatoNotFoundException.class)
    public ResponseEntity<?> contatoNotFound(
            ContatoNotFoundException ex,
            HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
