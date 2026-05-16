package com.comercial.agenda.excecoes;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(String msg){
        super(msg);
    }
}
