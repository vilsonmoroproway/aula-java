/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.controllers;

import aula1.dao.AlunoDao;
import aula1.modelos.Aluno;

/**
 *
 * @author aluno
 */
public class AlunoController {
    public static String getSituacao(Aluno aluno){
       if(aluno.getNota() < 7.0){
           return "reprovado";
       }
       return "Aprovado";
    }
    
    public void salvar(Aluno aluno){
        if(aluno.getNome().trim().equals("")){
            throw new IllegalArgumentException("Nome deve ser informado");
        }
        
        if(aluno.getNota() < 0){
            throw new IllegalArgumentException("Nota não pode ser negativa");
        }
        
        if(aluno.getNota() > 10){
            throw new IllegalArgumentException("Notas devem ser entre 0 e 10");
        }
        
        AlunoDao alunoDao = new AlunoDao();
        if(aluno.getId() > 0){
           alunoDao.alterar(aluno);
        }else{            
           alunoDao.salvar(aluno);
        }
    }
}
