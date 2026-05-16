package com.comercial.agenda.excecoes;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHanlder {

    @ExceptionHandler(ContatoCampoInvalidoException.class)
    public ResponseEntity<?> tratarCamposInvalidos(
            ContatoCampoInvalidoException ex,
            HttpServletRequest request){

             ErroResposta erro = new ErroResposta(
                     HttpStatus.BAD_REQUEST.value(),
                     "Campos não informados",
                     ex.getMessage(),
                     request.getRequestURI()
             );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<?> produtoNotFound(
            ProdutoNotFoundException ex,
            HttpServletRequest request){

        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(ContatoNotFoundException.class)
    public ResponseEntity<?> contatoNotFound(
            ContatoNotFoundException ex,
            HttpServletRequest request){
        ErroResposta erro = new ErroResposta(
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarValidacao(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(erro -> {
                    erros.put(
                            erro.getField(),
                            erro.getDefaultMessage()
                    );
                });

        return ResponseEntity.badRequest().body(erros);
    }
}
