package com.comercial.agenda.excecoes;

public class ContatoNotFoundException extends RuntimeException{
    public ContatoNotFoundException(String msg){
       super(msg);
    }
}
