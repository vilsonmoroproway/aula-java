/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aula1.controllers;

import aula1.dao.TurmaDao;
import aula1.modelos.Aluno;
import aula1.modelos.Curso;
import aula1.modelos.Turma;

/**
 *
 * @author aluno
 */
public class TurmaController {
   // private final TurmaDao turmaDao = new TurmaDao();
    
    public void matricular(Aluno aluno, Curso curso){
        //verificar se data de finalização da turma é maior que data atual
        
        //chamar TurmaDao
        Turma turma = new Turma();
        turma.setAluno(aluno);
        turma.setCurso(curso);
        
        TurmaDao turmaDao = new TurmaDao();
        turmaDao.salvar(turma);
    }
}
